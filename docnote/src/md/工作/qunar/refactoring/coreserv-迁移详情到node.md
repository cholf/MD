```sequence
title:coreserv_详情迁移node
controller-->OrderDao:获取订单信息



```



```sequence
title:保险(迁移简单)
controller-->InsuranceServiceIml:queryAllInsuranceByOrderNo
InsuranceServiceIml-->IInsuranceQueryService:queryInsuranceInfoWithoutMerge

```
```sequence
title:航意险(查库，迁移简单)
```

```sequence

title:券信息（infocenter）
```

```sequence

title:promotion

```
