Â值班：
atnodes  "zgrep '[f_tgq_center_170519.082149.10.86.236.113.10696.686131_1]' /home/q/www/fuwu_tgq_center/logs/fuwu_tgq_center_error.2017-05-19.log"  l-fwtgqcenter[1-4].f.cn8
atnodes  "zgrep 'xep170809224431567' /home/q/www/fuwu_tgq_center/logs/fuwu_tgq_center.2017-08-15-15.log.gz"  l-fwtgqcenter[1-4].f.cn8
atnodes  "grep -A 20'http 500 error' /home/q/www/orderadmin/logs/fuwu_order_admin.log"  l-qmorder[1-16].f.cn1

all_refund_scan check_ticket_return_product

grep zgrep 'f_fuwu_gq_170908.122018.192.168.19.73.31386.516552' /home/q/www/fuwu_gq/logs/fuwugq.2017-09-08-12.log.gz" l-fuwugq[1-4].f.cn1
atnodes  "zgrep 'hiy170806204553410' /home/q/www/fuwu_refund_core/logs/fuwu_refund_core_error.2017-08-28-14
.log.gz" l-fwrefundcore[1-4].f.cn8

atnodes  "zgrep 'ffs180104222156785' /home/q/www/f_fuwu_flightorder/logs/flightorder.log.2018-01-04-22.gz"   l-fuwuflightorder[1-8].f.cn5

 atnodes  "zgrep 'ffs180104222156785' /home/q/www/f_fuwu_flightorder/logs/flightorder.log.2018-01-04-22.gz"   l-fuwuflightorder[1-8].f.cn5 l-fwrefundstandard[1-4].f.cn8



atnodes  "zgrep 'cqh180103115637442'  /home/q/www/f_fuwu_pay/logs/catalina.out.2018-01-08-16.gz" l-fuwupay[1-4].f.cn5

atnodes  "zgrep  'f_fuwu_gq_180104.225026.192.168.19.73.27008.1576812_1' /server/tts/logs/tts.log.2018-01-04-22.gz" l-fuwutts[1-10].f.cn1
l-fworderdetail4.f.cn1
atnodes "zgrep 'f_fuwu_orderSite_180105.092654.10.88.182.197.9613.6102481_1'  /home/q/www/f_fuwu_flightorder/logs/flightorder.log.2018-01-05-09.gz"  l-fuwuflightorder[1-8].f.cn5
atnodes "grep 'cme180104213004993'  /home/q/www/fuwu_orderapp/logs/fuwu_orderapp.log"   l-fuwuorderapp[1-10].f.cn1
atnodes "grep 'post to url=' /home/q/www/f_fuwu_pay/logs/catalina.out"  l-qmrefund[3-5].f.cn1

atnodes  "grep 'xep180109155113683' /home/q/www/fuwu-platform-ui/logs/catalina.out.2018-01-09.gz" l-fuwuui[1-4].f.cn1

atnodes  " zgrep 'ffs180104222156785' /home/q/www/fuwu_gq/logs/fuwugq.2018-01-04-22.log.gz"  l-fuwugq[1-4].f.cn1

atnodes  "zgrep 'getDelayInsuranceRefundUrl refundUrl' /home/q/www/fuwu_tgq_center/logs/fuwu_tgq_center.2018-01-10-20.log.gz"  l-fwtgqcenter[1-4].f.cn8



atnodes  "zgrep '7610603df6084621aecf29f6acf2859e' /DATA_LOG_FLIGHT/CN1_fuwu_gq/*/201706/fuwugq.2017-06-20-01.log.gz" l-flighttouch[1-4].f.cn1

atnodes  "grep  '008868559539388' /home/q/www/fuwu_refund_core/logs/fuwu_refund_core.2018-01-09-17.log " l-fwrefundcore[1-4].f.cn8

atnodes "zgrep 'xep180109155113683' /home/q/www/f_fuwu_order_site/logs/ordersite.log.2018-01-09-*.gz " l-fuwuordersite[1-4].f.cn5

