package dev.flashcards.server.item.web;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
public interface FlashItemRequest {
}
