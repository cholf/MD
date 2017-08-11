## 改qconfig
```
   @QConfig("switch.properties")
   private Map<String, String> switchMap;

   @FuWuQConfig(file = "switch.properties", key = "reTyrTimes", defaultVal = "5")
   private int reTyrTimes;
```
