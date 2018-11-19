package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 王宸
 * 2018/11/14
 */
public interface ProductCategoryRepository extends
        JpaRepository<ProductCategory, Integer> {

    /**
     * 类目类型查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
