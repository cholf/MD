package main.ddd.entity;

import main.ddd.extensions.check.ApplyRefundCheck;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/10/12
 * Time  : 上午10:28
 * 类描述 : 服务单
 */
public class ServiceOrder {
    private String orderNo;
    private String domian;
    private Integer status;

    private ApplyRefundCheck applyRefundCheck;

    /**
     * 申请退款
     * @return b
     */
    public boolean applyRefund() {
        //context构建
        //申请退款校验
        applyRefundCheck.check();
        //入库
        //发消息
        return false;
    }

    /**
     * 确认退款
     * @return b
     */
    public boolean confirmRefund() {
        return false;
    }

    /**
     * 拒绝退款
     * @return b
     */
    public boolean refuseRefund() {
        return false;
    }


    /**
     * 退款
     * @return b
     */
    public boolean doRefund() {
        return false;
    }


    /**
     * 自动退款
     * @return b
     */
    public boolean autoRefund() {
        return false;
    }

    /**
     * 垫退
     * @return b
     */
    public boolean preRefund() {
        return false;
    }


}
