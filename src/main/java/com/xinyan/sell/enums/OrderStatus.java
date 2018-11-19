package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * 王宸
 * 2018/11/14
 *
 * 订单状态
 */
@Getter
public enum OrderStatus {
    NEW(0,"新订单"),
    FINISH(1,"已完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;
    private String message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
