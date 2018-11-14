package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory findByCategoryId(Integer id);
}
