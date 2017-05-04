```flow
start=>start: 开始
isLogin=>condition: 是否已登录？
login=>operation: 登陆
selectPic=>operation: 选择一张图片
isPic=>condition: 格式是否正确？
doIt=>operation: 完成资料
isRight=>condition: 资料是否符合要求？
end=>end: 完成

start->isLogin
isLogin(yes)->selectPic
isLogin(no)->login->selectPic
selectPic->isPic
isPic(yes)->doIt->isRight
isPic(no)->selectPic
isRight(yes)->end
isRight(no)->doIt
```

- 节点名称=>节点类型: 提示文本
  - 节点名称可随意起，甚至支持中文。提示文本可以为英文，可以为中文，也可以为空使用默认值。
  - 节点类型有start、operation、condition、end等
  -
- 节点连接
  - 一般节点连接：
  ```
    节点->节点
    条件判断节点连接：
    条件节点(yes)->正确应答节点
    条件节点(no)->错误应答节点
  ```
