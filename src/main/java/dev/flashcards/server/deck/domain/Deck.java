package dev.flashcards.server.deck.domain;

import com.google.common.collect.ImmutableList;
import dev.flashcards.server.item.domain.FlashItem;
import dev.flashcards.server.item.web.FlashItemRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Deck of Items
 *
 * @see FlashItem
 */
public class Deck {

    private final int id;
    private final String title;
    private final String description;
    private final Set<String> tags;
    private final String creator;
    private final LocalDate creationDate;
    private final List<FlashItem> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck that = (Deck) o;
        return items.equals(that.items) && title.equals(that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(id, that.id) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(creator, that.creator);
    }

    public int hashCode() {
        return Objects.hash(id, items, title, tags, description, creator, creationDate);
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getTags() {
        return tags;
    }

    public String getCreator() {
        return creator;
    }

    public List<FlashItem> getItems() {
        return items;
    }

    public Deck(DeckBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.tags = builder.tags;
        this.creator = builder.creator;
        this.creationDate = builder.creationDate;
        this.items = ImmutableList.copyOf(builder.items);
    }

}
