package dev.flashcards.server.card.web.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.flashcards.server.item.web.FlashItemRequest;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class CardRequest implements FlashItemRequest {

    public static final String TYPE_NAME = "card";

    private final String content;

    @JsonCreator
    public CardRequest(@JsonProperty("content") String content) {
        this.content = requireNonNull(content);
    }

    @JsonGetter("content")
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardRequest card = (CardRequest) o;
        return content.equals(card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
