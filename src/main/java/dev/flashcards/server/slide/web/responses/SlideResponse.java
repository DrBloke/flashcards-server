package dev.flashcards.server.slide.web.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.flashcards.server.item.web.responses.FlashItemResponse;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class SlideResponse implements FlashItemResponse {

    private final Integer id;
    private final String text;

    @JsonCreator
    public SlideResponse(
            @JsonProperty("id") Integer id,
            @JsonProperty("text") String text) {
        this.id = id;
        this.text = requireNonNull(text);
    }

    @JsonGetter("id")
    public Integer getId() {
        return id;
    }

    @JsonGetter("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlideResponse slide = (SlideResponse)o;
        return text.equals(slide.text) &&
                Objects.equals(id, slide.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

}