zgrep "鉴权 url" ./CN5_fuwu_order_site/*/201706/ordersite.log.2017-06-24*.gz | grep -o "&r=5" | wc -l
zgrep "xuy170704082033789" ./CN5_fuwu_order_site/*/201707/ordersite.log.2017-07-05-08.gz
zgrep "f_fuwu_orderSite_170705.085542.10.88.182.197.18443.324534_1" ./CN5_fuwu_order_site/*/201707/ordersite.log.2017-07-05-08.gz |grep "transFormFlightInfo"

zgrep "doa170715001925600" ./CN1_fuwu_gq/*/201707/fuwugq.2017-07-19-13.log.gz | grep "SHA" | grep "13:40"|more
zgrep "f_nflagship_ticket_170720.172602.10.86.216.137.11617.2761372_1" ./CN1_fuwu_gq/*/201707/fuwugq.2017-07-20-17.log.gz|more
zgrep "notify order Sign" ./CN1_fuwuttstask/*/20170724/tts.log.2017-07-24-11.gz |more
zgrep "rhs170804094534912" ./CN1_fuwuttstask/*/201708/today.2017-08-04-09.gz |more

zgrep "sub170624230937680" ./CN8_fuwu_refund_core/*/201706/fuwu_refund_core.2018-01-09-15.log


f_fuwu_orderSite_180105.092654.10.88.182.197.9613.6102481_1
账户清理：
select * from f_refund_record where status = 0
l-fuwuflightorder1.f.cn5
curl "127.0.0.1:8080/conf/update.jsp"
curl "127.0.0.1:8080/config/update.jsp"

425 427
导出：
fuwu_orderapp_cache
key：count_order_export+domian
curl "127.0.0.1:8080/CM.jsp?domain=xau.trade.qunar.com"

解冻：
http://l-fuwuunfreeze1.f.cn1.qunar.com:8080/backdoor/unfreezeWithoutVerify?orderNo=znh150201143746739

2017-08-04 09:46:03,701 INFO  QTraceId[f_fuwu_coreserv_170804.094603.192.168.19.230.15954.15022207_1]-QSpanId[1.1] servlet.UserTraceFilter [http-8080-15] [rhs.trade.qunar.com] [] [] - 9c8d681f0008407fbf976829460f5693 ip=120.132.35.111, name=, site=rhs.trade.qunar.com, request=/tts/interface/updateorder.jsp?password=lichengtao527&orderdata=<OrderList><OrderDetail status="2" no="rhs170804094534912001" errorCode="" errorMsg=""><passenger name="马露雨" no="3.1415926" cano="null" /><passenger name="马堡江" no="3.1415926" cano="null" /></OrderDetail></OrderList>&username=mdbq6915&

重发账单给代理商
curl 'http://10.88.65.134:8080/fsb/action/redoexcel?date=2017-08-30&merchant=newttsppgg&force=true&mail=true'
curl 'http://10.88.65.134:8080/fsb/action/download?date=2017-08-30&merchantCode=newttsppg'
重启机器脚本：
sudo /home/q/tools/bin/restart_tomcat.sh f_fuwu_pay


状态修改：
一. 改签：改签
l-fuwugq1.f.cn1.qunar.com
fuwugq项目中的后门：
修改改签小状态
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateStatus?gqId=5636295&status=5&flightStatus=5'
备注：flightdata查id;注意有个派单的状态；
修改用户单大状态(N单), 更改tts订单大状态，只支持从改签申请中到改签完成或出票完成
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatus?orderNo=xep170604115818917&domain=xep.trade.qunar.com&fromStatus=40&toStatus=2'
修改派单大状态(F单), 更改tts派单订单大状态，只支持从改签申请中到改签完成或出票完成
curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatusForFlight?orderNo=xuy160724221218417001&domain=xuy.trade.qunar.com&fromStatus=40&toStatus=42'

curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatus?orderNo=xuy171227203326050&domain=xuy.trade.qunar.com&fromStatus=40&toStatus=42'
二. 退款：
N单：
l-fwrefundcore1.f.cn8

curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=jxp.trade.qunar.com&orderNo=jxp170803124520631&fromStatus=2&toStatus=30"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=jxp.trade.qunar.com&orderNo=jxp170803124520631&fromStatus=30&toStatus=31"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=jxp.trade.qunar.com&orderNo=jxp170803124520631&fromStatus=31&toStatus=39"


curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=xuy.trade.qunar.com&orderNo=xuy170726082137543&fromStatus=50&toStatus=39"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=xuy.trade.qunar.com&orderNo=xuy170726082137543&fromStatus=1&toStatus=50"

F单：
l-fwrefundcoreflight1.f.cn8

