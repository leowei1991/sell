package com.xinyan.sell.exception;

import com.xinyan.sell.enums.ResultEnum;

/**
 * @Author: ZengQingQuan
 * @Description:
 * @Date: Create in 18:41 2018/11/16 0016
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

}
