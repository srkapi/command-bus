package com.srkapi.shared.message;

public interface MessageBus {
  <R> R dispatch(Message<R> message) throws Exception;
}
