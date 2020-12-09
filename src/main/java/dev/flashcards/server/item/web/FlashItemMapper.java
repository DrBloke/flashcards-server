package dev.flashcards.server.item.web;

import dev.flashcards.server.card.Card;
import dev.flashcards.server.card.web.CardMapper;
import dev.flashcards.server.card.web.requests.CardRequest;
import dev.flashcards.server.item.domain.FlashItem;
import dev.flashcards.server.item.web.requests.FlashItemRequest;
import dev.flashcards.server.item.web.responses.FlashItemResponse;
import dev.flashcards.server.slide.Slide;
import dev.flashcards.server.slide.SlideMapper;
import dev.flashcards.server.slide.web.requests.SlideRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlashItemMapper {

    private final CardMapper cardMapper;
    private final SlideMapper slideMapper;

    @Autowired
    public FlashItemMapper(CardMapper cardMapper, SlideMapper slideMapper) {
        this.cardMapper = cardMapper;
        this.slideMapper = slideMapper;
    }

    public FlashItemResponse toResponse(FlashItem item) {
        if (item instanceof Slide) {
            return slideMapper.toResponse((Slide)item);
        } else if (item instanceof Card) {
            return cardMapper.toResponse((Card)item);
        }
        return new NoOpFlashItemResponse();
    }

    public FlashItem fromRequest(FlashItemRequest item) {
        if (item instanceof SlideRequest) {
            return slideMapper.fromRequest((SlideRequest)item);
        } else if (item instanceof CardRequest) {
            return cardMapper.fromRequest((CardRequest)item);
        }
        return new NoOpFlashItem();
    }

    private static class NoOpFlashItemResponse implements FlashItemResponse {
    }

    private static class NoOpFlashItem implements FlashItem {
    }
}
