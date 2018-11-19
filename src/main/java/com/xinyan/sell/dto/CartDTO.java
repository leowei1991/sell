package com.xinyan.sell.dto;

import lombok.Data;

/**
 * @Author: ZengQingQuan
 * @Description:
 * @Date: Create in 19:38 2018/11/16 0016
 *
 * 购物车
 */
@Data
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
