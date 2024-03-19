package org.example;

public class Deck {
    Card[] cards = new Card[52];
    int numCards = 0;
    public Deck(){
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cards[numCards++] = new Card(rank, suit, false);
            }
        }
    }
    Card pickOne(){
        final Card card = cards[numCards-1];
        numCards--;
        return card;
    }
}
