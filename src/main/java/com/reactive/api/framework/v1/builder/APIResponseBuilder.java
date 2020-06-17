package com.reactive.api.framework.v1.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reactive.api.framework.v1.pojo.APIResponse;
import com.reactive.api.framework.v1.pojo.EntityWrapper;
import com.reactive.api.framework.v1.pojo.Status;
import com.reactive.api.framework.v1.util.APIUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import static com.reactive.api.framework.v1.constants.ResponseMessages.Error.INTERNAL_SERVER_ERROR;

@Data
@Slf4j
public class APIResponseBuilder {

    public static Mono<ResponseEntity> buildResponse(EntityWrapper<? extends Object> entityWrapper) {
        APIResponse response = new APIResponse(Status.SUCCESS);
        response.setMessage("success");
        response.setData(entityWrapper.getEntity());
        try {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(APIUtil.toJson(response)));
        } catch (JsonProcessingException e) {
            log.error("Error in building response ::: "+ e.getMessage());
        }
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(INTERNAL_SERVER_ERROR));
    }

}
