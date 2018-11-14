
# Awk命令
### Short for "Aho, Weinberger, and Kernighan,"
- 搜索订单:
  - awk  -F:'/tys170406162629207001/' flightorder.log
- 统计出现数量:
  - awk -F : '/sub170429233056399/{count++} END{print "count:",count}'   flightorder.log
- 统计日志相关记录数-排序-去重
cat  te.t  | grep "orderNo" |  awk -F 'orderNo:' '{print $2}'    | sort  | uniq | wc -l
