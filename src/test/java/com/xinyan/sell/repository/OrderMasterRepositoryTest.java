package com.xinyan.sell.repository;

import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * OrderMasterRepository 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    /**
     * 添加订单
     */
    @Test
    @Transactional
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtil.genericKey());
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("1234321543534");
        orderMaster.setBuyerAddress("广东深圳");
        orderMaster.setBuyerOpenid("3421534543");
        orderMaster.setOrderAmount(new BigDecimal("28"));


        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotEquals("保存订单", result);
    }


    /**
     * 根据买家微信 查询订单
     */
    @Test
    public void findByBuyerOpenid() {
        String openid = "3421534543";
        PageRequest pageRequest = new PageRequest(0,5);

        Page<OrderMaster> page = repository.findByBuyerOpenid(openid, pageRequest);
        Assert.assertNotEquals("查询订单", page);
    }
}