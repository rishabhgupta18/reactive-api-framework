package com.reactive.api.framework.v1.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class APIUtil {

    private static ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }

    public static <T> String toJson(T entity) throws JsonProcessingException {
        if(entity instanceof String){
            return "{\"data\": \""+entity+"\"";
        }
        return mapper.writeValueAsString(entity);
    }

    public static <T> Object toJson(String data, Class<?> classReference ) throws JsonProcessingException {
        return mapper.readValue(data, classReference);
    }

}
