package com.lobox.imdb.web;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author h.rostami
 * @since 02-Jun-2026
 */
@EnableJpaRepositories(basePackages = "com.lobox.imdb.da")
@ComponentScan(basePackages = {"com.lobox"})
@EntityScan(basePackages = "com.lobox.imdb.da.entity")
@Configuration
public class ImdbApplicationConfiguration {
}
