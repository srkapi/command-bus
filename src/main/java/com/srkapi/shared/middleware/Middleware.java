package com.srkapi.shared.middleware;


import com.srkapi.shared.message.Message;

public interface Middleware {
  <R> R handle(Message<R> message, NextMiddlewareFunction<Message<R>, R> next) throws Exception;
}
