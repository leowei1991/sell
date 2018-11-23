package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * Administrator
 * 2018/11/13 0013
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
