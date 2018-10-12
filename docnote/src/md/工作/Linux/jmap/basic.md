
## jmap --内存分析

- 命令
  - sudo -u tomcat jmap dump:format=b,file=/home/q/www/f_fuwu_smsnotice/logs/dump.bin  11466
  - dump:format=b--格式化为二进制


  - sudo  -u  tomcat  jmap -dump:format=b,file=test.bin 25352
  -  Error attaching to core file: Can't attach to the core file
     - 解决去自己的权限的目录


- 远程拷贝
  - 命令: scp gangwen.xu@xxx:/*zip   /home/*
  - 注意:确定目录权限


- 分析
  - 工具:Eclipse Memory Analyzer(各个平台都有版本)
  - 分析过程:



jmap -permstat <pid     -- PermGen space



- 结论:
