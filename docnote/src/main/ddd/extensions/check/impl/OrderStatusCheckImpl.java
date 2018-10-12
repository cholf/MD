package main.ddd.extensions.check.impl;


import main.ddd.extensions.check.StatusCheck;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/10/12
 * Time  : 上午11:50
 * 类描述 : 订单状态校验
 */
public class OrderStatusCheckImpl implements StatusCheck {
    @Override
    public boolean statusCheck() {
        return false;
    }
}
