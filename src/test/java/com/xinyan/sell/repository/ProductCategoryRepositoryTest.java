package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void findByCategoryId() {
        ProductCategory productCategory = productCategoryRepository.findByCategoryId(1);
        System.out.println(productCategory);

        ProductCategory one = productCategoryRepository.findOne(1);
        System.out.println(one);

    }


}