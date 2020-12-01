package dev.flashcards.server.item.web.responses;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.flashcards.server.item.ItemConstants;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = ItemConstants.ITEM_TYPE_PROPERTY)
public interface FlashItemResponse {
}
