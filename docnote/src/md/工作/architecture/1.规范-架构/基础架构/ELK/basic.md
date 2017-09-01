## basic -_ Logback+ELK+SpringMVC搭建日志收集服务器
- https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247484140&idx=2&sn=c48a3144aa11d7acb7ebbe2539902b2e&chksm=9bd0af74aca72662638579bebe27a17bc211819c4023d250b015dca5cdeeea08b4efc83b5a57&scene=21#wechat_redirect


-
- 今天给大家带来的是logback+ELK+SpringMVC 日志收集服务器搭建。接下来我会介绍ELK是什么？logback是什么？以及搭建的流程。

1.ELK是什么？

ELK是由Elasticsearch、Logstash、Kibana这3个软件的缩写。

Elasticsearch是一个分布式搜索分析引擎，稳定、可水平扩展、易于管理是它的主要设计初衷
Logstash是一个灵活的数据收集、加工和传输的管道软件
Kibana是一个数据可视化平台，可以通过将数据转化为酷炫而强大的图像而实现与数据的交互将三者的收集加工，存储分析和可视转化整合在一起就形成了 ELK 。
2.ELK流程

ELK的流程应该是这样的:Logback->Logstash->（Elasticsearch<->Kibana）

应用程序产生出日志，由logback日志框架进行处理。
将日志数据输出到Logstash中
Logstash再将数据输出到Elasticsearch中
Elasticsearch再与Kibana相结合展示给用户
3.ELK官网

https://www.elastic.co/guide/index.html

4. 环境配置

4.1 基础环境

jdk 1.8
Centos 7.0 X86-64 注意：ELK服务不能在root用户开启。需要重新创建用户。 下载ELK相关服务压缩包 创建ELK用户和目录并赋予权限,方便统一管理。
[root@localhost /]# mkdir elsearch
[root@localhost /]# groupadd  elsearch
[root@localhost /]# useradd -g elsearch elsearch
[root@localhost /]# chown -R elsearch:elsearch /elsearch
[root@localhost /]# su elsearch
[elk@localhost /]$ cd elsearch
4.2 下载,然你也可以去官网找最新版的

wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.2.2.tar.gz
wget https://artifacts.elastic.co/downloads/logstash/logstash-5.2.2.tar.gz
wget https://artifacts.elastic.co/downloads/kibana/kibana-5.2.2-linux-x86_64.tar.gz

我这里是以5.2.2为例来实现。

4.3 配置Elasticsearch

Elasticsearch是可以搭建集群,我这边只是解压后直接修改配置文件

elasticsearch.yml

```
cluster.name: es_cluster_1
node.name: node-
path.data: /usr/ local /services/elasticsearch- 5.2 . 2 /data
path.logs:/usr/local/services/elasticsearch-5.2.2/logs
network.host: 192.168 . 10.200
http.port: 9200
```
启动ElasticSearch,访问http://192.168.10.200:9200/
看到如上的界面就代表启动成功。

注意：安装过程中出现一些问题。在这篇文章中已经都给我们解决了。
http://www.cnblogs.com/sloveling/p/elasticsearch.html


4.4 配置logstash

解压

tar -zxvf /usr/
local
/services/logstash-
5.2
.
2.tar
.gz
测试配置,只是测试服务是否启动。还有这个文件是没有的,启动时加上这个路径就是以这个配置启动
vi /usr/local/services/logstash-5.2.2/config/logstash.conf

input {
 stdin { }
}
output {
 stdout {
 codec => rubydebug {}
 }
}
logstash以配置文件方式启动有两种：

列表内容 logstash -f logstash-test.conf //普通方式启动
logstash agent -f logstash-test.conf --debug//开启debug模式
.
/bin/
logstash -f config/logstash.conf --debug
启动成功会看到如下的结果：


4.5 配置logstash

配置kibana

解压
[elsearch@localhost root]$ tar -zxvf /usr/local/services/kibana-5.2.2-linux-x86_64.tar.gz

打开配置
[elsearch@localhost root]$ vim /usr/local/services/kibana-5.2.2-linux-x86_64/config/kibana.yml

修改配置,最后最加

server.port:
8888
server.host:
"192.168.10.200"
elasticsearch.url:
"http://192.168.10.200:9200"
启动

elsearch@localhost root]$ /usr/ local /services/kibana- 5.2 . 2 -linux-x86_64/bin/kibana &

访问地址 http://192.168.10.200:8888

基本ELK的环境的搭建就ok了,我们接下来学习logback-ELK整合来收集JavaEE中的日志。

4.6 logback-ELK整合

4.6.1 本案列采用maven管理
4.6.2配置logaback的配置文件
注意：logstash接收日志的地址192.168.10.200:8082

4.6.3配置logstash-test.conf

vi logstash-test.conf

启动收集

./bin/logstash -f config/logstash-test.conf --debug

4.6.4配置Controller添加日志输出
