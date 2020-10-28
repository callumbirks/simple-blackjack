package com.callumbirks;

import java.util.Scanner;

public class Main {
    public static void printStatus(Hand<Card> dealerHand, Hand<Card> playerHand) {
        System.out.println("Your hand is: " + playerHand.toString());
        System.out.println("Dealer has " + dealerHand.getSize() +" cards, their upcard is " + dealerHand.getUpCard());
    }
    public static boolean checkInput(String input, String val1, String val2) {
        if(input.equals(val1) | input.equals(val2))
            return true;
        System.out.println("Invalid Input.");
        return false;
    }
    public static void main(String[] args) {
        String userInput;
        DeckOfCards<Card> deck = new DeckOfCards<>();
        Hand<Card> dealerHand = new Hand<>();
        Hand<Card> playerHand = new Hand<>();

        dealerHand.addCard(deck.removeCard());
        dealerHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());
        playerHand.addCard(deck.removeCard());

        printStatus(dealerHand, playerHand);

        Scanner s = new Scanner(System.in);

        //TODO: Implement splitting hand
        /*if(playerHand.equalCards()) {
            while(true) {
                System.out.println("Would you like to split your hand?(Y/N): ");
                userInput = s.nextLine().toUpperCase()
                if(checkInput(userInput,"Y","N"))
                    break;
            }
        }*/

        do {
            while(true) {
                System.out.print("H for Hit, S for Stand: ");
                userInput = s.nextLine().toUpperCase();
                if(checkInput(userInput,"H","S"))
                    break;
            }
            if (userInput.equals("H")) {
                playerHand.addCard(deck.removeCard());
                printStatus(dealerHand,playerHand);
            }
            if(playerHand.getHandValue() > 21) {
                System.out.println("Bust. Dealer wins.");
                System.exit(0);
            }
        } while(!userInput.equals("S"));

        while(dealerHand.getHandValue() < 17) {
            dealerHand.addCard(deck.removeCard());
            System.out.println("Dealer draws a card");
            printStatus(dealerHand, playerHand);
        }
        if(dealerHand.getHandValue() > 21) {
            System.out.println("Dealer's hand is: " + dealerHand.toString());
            System.out.println("Dealer bust. You win!");
            System.exit(0);
        }

        System.out.println("Dealer's hand is: " + dealerHand.toString());
        if(dealerHand.getHandValue() > playerHand.getHandValue())
            System.out.println("Dealer wins.");
        if(playerHand.getHandValue() > dealerHand.getHandValue())
            System.out.println("You win!");
        else
            System.out.println("It's a tie");
    }
}
