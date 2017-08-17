## base
- jps:查看虚拟机进程状况
  sudo -utomcat jps -lv

- jstat:监控统计信息（类装载、垃圾收集、运行期编译状况）
  - 查看垃圾收集状况（容量):sudo -utomcat jstat -gc 10806  1000 10
  - 查看垃圾收集状况（百分比):sudo -utomcat jstat -gcutil 10806  1000  10
  -
  
- jmap:查看内存映像
  - 查询java堆详细信息:sudo -utomcat jmap -heap 10806
  - 查询java堆中对象统计信息:sudo -utomcat jmap -histo 12258
  - dump内存快照:sudo -utomcat jmap -F -dump:format=b,file=/tmp/dump 22939
  -
- jstack
  查看线程栈:sudo -utomcat jstack 9996（进程id） | grep -A10 29fa（线程id）
