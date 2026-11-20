package com.pluralsight.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void deal(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    public int getSize() {
        return cards.size();
    }

    public int getValue() {
        int total = 0;
        for (Card card : cards) {
            card.flip();
            total += card.getPointValue();
            card.flip();
        }
        return total;
    }

    public List<Card> getCards() {
        return cards;
    }
}