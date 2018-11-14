package com.xinyan.sell.utils;

import java.util.Random;

/**
 * Administrator
 * 2018/11/13 0013
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static void main(String[] args) {
        System.out.println(KeyUtil.genUniqueKey());
    }
}
