package com.xinyan.sell.utils;

import java.util.UUID;

/**
 * 王宸
 * 2018/11/14 17:25
 *
 * 生成主键key
 */
public class KeyUtil {

    /**生成唯一主键:UUID
     * @return
     */
    public static synchronized String genericKey(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
