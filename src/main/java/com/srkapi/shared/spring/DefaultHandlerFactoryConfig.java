package com.srkapi.shared.spring;

import com.srkapi.shared.command.CommandHandlerFactory;
import com.srkapi.shared.query.QueryHandlerFactory;
import org.springframework.context.ApplicationContext;

public class DefaultHandlerFactoryConfig implements HandlerFactoryConfig {
  private SpringAutoScanHandlerFactory springAutoScanHandlerFactory;

  public DefaultHandlerFactoryConfig(ApplicationContext context, String basePackage) {
    this.springAutoScanHandlerFactory = new SpringAutoScanHandlerFactory(context,basePackage);
  }

  @Override
  public CommandHandlerFactory getCommandHandlerFactory() {
    return springAutoScanHandlerFactory;
  }

  @Override
  public QueryHandlerFactory getQueryhandlerFactory() {
    return springAutoScanHandlerFactory;
  }
}
