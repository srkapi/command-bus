package com.srkapi.shared.spring;

import com.srkapi.shared.command.CommandBus;
import com.srkapi.shared.command.DefaultCommandBus;
import com.srkapi.shared.query.DefaultQueryBus;
import com.srkapi.shared.query.QueryBus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.srkapi")
public class CommandBusSpringConfiguration {
    private final Log log = LogFactory.getLog(CommandBusSpringConfiguration.class);

    private ApplicationContext applicationContext;

    @Autowired
    public CommandBusSpringConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public CommandBus getCommandBus() {
        return new DefaultCommandBus(
                findHandlerFactoryConfig().getCommandHandlerFactory(),
                findMiddlewareConfig().getQueryMiddlewarePipeline()
        );
    }

    @Bean
    public QueryBus getQueryBus() {
        return new DefaultQueryBus(
                findHandlerFactoryConfig().getQueryhandlerFactory(),
                findMiddlewareConfig().getQueryMiddlewarePipeline()
        );
    }

    private HandlerFactoryConfig findHandlerFactoryConfig() {
        HandlerFactoryConfig scannedHandlerFactoryConfig = scanHandlerFactoryConfig();
        if (scannedHandlerFactoryConfig != null) {
            return scannedHandlerFactoryConfig;
        }

        log.info("Custom @Configuration-annotated HandlerFactoryConfig not found, using DefaultHandlerFactoryConfig");
        return new DefaultHandlerFactoryConfig(this.applicationContext,"com.srkapi");
    }

    private MiddlewareConfig findMiddlewareConfig() {
        MiddlewareConfig scannedMiddlewareConfig = scanMiddlewareConfig();
        if (scannedMiddlewareConfig != null) {
            return scannedMiddlewareConfig;
        }

        log.info("Custom @Configuration-annotated MiddlewareConfig not found, using DefaultMiddlewareConfig");
        return new DefaultMiddlewareConfig();
    }

    private HandlerFactoryConfig scanHandlerFactoryConfig() {
        return (HandlerFactoryConfig) applicationContext.getBeansWithAnnotation(Configuration.class).values().stream()
                .filter(c -> c instanceof HandlerFactoryConfig)
                .findFirst()
                .orElse(null);
    }

    private MiddlewareConfig scanMiddlewareConfig() {
        return (MiddlewareConfig) applicationContext.getBeansWithAnnotation(Configuration.class).values().stream()
                .filter(c -> c instanceof MiddlewareConfig)
                .findFirst()
                .orElse(null);
    }
}
