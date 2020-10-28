package com.callumbirks;

import java.util.Objects;

public class Card implements CardFace {
    private int house;
    private int value;
    public Card(int house, int value) {
        this.house = house;
        this.value = value;
    }

    public int getValue() { return this.value; }
    public int getHouse() { return this.house; }
    public int getNumericalValue() { return valueMap[this.value]; }
    public void setAce1() { this.value = 13; }

    @Override
    public String toString() {
        return valueArray[value] + " of " +
                houseArray[house];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return house == card.house &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, value);
    }
}
