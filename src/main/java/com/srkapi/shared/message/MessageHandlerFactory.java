package com.srkapi.shared.message;

public interface MessageHandlerFactory {
  <R> MessageHandler<Message<R>, R> createHandler(String messageName);
}
