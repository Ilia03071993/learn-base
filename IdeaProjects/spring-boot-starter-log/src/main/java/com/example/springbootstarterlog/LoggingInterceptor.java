package com.example.springbootstarterlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
    private final LoggingProperties properties;

    public LoggingInterceptor(LoggingProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (properties.isLogRequests()) {
            logger.info("Incoming request: method={}, uri={}, headers={}",
                    request.getMethod(), request.getRequestURI(), request.getHeaderNames());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (properties.isLogResponses()) {
            logger.info("Outgoing response: status={}, headers={}",
                    response.getStatus(), response.getHeaderNames());
        }
    }
}
