package com.reactive.api.framework.v1.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
public class APIResponse {

    @NonNull
    private Status status;
    private String message = null;
    private Object data = null;

}
