# Sequence


- 设置title，采用title: message。
- 设置participant，采用participant: actor
- 设置note
```
左侧note： note left of acotor： message
右侧note： note right of actor: message,
覆盖note： note over actor:message{eg:note over a,b:test}
```
- 设置会话
```
实线实箭头： actor->actor: message
虚线实箭头： actor–>actor:message
实线虚箭头： actor->>actor:message
虚线虚箭头： actor–>>actor:message
```
- eg:
```sequence
Title:测试时序图
徐-->刚:测试虚线
徐-->刚:测试虚线
note left of 徐:左测试
刚-->文:测试虚线(修改)
文->>刚:测试返回实线
文-->徐:测试返回虚线(修改)
note  right of 文:右测试
note  over  刚,文:夸测试
note  over  徐,文:夸测试
```
