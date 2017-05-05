
# Awk命令
- 搜索订单:
  - awk  -F:'/tys170406162629207001/' flightorder.log
- 统计出现数量:
  - awk -F : '/sub170429233056399/{count++} END{print "count:",count}'   flightorder.log
-
