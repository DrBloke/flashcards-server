package dev.flashcards.server.deck.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.slide.web.requests.SlideRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DeckTypesRegisterBean {

    public DeckTypesRegisterBean(ObjectMapper objectMapper) {
        objectMapper.registerSubtypes(new NamedType(SlideRequest.class, SlideRequest.TYPE_NAME));
        objectMapper.registerSubtypes(new NamedType(CardRequest.class, CardRequest.TYPE_NAME));
    }

}
