package com.xinyan.sell.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created
 * 2017-07-04 01:30
 * JSON 和 Java 对象转换工具
 */
public final class JsonUtil {

    public static ObjectMapper objectMapper;

    static {
        if (objectMapper == null){
            objectMapper = new ObjectMapper();
//            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, );
        }
    }

//    public static String toJson(Object object) {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();
//        Gson gson = gsonBuilder.create();
//        return gson.toJson(object);
//    }
}
