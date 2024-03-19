package org.example;

public class Game {
    public static void main(String[] args){
        Deck deck = new Deck();
        final Card card = deck.pickOne();
        card.isOpen = true;
        System.out.println(card.cardAsString());
    }
}
