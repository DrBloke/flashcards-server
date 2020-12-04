package dev.flashcards.server.deck.web;

import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.web.responses.DeckResponse;
import dev.flashcards.server.item.web.FlashItemMapper;
import org.springframework.stereotype.Component;

@Component
public class DeckMapper {

    private final FlashItemMapper flashItemMapper;

    public DeckResponse toResponse(Deck deck) {
        return DeckResponse.builder()
                .setId(deck.getId())
                .setTitle(deck.getTitle())
                .setDescription(deck.getDescription())
                .setCreator(deck.getCreator())
                .setCreationDate(deck.getCreationDate())
                .setTags(deck.getTags())
                .setItems(deck.getItems().stream()
                        .map(flashItemMapper.toResponse()))
                .build();
    }
}
