package dev.flashcards.server.slide.web.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.flashcards.server.item.web.FlashItemRequest;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class SlideRequest implements FlashItemRequest {

    public static final String TYPE_NAME = "slide";

    private final String text;

    @JsonCreator
    public SlideRequest(@JsonProperty("text") String text) {
        this.text = requireNonNull(text);
    }

    @JsonGetter("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlideRequest slide = (SlideRequest) o;
        return text.equals(slide.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

}
