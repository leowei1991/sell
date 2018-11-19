package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 王宸
 * 2018/11/14
 *
 * 订单详情 Repository 接口
 */
public interface OrderDetailRepository extends
        JpaRepository<OrderDetail, String> {

    /** 查询订单详情：
     * @param orderId 订单ID
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
