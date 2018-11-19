package com.xinyan.sell.exception;

import com.xinyan.sell.enums.ResultStatus;

/**
 * 王宸
 * 2018/11/15 0:30
 * 自定义异常
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultStatus resultStatus) {
        super(resultStatus.getMessage());

        this.code = resultStatus.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
