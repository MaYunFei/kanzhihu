package com.yunfei.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *
 * Created by yunfei on 16/7/4.
 */
public class JacksonUtil {
    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    public static <T> T getBeanFromJson(String json, Class<T> tClass) throws IOException {
        return getObjectMapper().readValue(json, tClass);
    }
}

