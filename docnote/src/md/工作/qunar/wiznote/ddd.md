##

http://lcom:8080/flow/entryRequestQuery/queryByDubboInfo?appCode=f_refund_core&className=com.qunar.fuwu.refund.core.api.IRefundUpdateRelatedService&methodName=refuseRefund&paramTypes=com.qunar.fuwu.refund.core.pojo.RefuseRefundParam&limit=1&paramTypes=com.qunar.fuwu.refund.core.pojo.AttachmentParam&beginTime=1535708866000&endTime=1535795266000



http://l-.auto.beta.cn0.qunar.com:8080/test/verification?serviceName=applyRefundFlowVerificationService&beginTime=2018-09-19%2016:08:48&endTime=2018-09-19%2016:08:50



#####  

- http://.qunar.com/fuwuapp/flowPlatform/appInfo  流量录制

问题

 未获取到参数集 uri=com.qunar.fuwu.orderapp.api.refundRecord.service.IRefundRecordQueryService.queryAllByOrderNo_java.lang.String_com.qunar.fuwu.orderapp.api.common.NationalParam, param=["ffs.trade.qunar.com",{"domain":"ffs180918104540007"}], paramList=[["ffs180918104540007",{"domain":"ffs.trade.qunar.com"}]]
- param  paramList(线上) 参数不匹配


 未获取到结果集 uri=com.qunar.fuwu.refund.core.api.IUserTagService.isHighHonestyUser_java.lang.String_java.lang.String, uriMatchingResultMap.keys=[com.qunar.flight.tts.ttsorder.api.OrderDetailService.querySubOrderDetail_com.qunar.flight.tts.ttsorder.pojo.QueryCondition

 - 线上录制了  线下没用调用
