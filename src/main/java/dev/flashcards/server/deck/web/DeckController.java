package dev.flashcards.server.deck.web;

import dev.flashcards.server.deck.web.repository.DeckRepository;
import dev.flashcards.server.deck.web.requests.DeckRequest;
import dev.flashcards.server.deck.web.responses.DeckResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

    private DeckRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeckResponse create(DeckRequest request) {
        return null;
    }

    @GetMapping
    public Iterable<DeckResponse> findAll() {
        return repository.findAll();
    }

}
