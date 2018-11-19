package com.xinyan.sell.service.impl;

import com.xinyan.sell.dto.CartDTO;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.po.OrderDetail;
import com.xinyan.sell.po.OrderMaster;
import com.xinyan.sell.po.ProductInfo;
import com.xinyan.sell.repository.OrderDetailRepository;
import com.xinyan.sell.repository.OrderMasterRepository;
import com.xinyan.sell.repository.ProductRepository;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.service.ProductService;
import com.xinyan.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 王宸
 * 2018/11/15 0:17
 * Order 订单业务接口实现类
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {



    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;


    /**创建订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        //生成订单id orderId
        String orderId = KeyUtil.genericKey();

        //订单总金额
        BigDecimal orderAmount = new BigDecimal(0);

        orderDTO.setOrderId(orderId);
        //查询商品
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productRepository.findOne(orderDetail.getProductId());
            if (productInfo == null){
                log.info("[创建订单]商品不存在，productId : {}" + orderDetail.getProductId());
                throw new SellException(ResultStatus.PRODUCT_NOT_EXIST);
            }

            //计算订单总金额
            orderAmount = productInfo.getProductPrice().multiply(
                    new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.genericKey());
            orderDetail.setOrderId(orderDTO.getOrderId());
            orderDetailRepository.save(orderDetail);
        }

        //订单主表入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(orderDTO.getOrderId());
        orderMasterRepository.save(orderMaster);

        //更新库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    /**查询单个订单
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    /**买家订单列表
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    /**取消订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    /**完结订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    /**支付订单
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