curl "http://192.168.57.18:8080/refundcoreflight/updateOrderStatus?domain=ysh.trade.qunar.com&orderNo=ysh170731175128644001&fromStatus=5&toStatus=30"
curl "http://192.168.57.18:8080/refundcoreflight/updateOrderStatus?domain=ysh.trade.qunar.com&orderNo=ysh170731175128644001 &fromStatus=30&toStatus=31"
curl "http://192.168.57.18:8080/refundcoreflight/updateOrderStatus?domain=ysh.trade.qunar.com&orderNo=ysh170731175128644001 &fromStatus=31&toStatus=39"

curl "http://192.168.57.18:8080/refundcoreflight/updateOrderStatus?domain=ysh.trade.qunar.com&orderNo=ysh170731175128644001&fromStatus=5&toStatus=50"
curl "http://192.168.57.18:8080/refundcoreflight/updateOrderStatus?domain=ysh.trade.qunar.com&orderNo=ysh170731175128644001&fromStatus=50&toStatus=39"

注解：
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=lah.trade.qunar.com&orderNo=lah170601071206897&fromStatus=2&toStatus=30"

1.支付成功等待出票(出票中)——————退款完成   ：需要提前改到未出票申请退款（50）再到退款完成

2.出票完成（2）到------退款完成，需要先到，30（退款待确认）-31（待退款）-39（退款完成）
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=xfx.trade.qunar.com&orderNo=xfx161117141138528&fromStatus=30&toStatus=2"
curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=yyw.trade.qunar.com&orderNo=yyw171115111540037&fromStatus=2&toStatus=30"

curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=mxw.trade.qunar.com&orderNo=mxw171215192908399&fromStatus=30&toStatus=2"
    BOOK_OK(0, "订座成功等待支付", NationalUserOrderStatus.PLEASE_PAY),
    PAY_OK(1, "支付成功等待出票", NationalUserOrderStatus.PAY_TICKET_FINISH),
    TICKET_OK(2, "出票完成", NationalUserOrderStatus.PAY_TICKET_FINISH),
    TICKET_LOCK(5, "出票中", NationalUserOrderStatus.PAY_TICKET_FINISH),
    CANCEL_OK(12, "订单取消", NationalUserOrderStatus.ORDER_CANCEL),
    WAIT_CONFIRM(20, "等待座位确认", NationalUserOrderStatus.ORDER_ACCEPT),
    APPLY_REFUNDMENT(30, "退票申请中", NationalUserOrderStatus.REFUND_TICKET_ACCEPT),
    WAIT_REFUNDMENT(31, "退票完成等待退款", NationalUserOrderStatus.REFUND_TICKET_ACCEPT),
    REFUND_OK(39, "退款完成", NationalUserOrderStatus.REFUND_MONEY_FINISH),
    APPLY_CHANGE(40, "改签申请中", NationalUserOrderStatus.CHANGE_ACCEPT),
    CHANGE_OK(42, "改签完成", NationalUserOrderStatus.CHANGE_FINISH),
    APPLY_4_RETURN_PAY(50, "未出票申请退款", NationalUserOrderStatus.REFUND_TICKET_ACCEPT),
    ORDER_SUCCESS_WAIT_4_PRICE_CONFIRM(51, "订座成功等待价格确认", NationalUserOrderStatus.ORDER_ACCEPT),


    BOOK_OK(0, "订座成功等待支付", "订座已完成，请尽快付款。"),
    PAY_OK(1, "支付成功等待出票", "您已购票完成，请放心安排出行计划。"),
    TICKET_OK(2, "出票完成", "您的订单已完成出票，请放心安排出行计划。"),
    TICKET_LOCK(5, "出票中", "您已购票完成，请放心安排出行计划。"),
    CANCEL_OK(12, "订单取消", "订单已取消，如果您还需要购票，请返回去哪儿网再次查询预订。"),
    WAIT_CONFIRM(20, "等待座位确认", "您的订单已受理，将在30分钟内完成确认，结果会通过短信通知。"),
    APPLY_REFUNDMENT(30, "退款待确认", "您已申请退票，代理商会在1个工作日内处理您的订单。"),
    WAIT_REFUNDMENT(31, "待退款", "您的退款申请已经受理，代理商将在72小时内进行退款操作，结果会通过短信通知您，请保持手机畅通。"),
    REFUND_OK(39, "退款完成", "已完成退款操作。"),
    APPLY_CHANGE(40, "改签申请中", "您已申请航班改签，代理商会在48小时内与您联系，请保持手机畅通。"),
    CHANGE_OK(42, "改签完成", "您的订单已完成改签，请放心安排出行计划。"),
    APPLY_4_RETURN_PAY(50, "未出票申请退款", "您的退款申请已经受理，结果会通过短信通知您，请保持手机畅通。"),
    ORDER_SUCCESS_WAIT_4_PRICE_CONFIRM(51, "订座成功等待价格确认", "您的订单已受理，将在30分钟内完成确认，结果会通过短信通知。"),
    NONE(100, "", "NONE"),
    UNKNOWN(-1, "未知", "UNKNOWN"),
    ALL(127, "所有", "ALL");


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
curl "http://192.168.48.1zgrep f_tgq_center_170927.165123.192.168.57.20.24228.1617859_1 /DATA_LOG_FLIGHT/CN8_refundcore/l-fwrefundcore*.f.cn8/201709/fuwu_refund_core.2017-09-27-16.log.gz > fny170927152727403_refund_core.log92:8080/refundcore/updateOrderStatus?domain="${line:0:3}".trade.qunar.com&orderNo="${line}"&fromStatus=50&toStatus=39"
echo  "\n"
done

