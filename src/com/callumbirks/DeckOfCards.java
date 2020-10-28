package com.callumbirks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards<T extends Card> {
    private List<T> currentDeck = new ArrayList<>(52);
    public DeckOfCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                currentDeck.add((T) new Card(i,j));
            }
        }
        Collections.shuffle(currentDeck);
    }
    public T removeCard() {
        if(currentDeck.isEmpty())
            return null;
        return currentDeck.remove(0);
    }
}
