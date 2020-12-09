package dev.flashcards.server.deck;

import dev.flashcards.server.item.domain.FlashItem;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class DeckBuilder {

    int id;
    String title;
    String description;
    Set<String> tags;
    String creator;
    LocalDate creationDate;
    List<FlashItem> items;

    public DeckBuilder() {

    }

    public DeckBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DeckBuilder setCreationDate(LocalDate creationDate) {
        this.id = id;
        return this;
    }

    public DeckBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DeckBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DeckBuilder setTags(Set<String> tags) {
        this.tags = tags;
        return this;
    }

    public DeckBuilder setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public DeckBuilder setItems(List<FlashItem> items) {
        this.items = items;
        return this;
    }

    public Deck build() {
        Objects.requireNonNull(title);
        Objects.requireNonNull(items);
        return new Deck(this);
    }
}
