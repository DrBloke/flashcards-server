package dev.flashcards.server.deck.web;

import com.google.common.collect.ImmutableList;
import dev.flashcards.server.deck.DeckBuilder;
import dev.flashcards.server.deck.web.repository.DeckRepository;
import dev.flashcards.server.deck.web.service.DeckService;
import dev.flashcards.server.slide.Slide;
import dev.flashcards.server.slide.web.requests.SlideRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeckService service;

    @Test
    public void get_noparams_returnsAllDecks() throws Exception {
        var builder = new DeckBuilder();
        service.save(builder
                .setTitle("foo")
                .setDescription("bar")
                .setItems(ImmutableList.of(
                        new Slide(null, "test slide")
                ))
                .build());
        mockMvc.perform(get("/api/deck"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"title\":\"foo\"")));
    }

    @Test
    public void post_validPayload_createsNewDeck() throws Exception {
        var jsonPayload = "{\n" +
                "  \"title\" : \"First Deck\",\n" +
                "  \"description\" : \"A deck of items\",\n" +
                "  \"tags\" : [ \"test\" ],\n" +
                "  \"creator\" : \"user\",\n" +
                "  \"items\" : [ {\n" +
                "    \"type\" : \"slide\",\n" +
                "    \"text\" : \"This is a Slide!\"\n" +
                "  }, {\n" +
                "    \"type\" : \"card\",\n" +
                "    \"question\" : \"Is this a card?\",\n" +
                "    \"answer\" : \"it is a fantasy\"\n" +
                "  } ]\n" +
                "}";
        mockMvc.perform(post("/api/deck")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("\"id\":")));
    }

    @Test
    public void delete_validId_removesEntry() throws Exception {
        var builder = new DeckBuilder();
        service.save(builder
                .setTitle("foo")
                .setDescription("bar")
                .setItems(ImmutableList.of(
                        new Slide(null, "test slide")
                ))
                .build());
        int id = service
                .findAll()
                .stream()
                .findFirst()
                .get()
                .getId();
        mockMvc.perform(delete("/api/deck/" + id))
                .andExpect(status().isNoContent());
    }

}