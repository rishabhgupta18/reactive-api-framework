package com.reactive.api.framework.v1.router;

import com.reactive.api.framework.v1.controller.PingAPIController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static com.reactive.api.framework.v1.constants.RequestEndPoints.PING;
import static com.reactive.api.framework.v1.constants.RequestEndPoints.V1;
import static com.reactive.api.framework.v1.builder.ResponseBuilder.buildResponse;

@RestController
@RequestMapping(V1)
@Slf4j
public class APIRouter {

    @GetMapping(PING)
    public Mono<ServerResponse> ping() throws Exception{
        return new PingAPIController().get("")
                .flatMap(responseEntity -> {
                   return  buildResponse(responseEntity);
                })
                .log("Sending response");
    }

}
