###


018-03-29 11:49:35.030 [destination = tts_beta34825 , address = l-noahqjlgw5pa1.auto.beta.cn0.qunar.com/10.93.35.35:3306 , EventParser] ERROR c.a.o.canal.parse.inbound.mysql.dbsync.DirectLogFetcher - I/O error while reading from client socket
java.io.IOException: Received error packet: errno = 1236, sqlstate = HY000 errmsg = Could not find first log file name in binary log index file
        at com.alibaba.otter.canal.parse.inbound.mysql.dbsync.DirectLogFetcher.fetch(DirectLogFetcher.java:95) ~[canal.parse-1.0.16.jar:na]
        at com.alibaba.otter.canal.parse.inbound.mysql.MysqlConnection.dump(MysqlConnection.java:116) [canal.parse-1.0.16.jar:na]
        at com.alibaba.otter.canal.parse.inbound.AbstractEventParser$3.run(AbstractEventParser.java:208) [canal.parse-1.0.16.jar:na]
        at java.lang.Thread.run(Thread.java:744) [na:1.7.0_45]
2018-03-29 11:49:35.030 [destination = tts_beta34825 , address = l-noahqjlgw5pa1.auto.beta.cn0.qunar.com/10.93.35.35:3306 , EventParser] ERROR c.a.otter.canal.parse.inbound.mysql.MysqlEventParser - dump address l-noahqjlgw5pa1.auto.beta.cn0.qunar.com/10.93.35.35:3306 has an error, retrying. caused by
java.io.IOException: Received error packet: errno = 1236, sqlstate = HY000 errmsg = Could not find first log file name in binary log index file
        at com.alibaba.otter.canal.parse.inbound.mysql.dbsync.DirectLogFetcher.fetch(DirectLogFetcher.java:95) ~[canal.parse-1.0.16.jar:na]
        at com.alibaba.otter.canal.parse.inbound.mysql.MysqlConnection.dump(MysqlConnection.java:116) ~[canal.parse-1.0.16.jar:na]
        at com.alibaba.otter.canal.parse.inbound.AbstractEventParser$3.run(AbstractEventParser.java:208) ~[canal.parse-1.0.16.jar:na]
        at java.lang.Thread.run(Thread.java:744) [na:1.7.0_45]
2018-03-29 11:49:35.031 [destination = tts_beta34825 , address = l-noahqjlgw5pa1.auto.beta.cn0.qunar.com/10.93.35.35:3306 , EventParser] ERROR com.alibaba.otter.canal.common.alarm.LogAlarmHandler - destination:tts_beta34825[java.io.IOException: Received error packet: errno = 1236, sqlstate = HY000 errmsg = Could not find first log filename in binary log index file
        at com.alibaba.otter.canal.parse.inbound.mysql.dbsync.DirectLogFetcher.fetch(DirectLogFetcher.java:95)
        at com.alibaba.otter.canal.parse.inbound.mysql.MysqlConnection.dump(MysqlConnection.java:116)
        at com.alibaba.otter.canal.parse.inbound.AbstractEventParser$3.run(AbstractEventParser.java:208)
        at java.lang.Thread.run(Thread.java:744)
]
