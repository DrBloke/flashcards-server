package dev.flashcards.server.deck.web.responses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.item.web.responses.FlashItemResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Deck of Cards request
 *
 * @see CardRequest
 */
@JsonDeserialize(builder = DeckResponse.Builder.class)
public class DeckResponse {

    private final int id;
    private final String title;
    private final String description;
    private final Set<String> tags;
    private final String creator;
    private final LocalDate creationDate;
    private final List<FlashItemResponse> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckResponse that = (DeckResponse)o;
        return items.equals(that.items) && title.equals(that.title) &&
                Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, title, tags, description, creator, creationDate);
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonGetter("creationDate")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonGetter("tags")
    public Set<String> getTags() {
        return tags;
    }

    @JsonGetter("creator")
    public String getCreator() {
        return creator;
    }

    @JsonGetter("items")
    public List<FlashItemResponse> getItems() {
        return items;
    }

    private DeckResponse(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.tags = ImmutableSet.copyOf(builder.tags);
        this.creator = builder.creator;
        this.creationDate = builder.creationDate;
        this.items = ImmutableList.copyOf(builder.items);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {

        private int id;
        private String title;
        private String description;
        private Set<String> tags;
        private String creator;
        private LocalDate creationDate;
        private List<FlashItemResponse> items;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setTags(Set<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder setCreator(String creator) {
            this.creator = creator;
            return this;
        }

        public Builder setCreationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder setItems(List<FlashItemResponse> items) {
            this.items = items;
            return this;
        }

        public DeckResponse build() {
            Objects.requireNonNull(title);
            Objects.requireNonNull(items);
            return new DeckResponse(this);
        }
    }
}
