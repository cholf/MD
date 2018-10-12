package main.ddd.entity;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 *
 * @author gangwen.xu
 * Date  : 2018/10/12
 * Time  : 上午10:39
 * 类描述 : 保险
 */
public class InsuranceEntity {
    private String no;
    private Integer status;

    /**
     * 获取保险费用
     * @return p
     */
    public BigDecimal getInsuranceFee(){
        return BigDecimal.ZERO;
    }
}
