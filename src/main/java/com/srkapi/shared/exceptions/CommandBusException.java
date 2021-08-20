package com.srkapi.shared.exceptions;

public class CommandBusException extends RuntimeException {

  public CommandBusException(String message) {
    super(message);
  }
}
