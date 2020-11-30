package dev.flashcards.server.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
public class WebConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return builder -> {
            builder.serializationInclusion(JsonInclude.Include.NON_NULL)
                    .failOnUnknownProperties(false)
                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        };
    }

}