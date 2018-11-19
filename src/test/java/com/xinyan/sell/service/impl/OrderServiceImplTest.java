package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.OrderStatusEnum;
import com.xinyan.sell.enums.PayStatusEnum;
import com.xinyan.sell.po.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: ZengQingQuan
 * @Description:
 * @Date: Create in 19:18 2018/11/18 0018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    //已有的订单id
    private final String ORDER_ID = "1542541291348557548";

    /**
     * 创建订单测试
     * @throws Exception
     */
    @Test
    public void create() throws Exception{

        //买家信息
        OrderDTO orderDTO = new OrderDTO();
        //买家姓名
        orderDTO.setBuyerName("李四");
        //买家地址
        orderDTO.setBuyerAddress("资信达大厦");
        //买家手机号
        orderDTO.setBuyerPhone("123456789012");
        //买家微信
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        //必须是数据库已有的东西
        o1.setProductId("1542167093790297441");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        //必须是数据库已有的东西
        o2.setProductId("1542167005839409762");
        o2.setProductQuantity(2);

        //添加进去List
        orderDetailList.add(o1);
        orderDetailList.add(o2);

        //设置进去DTO里面去
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);

        //打印日志
        log.info("【创建订单】result={}", result);

        //测试判断文件
        Assert.assertNotNull(result);
    }

    /**
     * 查询单个订单测试
     *      详情一并查出
     * @throws Exception
     */
    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        //打印日志
        log.info("【查询单个订单】result={}", result);
        //测试判断文件
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    /**
     * 查询订单列表
     * @throws Exception
     */
    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        //打个断点测试一下，OrderMaster是否有转换成OrderDTO函数
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    /**
     *取消订单
     * @throws Exception
     */
    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        //判断取消完的状态
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    /**
     * 完结订单
     * @throws Exception
     */
    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    /**
     *支付订单
     * @throws Exception
     */
    @Test
    public void paid() throws Exception {
        //差一个订单
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        //调用支付完结的方法
        OrderDTO result = orderService.paid(orderDTO);
        //判断支付状态是否成功
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}