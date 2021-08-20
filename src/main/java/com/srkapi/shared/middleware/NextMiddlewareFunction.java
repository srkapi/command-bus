package com.srkapi.shared.middleware;


import com.srkapi.shared.message.Message;

public interface NextMiddlewareFunction<T extends Message<R>, R> {
  R call(T message) throws Exception;
}
