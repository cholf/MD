## lombok插件开发
- 在Refactor->Lombok/Delombok中添加新注解PrimaryKey的功能（这个不加也没关系，只是自动添加注解而已）
- 已经添加了PrimaryKey注解的类，其成员方法内部可以提示PrimaryKey.keyName中设定的字段，以及相应的Getter/Setter方法


#### 解决:
- 第一点就是在Intellij的现有菜单中扩展新项目而已，只需要定义好Action和相应的Handler，然后在plugin.xml中添加相应的配置即可，就不详述了，有需要可以参考git代码

- 第二点是我们关心的功能，让idea识别由lombok新增的字段，并且当PrimaryKey中的设置项发生变化时，提示也会自动更新。


#### 原理

默认情况下，lombok会为每一个插件提供独立的classloader，插件之间的运行环境互不干涉，当插件之间需要进行数据交换时，可以通过注册endPoint来实现。lombok的intellij插件已经做好了这方面的配置，我们只要在其基础上做扩展即可。

当发生编辑事件时，lombok插件注册好的LombokAugmentProvider会被调用，Intellij会将LombokAugmentProvider返回的结果添加到提示结果集中去

在LombokAugmentProvider内部，会调用所有注册的processor，将满足调用条件的结果集呈递给Intellij


因此，插件开发的主要工作就是实现相应的Processors，在响应方法和字段的事件时，动态创建主键字段和getter/setter方法，使之出现在智能提示结果中即可。

添加自定义注解

首先，在LombokImplicitUsageProvider中，添加自定义的注解申明。

```
public class LombokImplicitUsageProvider implements ImplicitUsageProvider {

  private static final List<Class<? extends Annotation>> ANNOTATIONS = Arrays.asList(
      lombok.experimental.Accessors.class, lombok.experimental.Builder.class, lombok.experimental.Delegate.class,
      lombok.experimental.ExtensionMethod.class, lombok.experimental.FieldDefaults.class,
      lombok.experimental.NonFinal.class, lombok.experimental.PackagePrivate.class,
      lombok.experimental.Tolerate.class, lombok.experimental.UtilityClass.class,
      lombok.experimental.Value.class, lombok.experimental.Wither.class,
      lombok.AllArgsConstructor.class, lombok.Builder.class,
      lombok.Cleanup.class, lombok.Data.class,lombok.PrimaryKey.class, // 自定义类型
      lombok.Delegate.class, lombok.EqualsAndHashCode.class,
      lombok.Getter.class, lombok.NoArgsConstructor.class,
      lombok.NonNull.class, lombok.RequiredArgsConstructor.class,
      lombok.Setter.class, lombok.SneakyThrows.class,
      lombok.Synchronized.class, lombok.ToString.class,
      lombok.Value.class);

  private static final Collection<String> FIELD_ANNOTATIONS = new HashSet<String>();
  private static final Collection<String> METHOD_ANNOTATIONS = new HashSet<String>();
  private static final Collection<String> CLASS_ANNOTATIONS = new HashSet<String>();
```
创建Processors

随后，生成两个Processor（PrimaryKeyFieldProcessor和PrimaryKeyProcessor），使它们继承自AbstractClassProcessor，同时实现validate和generatePsiElement方法。在继承时，两者需要注明处理的注解以及分类。

```
() {
  (.PsiField.)}；

  ```
  ```
  PrimaryKeyProcessor() {
  (.PsiMethod.)}

  ```


PsiField.class和PsiMethod.class分别表明这两个processor是在处理字段和处理方法时会被激活。validate方法是用来判断processor是否需要起作用，当确认满足触发条件时，就会调用generatePsiElement方法，实现对提示结果的扩展。

获取注解的方法值

由于主键字段是根据注解中设置的值动态创建的，所以这里还涉及到读取注解值的问题。

读取主键名称的方法很简单，直接复用PsiAnnotationUtil中的方法即可，如下：
```
String keyName = PsiAnnotationUtil.(psiAnnotation)
```

但是，如果定义了keyType，要想动态获取keyType就稍微麻烦一些，因为PsiAnnotationUtil只提供了对简单值的处理。在查阅了相关文档之后，我发现了一个方法，可以获取到注解中设置的keyType值，如下所示：

```
keyType  = (() psiAnnotation.findAttributeValue()).getOperand().getType()
```


至此，插件开发的难点全部击破。将代码打包，插件就完成了。
