package dev.flashcards.server.slide;

import dev.flashcards.server.slide.web.requests.SlideRequest;
import dev.flashcards.server.slide.web.responses.SlideResponse;
import org.springframework.stereotype.Component;

@Component
public class SlideMapper {

    public SlideResponse toResponse(Slide slide) {
        return new SlideResponse(slide.getId(), slide.getText());
    }

    public Slide fromRequest(SlideRequest slideRequest) {
        return new Slide(null, slideRequest.getText());
    }
}
