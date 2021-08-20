package com.srkapi.shared.command;

public interface CommandBus {
  <R> R dispatch(com.srkapi.shared.command.Command<R> command) throws Exception;
}
