package com.srkapi.shared.command;

public interface CommandHandlerFactory {
  <R> CommandHandler<Command<R>, R> createCommandHandler(String commandName);
}
