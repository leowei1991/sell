package com.xinyan.sell.po;

import com.xinyan.sell.enums.OrderStatus;
import com.xinyan.sell.enums.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 王宸
 * 2018/11/14 23:03
 *
 * 订单PO 对象
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    /** 订单ID*/
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 买家姓名 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信 openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态 默认为0，新订单*/
    private Integer orderStatus = OrderStatus.NEW.getCode();

    /** 支付状态 默认为0，未支付*/
    private Integer payStatus = PayStatus.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

}
