package com.srkapi.shared.message;

public interface MessageHandler<T extends Message<R>, R> {
  R handle(T message) throws Exception;
}
