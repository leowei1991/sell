package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 王宸
 * 2018/11/14 17:46
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**根据商品ID查询
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findOne(String productId) {
        return productRepository.findOne(productId);
    }

    /**商品列表查询
     * @return
     */
    @Override
    public List<ProductInfo> findAll() {
        return productRepository.findAll();
    }

    /**分页查询商品
     * @param pageable
     * @return
     */
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        PageRequest pageRequest = new PageRequest(pageable.getPageNumber(),pageable.getPageSize());
        Page<ProductInfo> page = productRepository.findAll(pageRequest);
        return page;
    }

    /**根据商品状态查询
     * @param productStatus
     * @return
     */
    @Override
    public List<ProductInfo> findByProductStatus(Integer productStatus) {
        return productRepository.findByProductStatus(productStatus);
    }

    /**更新库存
     * @param cartDTOList
     */
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO: cartDTOList){
            ProductInfo productInfo = productRepository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                log.info("[更新库存]商品不存在，productId : {}", cartDTO.getProductId());

            }
            productInfo.setProductStock(productInfo.getProductStock() - cartDTO.getProductQuantity());
            productRepository.save(productInfo);
        }


    }
}
