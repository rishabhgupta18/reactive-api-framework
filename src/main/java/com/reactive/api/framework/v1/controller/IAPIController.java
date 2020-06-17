package com.reactive.api.framework.v1.controller;

import com.reactive.api.framework.v1.pojo.Filter;
import com.reactive.api.framework.v1.pojo.Pagination;
import com.reactive.api.framework.v1.pojo.Query;
import com.reactive.api.framework.v1.pojo.EntityWrapper;
import reactor.core.publisher.Mono;

import static com.reactive.api.framework.v1.constants.ResponseMessages.Error.UNSUPPORTED_OPERATION;

/**
 * @author rishabhgupta18
 */
public interface IAPIController {

    /**
     * @param id
     * @return
     */
    public Mono<EntityWrapper<? extends Object>> get(String id);

    /**
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> create(String body) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }

    /**
     * @param id
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> update(String id, String body) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }

    /**
     * @param id
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> delete(String id) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }

    /**
     * @param pagination
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> getAll(Pagination pagination) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }

    /**
     * @param query
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> search(Query query) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }

    /**
     * @param filter
     * @return
     */
    default Mono<EntityWrapper<? extends Object>> filter(Filter filter) {
        return Mono.just(new EntityWrapper<String>(UNSUPPORTED_OPERATION));
    }


}
