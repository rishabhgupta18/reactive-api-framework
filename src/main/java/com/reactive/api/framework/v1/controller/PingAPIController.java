package com.reactive.api.framework.v1.controller;

import com.reactive.api.framework.v1.pojo.EntityWrapper;
import com.reactive.api.framework.v1.pojo.Pong;
import reactor.core.publisher.Mono;

public class PingAPIController implements IAPIController {


    /**
     * @param id
     * @return
     */
    @Override
    public Mono<EntityWrapper<? extends Object>> get(String id) {
        return Mono.just(new EntityWrapper<Pong>(new Pong(), "pong successful"));
    }
}
