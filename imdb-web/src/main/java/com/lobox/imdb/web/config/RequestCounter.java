package com.lobox.imdb.web.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author h.rostami
 * @since 05-Jun-2026
 */
@Component
public class RequestCounter {

    private final AtomicLong counter = new AtomicLong();

    public void increment() {
        counter.incrementAndGet();
    }

    public long getCount() {
        return counter.get();
    }
}
