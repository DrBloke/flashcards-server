package dev.flashcards.server.deck.web;

import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.DeckBuilder;
import dev.flashcards.server.deck.web.requests.DeckRequest;
import dev.flashcards.server.deck.web.responses.DeckResponse;
import dev.flashcards.server.deck.web.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

    private final DeckService service;
    private final DeckMapper deckMapper;

    @Autowired
    public DeckController(DeckService service, DeckMapper deckMapper) {
        this.service = service;
        this.deckMapper = deckMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeckResponse create(@RequestBody DeckRequest request) {
        var newDeck = deckMapper.fromRequest(request);
        return deckMapper.toResponse(service.save(newDeck));
    }

    @GetMapping
    public Iterable<DeckResponse> findAll() {
        return service.findAll().stream()
                .map(d -> deckMapper.toResponse(d))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        var builder = new DeckBuilder();
        service.delete(id);
    }

}
