package com.nice.commons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * json工具类
 * @author nice
 */
public class JsonUtils {

    /**
     * 解析json
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T>  List<T> toList(String json, Class<T> clazz) {
        return new Gson().fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
    }



}
