
 1. 服务接口均需返回统一的响应对象(<font color='red'>无论失败或成功，切忌抛出异常)。

 2. 必要接口应保证幂等性(<font color='red'>对多次调用问题处理)。

 3. 服务接口应该尽量保持<font color='red >单一职责原则。

 4. 接口升级应保证<font color='red'>向后兼容。
