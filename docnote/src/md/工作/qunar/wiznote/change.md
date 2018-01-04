## 一. 改签：
fuwugq项目中的后门：
- 修改改签小状态
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateStatus?gqId=3347063&status=5&flightStatus=5'
备注：flightdata查id;注意有个派单的状态；
- 修改用户单大状态(N单), 更改tts订单大状态，只支持从改签申请中到改签完成或出票完成
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatus?orderNo=xuy160807065522841&domain=xuy.trade.qunar.com&fromStatus=40&toStatus=42'
- 修改派单大状态(F单), 更改tts派单订单大状态，只支持从改签申请中到改签完成或出票完成
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatusForFlight?orderNo=xuy160724221218417001&domain=xuy.trade.qunar.com&fromStatus=40&toStatus=42'
## 二. 退款：
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=lms.trade.qunar.com&orderNo=lms161228110810735&fromStatus=31&toStatus=39"
注解：

1.支付成功等待出票(出票中)——————退款完成   ：需要提前改到未出票申请退款（50）再到退款完成

2.出票完成到------退款完成，需要先到，30（退款待确认）-31（待退款）-39（退款完成）

三，批量脚本


#!/bin/sh
for line in $(cat data.txt)
do
echo ${line}
echo "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain="${line:0:3}".trade.qunar.com&orderNo="${line}"&fromStatus=1&toStatus=50"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain="${line:0:3}".trade.qunar.com&orderNo="${line}"&fromStatus=1&toStatus=50"
echo "\n"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain="${line:0:3}".trade.qunar.com&orderNo="${line}"&fromStatus=5&toStatus=50"
echo "\n"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain="${line:0:3}".trade.qunar.com&orderNo="${line}"&fromStatus=50&toStatus=39"
echo  "\n"
done


虚拟状态
 curl  ' http://192.168.48.192:8080/refundcore/deleteVirtualStatus?orderNo=psl161123221307038&status=4'
