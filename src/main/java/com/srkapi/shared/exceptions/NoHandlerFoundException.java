package com.srkapi.shared.exceptions;


import com.srkapi.shared.message.Message;

public class NoHandlerFoundException extends CommandBusException {
  public NoHandlerFoundException(Class<? extends Message> messageClass) {
    super(String.format("No handler found for %s", messageClass.getName()));
  }

  public NoHandlerFoundException(String messageClassName) {
    super(String.format("No handler found for %s", messageClassName));
  }
}
