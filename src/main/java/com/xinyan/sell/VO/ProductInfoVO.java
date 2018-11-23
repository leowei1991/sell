package com.xinyan.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Administrator
 * 2018/11/21 0021 11:19
 * 商品列表第三层商品对象
 */
@Data
public class ProductInfoVO {
    //商品id
    @JsonProperty("id")
    private String productId;
    //商品名字
    @JsonProperty("name")
    private String productName;
    //商品价格
    @JsonProperty("price")
    private BigDecimal productPrice;
    //描述
    @JsonProperty("description")
    private String productDescription;
    //小图
    @JsonProperty("icon")
    private String productIcon;
}
