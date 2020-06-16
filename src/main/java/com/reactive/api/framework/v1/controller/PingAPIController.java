package com.reactive.api.framework.v1.controller;

import com.reactive.api.framework.v1.pojo.ResponseEntity;
import reactor.core.publisher.Mono;

import static com.reactive.api.framework.v1.constants.ResponseMessages.Success.PONG;

public class PingAPIController implements IAPIController {


    /**
     * @param id
     * @return
     */
    @Override
    public Mono<ResponseEntity<? extends Object>> get(String id) {
        return Mono.just(new ResponseEntity<String>(PONG));
    }
}
