package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 王宸
 * 2018/11/14
 *
 * 订单管理员 Repository 接口
 */
public interface OrderMasterRepository extends
        JpaRepository<OrderMaster, String> {

    /**订单查询：买家 openid
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
