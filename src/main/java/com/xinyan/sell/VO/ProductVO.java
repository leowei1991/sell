package com.xinyan.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Administrator
 * 2018/11/21 0021 11:05
 * 商品类目，包含商品
 * http请求的第二层对象
 */
@Data
public class ProductVO {

    //类目名字
    @JsonProperty("name")
    private String categoryName;

    //类目类型
    @JsonProperty("type")
    private Integer categoryType;

    //商品数据对象集合
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
