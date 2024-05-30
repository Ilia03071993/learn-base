package com.example.springbootstarterlog;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@ComponentScan
public class LoggingAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAutoConfiguration.class);

    public LoggingAutoConfiguration() {
        logger.info("HttpLoggingAutoConfiguration initialized");
    }

    @Bean
    @ConditionalOnMissingBean
    public LoggingInterceptor loggingInterceptor(LoggingProperties properties) {
        logger.info("HttpLoggingInterceptor bean created");
        return new LoggingInterceptor(properties);
    }

    @Configuration
    protected static class InterceptorConfig implements WebMvcConfigurer {
        private final LoggingInterceptor interceptor;

        public InterceptorConfig(LoggingInterceptor interceptor) {
            this.interceptor = interceptor;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            logger.info("HttpLoggingInterceptor registered");
            registry.addInterceptor(interceptor);
        }
    }
}
