package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情表
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * order_master的表对应order_detail多条记录
     * 所以返回的是一个List
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
