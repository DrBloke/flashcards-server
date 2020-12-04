package dev.flashcards.server.card.web;

import dev.flashcards.server.card.Card;
import dev.flashcards.server.card.CardBuilder;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.card.web.responses.CardResponse;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardResponse toResponse(Card card) {
        return CardResponse.builder()
                .setId(card.getId())
                .setQuestion(card.getQuestion())
                .setAnswer(card.getAnswer())
                .build();
    }

    public Card fromRequest(CardRequest cardRequest) {
        var cardBuilder = new CardBuilder();
        return cardBuilder
                .setQuestion(cardRequest.getQuestion())
                .setAnswer(cardRequest.getAnswer())
                .build();
    }
}
