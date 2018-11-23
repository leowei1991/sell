package com.xinyan.sell.VO;

import lombok.Data;

/**
 * Administrator
 * 2018/11/21 0021 10:35
 * http请求的最外层对象
 */
@Data
public class ResultVO<T> {
    //状态码
    private Integer code;
    //消息提示
    private String msg;

    //返回的具体数据对象data
    private T data;

}
