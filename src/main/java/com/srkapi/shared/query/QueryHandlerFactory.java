package com.srkapi.shared.query;

public interface QueryHandlerFactory {
  <R> QueryHandler<Query<R>, R> createQueryHandler(String queryName);
}
