package com.reactive.api.framework.v1.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reactive.api.framework.v1.util.APIUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class EntityWrapper<T> {

    @NonNull
    private T entity;
    private String message = null;

}
