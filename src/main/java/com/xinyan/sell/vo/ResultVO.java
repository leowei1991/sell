package com.xinyan.sell.vo;

import lombok.Data;

/**
 * 王宸
 * 2018/11/14 18:46
 *
 * 通用视图
 */
@Data
public class ResultVO<T> {

    /** 码号*/
    private Integer code;
    /** 返回状态 */
    private String msg;
    /** 返回数据 */
    private T data;
}
