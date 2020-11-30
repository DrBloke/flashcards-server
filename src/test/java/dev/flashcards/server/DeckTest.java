package dev.flashcards.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.deck.web.DeckTypesRegisterBean;
import dev.flashcards.server.deck.web.requests.DeckRequest;
import dev.flashcards.server.slide.web.requests.SlideRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    public final Logger log = LoggerFactory.getLogger(this.getClass());

    static {
        new DeckTypesRegisterBean(MAPPER);
    }

    @Test
    public void serialization_deckOfItems_readWriteOk() throws JsonProcessingException {
        final DeckRequest deck = DeckRequest.builder()
                .setTitle("First Deck")
                .setDescription("A deck of items")
                .setTags(Set.of("test"))
                .setCreator("user")
                .setItems(ImmutableList.of(
                        new SlideRequest("This is a Slide!"),
                        new CardRequest("I am a card")))
                .build();
        final String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(deck);
        log.info(json);
        final DeckRequest read = MAPPER.readValue(json, DeckRequest.class);
        assertEquals(deck, read);
    }

}
