package dev.flashcards.server.deck.web.repository;

import dev.flashcards.server.deck.domain.Deck;
import dev.flashcards.server.deck.domain.DeckBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeckRepository {

    private final AtomicInteger nextId = new AtomicInteger(100);
    private final List<Deck> store = new ArrayList<>();

    int getNewId() {
        return nextId.getAndIncrement();
    }

    public void save(Deck deck){
        final DeckBuilder deckBuilder = new DeckBuilder();

        store.add(deck);
    }

}
