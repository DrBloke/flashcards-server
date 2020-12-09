package dev.flashcards.server.deck.web.repository;

import com.google.common.collect.ImmutableList;
import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.DeckBuilder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Repository
public class DeckRepository {

    private final AtomicInteger nextId = new AtomicInteger(100);
    private final List<Deck> store = new ArrayList<>();

    int getNewId() {
        return nextId.getAndIncrement();
    }

    public List<Deck> findAll() {
        return ImmutableList.copyOf(store);
    }

    public Deck save(Deck deck) {
        final var deckBuilder = new DeckBuilder();
        var saveDeck = deckBuilder.setId(getNewId())
                .setDescription(deck.getDescription())
                .setTitle(deck.getTitle())
                .setCreationDate(deck.getCreationDate())
                .setCreator(deck.getCreator())
                .setCreationDate(LocalDate.now())
                .setItems(deck.getItems())
                .setTags(deck.getTags())
                .build();
        store.add(saveDeck);
        return saveDeck;
    }

    public void delete(int id) {
        store.removeIf(d -> d.getId() == id);
    }

}
