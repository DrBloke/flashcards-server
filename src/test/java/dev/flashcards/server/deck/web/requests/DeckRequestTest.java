package dev.flashcards.server.deck.web.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.deck.web.DeckTypesRegisterBean;
import dev.flashcards.server.item.web.requests.FlashItemRequest;
import dev.flashcards.server.slide.web.requests.SlideRequest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckRequestTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(DeckRequestTest.class);

    static {
        new DeckTypesRegisterBean(MAPPER);
    }

    private Supplier<DeckRequest> deckRequestFixture = () -> DeckRequest.builder()
            .setTitle("First Deck")
            .setDescription("A deck of items")
            .setTags(Set.of("test"))
            .setCreator("user")
            .setItems(ImmutableList.of(
                    new SlideRequest("This is a Slide!"),
                    new CardRequest("Is this a card?", "it is a fantasy")))
            .build();

    @Test
    public void serialization_deckOfItems_readWriteOk() throws JsonProcessingException {
        final DeckRequest deckRequest = deckRequestFixture.get();
        final String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(deckRequest);
        LOG.info(json);
        final DeckRequest read = MAPPER.readValue(json, DeckRequest.class);
        assertEquals(deckRequest, read);
    }

    @Test
    public void iteration_deckOfItems_handlesTypes() {
        final DeckRequest deckRequest = deckRequestFixture.get();

        final Consumer<FlashItemRequest> itemHandler = item -> {
            if (item instanceof SlideRequest) {
                SlideRequest slideRequest = (SlideRequest) item;
                LOG.info(slideRequest.getText());
            }
            if (item instanceof CardRequest) {
                CardRequest cardRequest = (CardRequest) item;
                LOG.info("{} : {}", cardRequest.getAnswer(), cardRequest.getQuestion());
            }
        };
        deckRequest.getItems().stream().forEach(itemHandler);
    }
}