###


//基本都用了
orderNo；
Domain；
orderId；
Boolean allUser；
orderStatus；
toOrderStatus；
changeCause；//退款原因
Source；//原来类型com.qunar.fuwu.base.model.FuwuExecutorInfo.AccessSource
operator；
payBackType；//原来类型com.qunar.flight.fuwu.coreservice.api.pojo.PayBackType

//8,9
Boolean needVerify;//是否旗舰店双向校验

// 7
boolean isFormatRefundInfo ;//是否格式化
tgqTimeCharge ；//退改签规则
Boolean isInfantAdult;//{成人婴儿票合单，不校验变价时间点} 原有逻辑 com.qunar.fuwu.refund.core.stm.condition.applyrefund.RefundFeeChangeChecker#isInfantAdult
rootOrderNo;
getOrder().getAllprices;
getAllReturnPrice


param-set
//7

setChangeCause
setVolunteer

setChangeFee
setPassengerReturnFees
setPassengerBxReturnFee
setUseFee

result-set
//9
setOrders
setOrderId
//7
setCause
setVolunteer
setUseFee
