package com.pluralsight.blackjack;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        if (isFaceUp) {
            return suit;
        }
        return "#";
    }

    public String getValue() {
        if (isFaceUp) {
            return value;
        }
        return "#";
    }

    public int getPointValue() {
        if (!isFaceUp) {
            return 0;
        }
        return switch (value) {
            case "A" -> 11;
            case "K", "Q", "J" -> 10;
            default -> Integer.parseInt(value);
        };
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {
        if (!isFaceUp) {
            return "[Face Down]";
        }
        return value + " of " + suit + " (" + getPointValue() + " pts)";
    }
}