package com.xinyan.sell.enums;

import lombok.Getter;

/**
 * 王宸
 * 2018/11/14
 *
 * 商品状态
 */
@Getter
public enum ProductStatus {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
