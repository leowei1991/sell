package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     *这方法是根据买家的OpenID来查，并且有一根分页
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
