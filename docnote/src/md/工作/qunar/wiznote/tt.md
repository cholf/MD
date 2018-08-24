

## 备注
- 已出票
  - 接口：com.qunar.fuwu.refund.core.api.IRefundUpdateRelatedService#refuseRefund
  - n : refund_core实现
  - f : refund_core_flight实现  -- 暂定不改

  - 特殊接口逻辑
    - 投诉订单，被拒绝退款--发消息--subject:{flight.fuwu.refund.complaint.finish}
    - 入库更新--更新refund_statistics为代理商拒绝退款失败---{fuwu库里面的refund_statistics}

- 未出票
  - 接口：com.qunar.fuwu.refund.core.api.INoTicketRefundUpdateService#refuseRefund
  - n : refund_core实现
  - f : refund_core_flight实现  -- 暂定不改

  - 状态机逻辑
    - 退款待确认->出票完成
      - 校验拒绝退款参数
      - 更新退票申请记录并记录日志
      - 变更订单状态并发送状态变更消息
      - 给用户发送短信

    - 待退款->出票完成  
      - 从待退款跃迁至退款待确认
      - 从退款待确认跃迁至出票完成

    - 待退款->退款待确认
      - 校验拒绝退款参数
      - 更新退票申请记录并记录日志
      - 变更订单状态并发送状态变更消息

    - 未出票申请退款->支付成功等待出票/出票中  // 判断是否存在有效采购单,如果存在则变更为出票中
      - 出票中
        - 校验拒绝退款参数
        - 更新退票申请记录并记录日志
        - 变更订单状态并发送状态变更消息

      - 支付成功等待出票
        - 校验拒绝退款参数
        - 更新退票申请记录并记录日志
        - 变更订单状态并发送状态变更消息
        - 调用售前接口进行订单状态变更

- 两个接口最后会走到  com.qunar.fuwu.refund.core.service.provider.OrderRefundUpdateProviderService#refuseRefund
  - 状态机之前特殊逻辑
    - 如果是拒绝到出票完成 需要从退款待审核列表删除



##### 对之后的能力，确认过：
- 基本参数校验（复用）
- 初始化context（复用）
- 校验拒绝退款参数
- 更新退票申请记录并记录日志{复用}
- 变更订单状态并发送状态变更消息{复用}
- 调用售前接口进行订单状态变更{售前确认是否合一个，确认结果，售前没有发消息的逻辑，暂时不能合}
- 给用户发送拒绝短信
- 投诉订单，被拒绝退款--发消息--subject（确定消息接收，抽取复用，确认结果-- 没有流量--删除）
- 入库更新--更新refund_statistics为代理商拒绝退款（产品确认是否有用，确认结果：产品不确定，暂时留着）
