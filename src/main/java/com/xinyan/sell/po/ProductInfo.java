package com.xinyan.sell.po;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 王宸
 * 2018/11/14 17:13
 */
@Data
@DynamicUpdate
@Entity
public class ProductInfo {

    @Id
    /** 商品ID */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品图片 */
    private String productIcon;

    /** 商品状态 */
    private Integer productStatus = 0;

    /** 商品类型 */
    private Integer categoryType;

    /** 商品创建时间 */
    private Date createTime;
}
