package com.srkapi.shared.spring;


import com.srkapi.shared.middleware.Middleware;

import java.util.List;

public interface MiddlewareConfig {
    List<Middleware> getCommandMiddlewarePipeline();

    List<Middleware> getQueryMiddlewarePipeline();
}
