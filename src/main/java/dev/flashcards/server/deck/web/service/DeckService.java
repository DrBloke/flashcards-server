package dev.flashcards.server.deck.web.service;

import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.web.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private final DeckRepository repository;

    @Autowired
    public DeckService(DeckRepository repository) {
        this.repository = repository;
    }

    public List<Deck> findAll() {
        return repository.findAll();
    }

    public Deck save(Deck deck) {
        return repository.save(deck);
    }

    public void delete(Deck deck) {
        repository.delete(deck.getId());
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
