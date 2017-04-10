
## qconfig的源码及原理

	AbstractDataLoader这个类，在程序加载时，会首先执行static里的内容，包括
1. 定义client.poll.periodInSeconds，默认为60s；

2. client.threads，默认为4,；

3. 读取所有的本地文件，保存为map<Meta, VersionProfile>；

4. 其次检查本地和远端版本号是否一致，checkMap；

5. 最后启动定时任务，periodInSeconds秒主动去拉取server端的最新版本，通过http请求

 qconfig获取配置文件内容的两种方式，

 ##### 一. 是amin端的推送(当人工修改qconfig admin时)，当然只是一个通知，通知client去拉取，通过watcherservelet实现的；
 ##### 二. 是client端的定时任务，去拉取，还有当server端的内容有变化时，client也会去拉取并更新；

	qconfig的使用方式，
1. 可以是xml的方式；

2. 也可以是注解的方式，注解@Qconfig("文件名")，QConfigAnnotationProcessor注解解析器，通过识别该注解，只对String，properties，map这三种类型解析文件内容，获得Mapconfig对象，添加一个listener，将文件内容赋给被注解标注的bean对象；

3. 还可以是原生api的方式，和MapConfig这个类有关系，其中ref是一个动态的map，每次有变化时会自动更新，见setData这个方法，与future有关。程序中可通过Mapconfig.get("文件名").asMap直接获得这个ref
