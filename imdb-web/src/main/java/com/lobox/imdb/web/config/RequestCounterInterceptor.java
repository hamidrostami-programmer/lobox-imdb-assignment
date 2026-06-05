package com.lobox.imdb.web.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
@Component
public class RequestCounterInterceptor implements HandlerInterceptor {

    private final RequestCounter requestCounter;

    public RequestCounterInterceptor(RequestCounter requestCounter) {
        this.requestCounter = requestCounter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        requestCounter.increment();
        return true;
    }
}
