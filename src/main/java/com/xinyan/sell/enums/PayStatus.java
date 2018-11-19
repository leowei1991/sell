package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * 王宸
 * 2018/11/14
 *
 * 订单支付状态
 */
@Getter
public enum PayStatus {

    WAIT(0,"未支付"),
    PAID(1,"已支付")
    ;

    private Integer code;
    private String message;

    PayStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
