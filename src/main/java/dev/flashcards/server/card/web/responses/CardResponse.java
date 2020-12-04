package dev.flashcards.server.card.web.responses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.flashcards.server.item.web.responses.FlashItemResponse;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

@JsonDeserialize(builder = CardResponse.Builder.class)
public class CardResponse implements FlashItemResponse {

    private final Integer id;
    private final String question;
    private final String answer;

    private CardResponse(Builder builder) {
        this.id = builder.id;
        this.question = builder.question;
        this.answer = builder.answer;
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

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardResponse card = (CardResponse)o;
        return question.equals(card.question) &&
                answer.equals(card.answer) &&
                Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {

        Integer id;
        String question;
        String answer;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setQuestion(String question) {
            this.question = question;
            return this;
        }

        public Builder setAnswer(String answer) {
            this.answer = answer;
            return this;
        }

        public CardResponse build() {
            requireNonNull(question);
            requireNonNull(answer);
            return new CardResponse(this);
        }
    }

}
