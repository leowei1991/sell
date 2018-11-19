package com.xinyan.sell.converter;

import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.po.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器
 * OrderMaster 转换成 OrderDTO
 * @Author: ZengQingQuan
 * @Description:
 * @Date: Create in 20:39 2018/11/18 0018
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}