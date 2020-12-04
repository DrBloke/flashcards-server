package dev.flashcards.server.card;

import dev.flashcards.server.item.domain.FlashItem;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Card implements FlashItem {

    private final Integer id;
    private final String question;
    private final String answer;

    public Card(CardBuilder builder) {
        this.id = builder.id;
        this.question = requireNonNull(builder.question);
        this.answer = requireNonNull(builder.answer);
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card)o;
        return question.equals(card.question) &&
                answer.equals(card.answer) &&
                Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

}
