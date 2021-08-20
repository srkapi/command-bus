package com.srkapi.shared.query;

public interface QueryBus {
    <R> R dispatch(Query<R> query) throws Exception;
}
