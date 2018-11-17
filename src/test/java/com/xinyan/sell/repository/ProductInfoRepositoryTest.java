package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {


    }

    /** 商品信息列表 */
    @Test
    public void findAll(){
        List<ProductInfo> productInfoList = productInfoRepository.findAll();
        System.out.println(productInfoList);

    }
}