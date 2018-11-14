package com.xinyan.sell.service;

import com.xinyan.sell.po.ProductCategory;

import java.util.List;

/**
 * Administrator
 * 2018/11/13 0013
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
