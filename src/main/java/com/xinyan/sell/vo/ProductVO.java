package com.xinyan.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 王宸
 * 2018/11/14 19:37
 *
 * 商品VO 对象， 包含 类目
 */
@Data
public class ProductVO {

    /** 类目名称 */
    @JsonProperty("name")
    private String categoryName;

    /** 类目类别 */
    @JsonProperty("type")
    private Integer categoryType;

    /** 商品详细信息 */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
