package com.xinyan.sell.VO;

import lombok.Data;

/**
 * Administrator
 * 2018/11/13 0013
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
