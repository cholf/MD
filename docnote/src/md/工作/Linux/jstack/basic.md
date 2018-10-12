# well-known
```
jstack -l  4454
log: 4454:well-known file is not secure
solution:sudo  jstack -u tomcat 4454
```


25358  

## 实际问题问题

- 未响应
```sh
[gangwen.xu@l-ttsmng2.f.cn6 ~]$ sudo  jstack -l 23728
23728: Unable to open socket file: target process not responding or HotSpot VM not loaded
The -F option can be used when the target process is not responding
```
#### 解决
```sh
sudo  -u  tomcat jstack -l 6027
```

- 卡死

-



# jstack -h
```
➜  ~ jstack -h
Usage:
    jstack [-l] <pid>
        (to connect to running process)
    jstack -F [-m] [-l] <pid>
        (to connect to a hung process)
    jstack [-m] [-l] <executable> <core>
        (to connect to a core file)
    jstack [-m] [-l] [server_id@]<remote server IP or hostname>
        (to connect to a remote debug server)

Options:
    -F  to force a thread dump. Use when jstack <pid> does not respond (process is hung)
    -m  to print both java and native frames (mixed mode)
    -l  long listing. Prints additional information about locks
    -h or -help to print this help message

```
