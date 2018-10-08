

####  auto_refund
##### 定时任务包：
######## com.qunar.fuwu.refund.core.task.AutoRefundTask
### 确认退款
- com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#doConfirmRefund  -- 确认退款
  - 校验  com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#checkAutoConfirmRefundParam
  - 确认  com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#confirmRefund
    - 计算退款金额 com.qunar.fuwu.refund.core.service.ExecuteRefundInfoQueryService#acquireRefundPriceWithoutExpressFee
    - 行程单校验 com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#checkXcdTicket
    - 加快递费 com.qunar.fuwu.refund.core.service.ExecuteRefundInfoQueryService#calcRefundPriceWithExpressFee
    - 指标记录 com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#addIndicatorDataLog
    - 退款金额检查 refundPrice == null || refundPrice < 0 ---> 创建核实手续费众包任务结果
    - 普通自愿垫退 -->>退款金额超过上限校验
    - 非高诚信用户--- 更新updateOrderAutoConfirmRefund
    - 打订单日志
    - confirmRefund
      - 构造参数（繁琐）  com.qunar.fuwu.refund.core.price.OrderParamFetcher#fetchOrderParam
      - 退改签信息组装（费用计算--繁琐--删除）com.qunar.fuwu.refund.core.service.RefundQueryService#fetchConfirmResultPriceInfo
      - 往返保险类型设置 com.qunar.fuwu.refund.core.service.RefundInsuranceService#whichInsuranceCanRefund
      - 确认  com.qunar.fuwu.refund.core.api.IRefundUpdateRelatedService#confirmRefund
      - 订单日志
    - 确认结果：StringUtils.isNotBlank(failedReason)
      - 订单进入退款失败报警列表 com.qunar.fuwu.refund.core.service.AutoRefundService#refundFailAlarmIfNecessary
  - result
    - success
    - fail
      - com.qunar.fuwu.refund.core.service.AutoRefundService#retryAndRemoveIfNecessary
      - com.qunar.fuwu.refund.core.statistics.RefundStatisticService#recordAutoRefundFailed
      - com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#updateAutoRefundFail
      - com.qunar.fuwu.refund.core.service.autoRefund.DoAutoRefundService#addConfirmRefundFailLog
-


#### 退款

- com.qunar.fuwu.refund.core.service.autoRefund.impl.AutoRefundDoRefundService#doAutoRefund


  - f单退款完成，风险订单   失败日志+报警列表  return
  - 更新自动退款类型   特殊用户自动退款+自动退款
  - 退款
    -  构造参数（繁琐）  com.qunar.fuwu.refund.core.price.OrderParamFetcher#fetchOrderParam
    -  查询退款信息（繁琐） com.qunar.fuwu.refund.core.service.RefundQueryService#queryWaitRefundInfo

  - 退款成功日志+库表修改
