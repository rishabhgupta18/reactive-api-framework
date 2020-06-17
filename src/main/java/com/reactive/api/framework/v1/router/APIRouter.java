package com.reactive.api.framework.v1.router;

import com.reactive.api.framework.v1.controller.PingAPIController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.reactive.api.framework.v1.builder.APIResponseBuilder.buildResponse;
import static com.reactive.api.framework.v1.constants.RequestEndPoints.PING;
import static com.reactive.api.framework.v1.constants.RequestEndPoints.V1;

@RestController
@RequestMapping(V1)
@Slf4j
public class APIRouter {

    @GetMapping(PING)
    public Mono<ResponseEntity> ping() throws Exception{
        return new PingAPIController().get("")
                .flatMap(entityWrapper -> {
                   return  buildResponse(entityWrapper);
                });
    }

}
