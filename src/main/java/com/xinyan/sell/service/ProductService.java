package com.xinyan.sell.service;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.po.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 王宸
 * 2018/11/14
 *
 * 卖家 商品业务接口
 */
public interface ProductService {

    //卖家端

    /**根据商品ID查询
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**商品列表
     * @return
     */
    List<ProductInfo> findAll();

    /**分页查询
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**根据商品状态查询
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**更新库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
