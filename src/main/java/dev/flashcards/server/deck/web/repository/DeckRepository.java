package dev.flashcards.server.deck.web.repository;

import com.google.common.collect.ImmutableList;
import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.DeckBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeckRepository {

    private final AtomicInteger nextId = new AtomicInteger(100);
    private final List<Deck> store = new ArrayList<>();

    int getNewId() {
        return nextId.getAndIncrement();
    }

    public List<Deck> findAll() {
        return ImmutableList.copyOf(store);
    }

    public void save(Deck deck) {
        final DeckBuilder deckBuilder = new DeckBuilder();
        store.add(deck);
    }

    public void delete(Deck deck) {
        for (Deck stored : store) {
            if (stored.equals(deck)) {
                store.remove(stored);
                break;
            }
        }
    }

}
