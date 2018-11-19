package com.xinyan.sell.dto;

import lombok.Getter;

/**
 * 王宸
 * 2018/11/15 1:00
 *
 * 购物车
 */
@Getter
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
