package dev.flashcards.server.slide;

import dev.flashcards.server.item.domain.FlashItem;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Slide implements FlashItem {

    private final Integer id;
    private final String text;

    public Slide(Integer id,
                 String text) {
        this.id = id;
        this.text = requireNonNull(text);
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slide slide = (Slide)o;
        return text.equals(slide.text) &&
                Objects.equals(id, slide.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

}
