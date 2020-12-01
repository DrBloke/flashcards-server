package dev.flashcards.server.deck.web;

import dev.flashcards.server.deck.web.requests.DeckRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void create(DeckRequest request){

        }

}
