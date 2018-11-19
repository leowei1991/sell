package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     *
     */
    @Test
    public void save() {
        String orderId = KeyUtil.genericKey();

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("1234321543534");
        orderMaster.setBuyerAddress("广东深圳");
        orderMaster.setBuyerOpenid("3421534543");
        orderMaster.setOrderAmount(new BigDecimal("28"));


        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(KeyUtil.genericKey());
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId("f245t34twafr4");
        orderDetail.setProductName("鱼香肉丝");
        orderDetail.setProductPrice(new BigDecimal("28"));
        orderDetail.setProductQuantity(1);
        orderDetail.setProductIcon("http:");

        orderMasterRepository.save(orderMaster);
        OrderDetail orderDetailResult = orderDetailRepository.save(orderDetail);

        Assert.assertNotEquals("保存订单详情", orderDetailResult);
    }

    /**
     *
     */
    @Test
    public void findByOrderId() {
    }
}