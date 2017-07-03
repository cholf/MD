# 去掉set,get

```

//这样就能去掉set get方法了，简洁明了
@Setter
@Getter
public class User {
    private String username;
    private int age;
}

@Accessors(chain = true)//链式处理
...
@Builder
...
等等好用的东西
```

<font color='red'> 备注::@Data,@AllArgsConstructor,@NoArgsConstructor.........lombok教程: https://projectlombok.org/features/index.html  </font>
