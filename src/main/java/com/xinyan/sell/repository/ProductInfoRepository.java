package com.xinyan.sell.repository;

import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Administrator
 * 2018/11/13 0013
 */
<<<<<<< Updated upstream:src/main/java/com/xinyan/sell/repository/ProductInfoRepository.java
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
=======
public interface ProductInfoRepository extends
        JpaRepository<ProductInfo,String> {
>>>>>>> Stashed changes:src/main/java/com/xinyan/sell/repository/ProductInfoRepository.java

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
