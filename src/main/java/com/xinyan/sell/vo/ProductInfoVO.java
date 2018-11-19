package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 王宸
 * 2018/11/14 19:48
 * 商品信息 VO
 */
@Data
public class ProductInfoVO {

    /** 商品ID */
    @JsonProperty("id")
    private String productId;

    /** 商品名称 */
    @JsonProperty("name")
    private String productName;

    /** 商品价格 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 商品描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 商品图片 */
    @JsonProperty("icon")
    private String productIcon;

}
