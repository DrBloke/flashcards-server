package dev.flashcards.server.deck.web.requests;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.item.web.requests.FlashItemRequest;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Deck of Cards request
 *
 * @see CardRequest
 */
@JsonDeserialize(builder = DeckRequest.Builder.class)
public class DeckRequest {

    private final String title;
    private final String description;
    private final Set<String> tags;
    private final String creator;
    private final List<FlashItemRequest> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckRequest that = (DeckRequest) o;
        return items.equals(that.items) && title.equals(that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, title, tags, description, creator);
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
    public List<FlashItemRequest> getItems() {
        return items;
    }

    DeckRequest(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.tags = builder.tags;
        this.creator = builder.creator;
        this.items = ImmutableList.copyOf(builder.items);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {

        String title;
        String description;
        Set<String> tags;
        String creator;
        List<FlashItemRequest> items;

        private Builder(){
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

        public Builder setItems(List<FlashItemRequest> items) {
            this.items = items;
            return this;
        }

        public DeckRequest build() {
            Objects.requireNonNull(title);
            Objects.requireNonNull(items);
            return new DeckRequest(this);
        }
    }
}
