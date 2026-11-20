package com.pluralsight.blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player 1 name: ");
        String player1Name = scanner.nextLine().trim();

        System.out.print("Enter player 2 name: ");
        String player2Name = scanner.nextLine().trim();

        Deck deck = new Deck();
        deck.shuffle();

        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        for (int i = 0; i < 2; i++) {
            player1Hand.deal(deck.deal());
            player2Hand.deal(deck.deal());
        }

        int player1Score = player1Hand.getValue();
        int player2Score = player2Hand.getValue();

        System.out.println("\n--- Results ---");
        printHand(player1Name, player1Hand, player1Score);
        printHand(player2Name, player2Hand, player2Score);

        System.out.println("\nOutcome: " + determineWinner(player1Name, player1Score, player2Name, player2Score));

        scanner.close();
    }

    private static void printHand(String playerName, Hand hand, int score) {
        System.out.print(playerName + " has: ");
        for (int i = 0; i < hand.getCards().size(); i++) {
            Card card = hand.getCards().get(i);
            card.flip();
            System.out.print(card.getValue() + " of " + card.getSuit());
            card.flip();
            if (i < hand.getCards().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" | Hand Value: " + score);
    }

    public static String determineWinner(String player1Name, int player1Score, String player2Name, int player2Score) {
        boolean p1Bust = player1Score > 21;
        boolean p2Bust = player2Score > 21;

        if (p1Bust && p2Bust) {
            return "Both players busted! No winner.";
        }
        if (p1Bust) {
            return player2Name + " wins! (" + player1Name + " busted)";
        }
        if (p2Bust) {
            return player1Name + " wins! (" + player2Name + " busted)";
        }
        if (player1Score > player2Score) {
            return player1Name + " wins with " + player1Score + " points!";
        }
        if (player2Score > player1Score) {
            return player2Name + " wins with " + player2Score + " points!";
        }
        return "It's a tie at " + player1Score + " points!";
    }
}