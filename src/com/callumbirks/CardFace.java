package com.callumbirks;

public interface CardFace {
    String HEARTS = "Hearts";
    String CLUBS = "Clubs";
    String SPADES = "Spades";
    String DIAMONDS = "Diamonds";

    String[] houseArray = {HEARTS, CLUBS, SPADES, DIAMONDS};
    String[] valueArray = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    int[] valueMap = {11,2,3,4,5,6,7,8,9,10,10,10,10,1};
}
