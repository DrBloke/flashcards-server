package dev.flashcards.server.deck.web;

import dev.flashcards.server.deck.Deck;
import dev.flashcards.server.deck.DeckBuilder;
import dev.flashcards.server.deck.web.requests.DeckRequest;
import dev.flashcards.server.deck.web.responses.DeckResponse;
import dev.flashcards.server.item.web.FlashItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DeckMapper {

    private final FlashItemMapper flashItemMapper;

    @Autowired
    public DeckMapper(FlashItemMapper flashItemMapper) {
        this.flashItemMapper = flashItemMapper;
    }

    public Deck fromRequest(DeckRequest request) {
        var deckBuilder = new DeckBuilder();
        return deckBuilder.setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setCreator(request.getCreator())
                .setTags(request.getTags())
                .setItems(request.getItems().stream()
                        .map(fi -> flashItemMapper.fromRequest(fi))
                        .collect(Collectors.toList()))
                .build();
    }

    public DeckResponse toResponse(Deck deck) {
        return DeckResponse.builder()
                .setId(deck.getId())
                .setTitle(deck.getTitle())
                .setDescription(deck.getDescription())
                .setCreator(deck.getCreator())
                .setCreationDate(deck.getCreationDate())
                .setTags(deck.getTags())
                .setItems(deck.getItems().stream()
                        .map(fi -> flashItemMapper.toResponse(fi))
                        .collect(Collectors.toList()))
                .build();
    }
}
