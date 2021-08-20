package com.srkapi.shared.spring;


import com.srkapi.shared.LoggingMiddleware;
import com.srkapi.shared.middleware.Middleware;

import java.util.Collections;
import java.util.List;

public class DefaultMiddlewareConfig implements MiddlewareConfig {
  @Override
  public List<Middleware> getCommandMiddlewarePipeline() {
    return Collections.singletonList(
        new LoggingMiddleware()
    );
  }

  @Override
  public List<Middleware> getQueryMiddlewarePipeline() {
    return Collections.singletonList(
        new LoggingMiddleware()
    );
  }
}
