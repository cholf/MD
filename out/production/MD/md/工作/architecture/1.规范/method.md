```
// 方法实现 return null
public Person readPerson(String name) {
    if (name == null) {
        return null;
    }
    ...
}
// 方法调用 check null
public void doSomethong() {
    Person person readPerson("tom");
    if (person != null) {
        person.doSomething();
    }
    ...
}


/**
 * 读取Person信息
 * @param name
 * @return
 * @throws NotFoundException 如果没有找到抛出
 * @throws NullPointerException 如果name为空抛出
 */
public Person readPerson(String name) throws NotFoundException {
    if (name == null) {
        throw NullPointerException();
    }
    ...
}
// 在外围用 try-catch 处理异常
public void doSomethong() {
    try {
        Person person = readPerson("tom");
        person.doSomething();
        ...
    } catch(NotFoundException ex) {
        ...
    } catch (Exception ex) {
        ...
    }
}

```
