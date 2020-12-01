package dev.flashcards.server.deck.web;

import com.google.common.collect.ImmutableList;
import dev.flashcards.server.card.web.responses.CardResponse;
import dev.flashcards.server.deck.web.requests.DeckRequest;
import dev.flashcards.server.deck.web.responses.DeckResponse;
import dev.flashcards.server.slide.web.responses.SlideResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeckResponse create(DeckRequest request) {
        return null;
    }

    @GetMapping
    public Iterable<DeckResponse> findAll() {
        return ImmutableList.of(
                DeckResponse.builder()
                        .setId(1001)
                        .setTitle("Deck for Sam")
                        .setDescription("A deck of mixed items")
                        .setTags(Set.of("first", "mixed"))
                        .setCreator("Reynaldo")
                        .setCreationDate(LocalDate.now())
                        .setItems(ImmutableList.of(
                                new SlideResponse("This is a Slide!"),
                                new CardResponse("Is this a card?", "it is a fantasy")))
                        .build()
        );
    }

}
