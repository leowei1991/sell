package com.xinyan.sell.converter;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

/**
 * 王宸
 * 2018/11/15 12:45
 */
@Slf4j
public class OrderFormToOrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        try {
//            List<OrderDetail> orderDetailList = new ArrayList<>();
//            orderDetailList = gson.fromJson(orderForm.getItems(),
//                    new TypeToken<List<OrderDetail>>() {
//                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultStatus.ORDER_STATUS_ERROR);
        }

        return orderDTO;
    }
}
