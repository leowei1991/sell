package com.xinyan.sell.controller;

import com.xinyan.sell.service.ProductCategoryService;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 王宸
 * 2018/11/14 18:35
 *
 * 买家端商品
 */
@RequestMapping("/buyer/product")
@RestController
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    /**买家商品列表
     * @return
     */
}
