package com.lobox.imdb.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final RequestCounterInterceptor interceptor;

    public WebConfig(RequestCounterInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
