package dev.flashcards.server.card.web.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.flashcards.server.item.web.requests.FlashItemRequest;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class CardRequest implements FlashItemRequest {

    private final String question;
    private final String answer;

    @JsonCreator
    public CardRequest(@JsonProperty("question") String question,
                       @JsonProperty("answer") String answer) {
        this.question = requireNonNull(question);
        this.answer = requireNonNull(answer);
    }

    @JsonGetter("question")
    public String getQuestion() {
        return question;
    }

    @JsonGetter("answer")
    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardRequest card = (CardRequest) o;
        return question.equals(card.question) && answer.equals(card.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

}