curl 'http://192.168.19.65:8080/gaiqian/backDoor/updateTtsStatusForFlight?orderNo=xep170414112339357001&domain=xep.trade.qunar.com&fromStatus=40&toStatus=42'

curl "http://192.168.48.192:8080/refundcore/updateOrderStatus?domain=tef.trade.qunar.com&orderNo=tef160328193711402&fromStatus=5&toStatus=2"

curl "http://l-flightc54.f.beta.cn0:8080/tgqcenter/test/test"
http://l-fuwuunfreeze1.f.cn1.qunar.com:8080/backdoor/unfreezeWithoutVerify?orderNo=znh150201143746739




过期日志存储于
l-flightlogs1.f.cn1     /DATA_LOG_FLIGHT    下面目录按照  机房加项目名
合并拉日志
zgrep f_tgq_center_170927.165123.192.168.57.20.24228.1617859_1 /DATA_LOG_FLIGHT/CN8_fuwu_refund_core/l-fwrefundcore*.f.cn8/201709/fuwu_refund_core.2017-09-27-16.log.gz > fny170927152727403_refund_core.log

zgrep "f_fuwu_refund_171212.105351.10.88.64.70.17837.16217325_1"  /DATA_LOG_FLIGHT/CN1_fuwurefund/l-qmrefund[2-5].f.cn1/201712/fuwu_refund.2017-12-12.log.gz  
常用问题：
1.用户----》改签-----》退票（航变（运营被拒）） ----》退票（自愿退款）      n单为出票完成  f单为改签完成     李星（潘志超）

flightdata   coreserv  ------》tts
             fuwu_refund_core------>fuwu_refund_core而不是fwrefundcore



atnodes  "grep 'cc_flow_api_171129.161113.192.168.36.35.29312.9539982_1' /home/q/www/fuwu_refund_core/logs/fuwu_refund_core.2017-11-29-16.log
  atnodes  "grep 'rev req query orderNo=scv170321115933030' /home/q/www/fuwu_orderapp/logs/fuwu_orderapp.log"    l-fuwuorderapp[1-10].f.cn1
atnodes  "zgrep '的售前航段匹配不到保险的航段ttsSegment' /home/q/www/fuwu_refund_core/logs/fuwu_refund_core.2017-11-29-19.log.gz"  l-fwrefundcore[1-4].f.cn8



http://download.csdn.net/download/hwaeb/1302267

qunar.team.flight.fuwu.ant_core.pm.refund.TTS.fuwu.getPayCenterInfoByProduct 获取支付信息的报警


orderNo:xep180109155113683访问tc接口获取退款信息的url:http://order.qunar.com/refund/api/detail.htm?sysCode=2801&orderNo=xep180109155113683&systemSource=flight


http://touch.qunar.com/h5/flight/flightview/insurance?from=delayinsbtn&refer=5&token=15b2403de2ca4325b3a05b4b76042feb&productType=flightdelay&businessLine=flight

https://bao.qunar.com/ibundle/index?$query_string
