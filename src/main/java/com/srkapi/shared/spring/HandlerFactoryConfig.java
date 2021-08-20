package com.srkapi.shared.spring;


import com.srkapi.shared.command.CommandHandlerFactory;
import com.srkapi.shared.query.QueryHandlerFactory;

public interface HandlerFactoryConfig {
  CommandHandlerFactory getCommandHandlerFactory();
  QueryHandlerFactory getQueryhandlerFactory();
}
