package com.xinyan.sell.service.impl;


import com.xinyan.sell.enums.ProductStatusEnum;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductInfoRepository;
import com.xinyan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Administrator
 * 2018/11/13 0013
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
<<<<<<< Updated upstream
    private ProductInfoRepository repository;
=======
    private ProductInfoRepository productRepository;
>>>>>>> Stashed changes

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }




}
