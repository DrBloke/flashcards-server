package dev.flashcards.server.card;

public class CardBuilder {

    Integer id;
    String question;
    String answer;

    public CardBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public CardBuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public CardBuilder setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Card build() {
        return new Card(this);
    }
}