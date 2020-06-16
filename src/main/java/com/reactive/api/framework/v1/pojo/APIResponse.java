package com.reactive.api.framework.v1.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NonNull;

@Data
@JsonSerialize
@JsonDeserialize
public class APIResponse{

    @NonNull
    private Status status;
    private String message = null;
    private Object data = null;

}
