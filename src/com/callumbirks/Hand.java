package com.callumbirks;

import java.util.*;

public class Hand<T extends Card> {
    private int handValue;
    private List<T> currentHand = new ArrayList<>();
    private T upCard;

    public void addCard(T card) {
        currentHand.add(card);
        Collections.sort(currentHand, Comparator.comparing(T::getValue));
        if(upCard == null)
            upCard = card;
        calculateHand();
    }

    public int getHandValue() {
        return handValue;
    }

    public void calculateHand() {
        int temporaryHandValue = 0;
        handValue = 0;
        for(T card : currentHand) {
            if(temporaryHandValue + card.getNumericalValue() > 21) {
                for(T card1 : currentHand) {
                    if (card1.getValue() == 0) {
                        card1.setAce1();
                        currentHand.set(currentHand.indexOf(card1), card1);
                    }
                }
            }
            temporaryHandValue += card.getNumericalValue();
        }
        for(T card : currentHand) {
            handValue += card.getNumericalValue();
        }
    }

    public boolean equalCards() {
        if(currentHand.get(0).getValue() == currentHand.get(1).getValue())
            return true;
        return false;
    }

    public int getSize() {
        return currentHand.size();
    }

    public T getUpCard() {
        return upCard;
    }

    @Override
    public String toString() {
        return "handValue=" + handValue +
                ", currentHand=" + currentHand;
    }
}
