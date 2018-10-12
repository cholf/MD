package main.ddd.extensions.check.impl;


import main.ddd.extensions.check.ApplyRefundCheck;
import main.ddd.extensions.check.PriceCheck;
import main.ddd.extensions.check.StatusCheck;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/10/12
 * Time  : 下午12:42
 * 类描述 :
 */
public class ApplyRefundCheckImpl implements ApplyRefundCheck {

    private List<StatusCheck> statusChecks;

    private PriceCheck priceCheck;

    @Override
    public boolean check() {

        //状态校验
        for (StatusCheck statusCheck : statusChecks) {
            statusCheck.statusCheck();
        }

        //价格校验
        priceCheck.priceCheck();

        //


        return false;
    }
}
