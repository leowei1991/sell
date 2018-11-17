package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Administrator
 * 2018/11/13 0013
 *
 * 产品类目分类
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /** 产品列表 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /** 根据id查询单个商品 */
    ProductCategory findByCategoryId(Integer id);
}
