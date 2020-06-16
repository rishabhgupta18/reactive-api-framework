package com.reactive.api.framework.v1.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reactive.api.framework.v1.pojo.APIResponse;
import com.reactive.api.framework.v1.pojo.ResponseEntity;
import com.reactive.api.framework.v1.pojo.Status;
import com.reactive.api.framework.v1.util.APIUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static com.reactive.api.framework.v1.constants.ResponseMessages.Error.INTERNAL_SERVER_ERROR;

@Data
@Slf4j
public class ResponseBuilder {

    public static Mono<ServerResponse> buildResponse(ResponseEntity<? extends Object> requestEntity) {
        APIResponse response = new APIResponse(Status.SUCCESS);
        response.setMessage(null);
        response.setData(requestEntity.getEntity());
        try {
            return ServerResponse.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(APIUtil.toJson(response)), String.class)
                    .log("Response ");
        } catch (JsonProcessingException e) {
            log.error("Error in building response ::: "+ e.getMessage());
        }
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(INTERNAL_SERVER_ERROR, String.class);
    }

}
