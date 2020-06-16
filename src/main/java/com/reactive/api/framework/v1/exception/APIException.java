package com.reactive.api.framework.v1.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reactive.api.framework.v1.pojo.APIResponse;
import com.reactive.api.framework.v1.pojo.Status;
import com.reactive.api.framework.v1.util.APIUtil;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@Order(-2)
public class APIException extends AbstractErrorWebExceptionHandler {

    private int statusCode;
    @NonNull
    private String message;

    public APIException(ErrorAttributes errorAttributes,
                        ApplicationContext applicationContext,
                        ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, new ResourceProperties(),
                applicationContext);
        super.setMessageReaders(serverCodecConfigurer.getReaders());
        super.setMessageWriters(serverCodecConfigurer.getWriters());
    }

    /**
     * Create a {@link RouterFunction} that can route and handle errors as JSON responses
     * or HTML views.
     * <p>
     * If the returned {@link RouterFunction} doesn't route to a {@code HandlerFunction},
     * the original exception is propagated in the pipeline and can be processed by other
     * {@link WebExceptionHandler}s.
     *
     * @param errorAttributes the {@code ErrorAttributes} instance to use to extract error
     *                        information
     * @return a {@link RouterFunction} that routes and handles errors
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return null;
    }

    private Mono<ServerResponse> generateErrorResponse(ServerRequest serverRequest) throws JsonProcessingException {
        APIResponse response = new APIResponse(Status.ERROR);
        response.setMessage(message);
        response.setData(null);
        return ServerResponse.status(statusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(APIUtil.toJson(response)), String.class)
                ;
    }
}
