package com.reactive.api.framework.v1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Pagination {

    private int pageNumber;

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber);
    }

    @Override
    public boolean equals(Object obj){
        boolean isEqual = super.equals(obj);
        if(!isEqual && obj instanceof Pagination){
            Pagination pagination = (Pagination) obj;
            isEqual = this.pageNumber == pagination.pageNumber;
        }
        return isEqual;
    }

}
