package com.reactive.api.framework.v1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static com.reactive.api.framework.v1.constants.ResponseMessages.Success.PONG;

@Data
public class Pong {
    private String status = PONG;
}
