package org.example;

public class Card {
    enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
    enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    Suit suit;
    Rank rank;
    boolean isOpen;

    public Card(Rank rank, Suit suit, boolean isOpen){
        this.rank = rank;
        this.suit = suit;
        this.isOpen = isOpen;
    }
    String cardAsString(){
        if(!isOpen) return "HIDDEN";
        return "[" + rank + "," + suit + "]";
    }
}
