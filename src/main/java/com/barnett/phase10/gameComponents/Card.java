package com.barnett.phase10.gameComponents;

import lombok.Data;

@Data
public class Card implements Comparable {
    @Override
    public int compareTo(Object o) {
        if (o.getClass() != Card.class) {
            return 0;
        }
        Card c = (Card) o;
        if (this.value.ordinal() < c.value.ordinal()) {
            return -1;
        } else if (this.value.ordinal() > c.value.ordinal()) {
            return 1;
        }
        return 0;
    }


    public enum Color {
        Red, Blue, Green, Yellow;

        private static final Color[] colors = Color.values();

        public static Color getColor(int i) {
            return Color.colors[i];
        }
    }

    public enum Value {
        one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, skip; // todo implement wild;

        private static final Value[] values = Value.values();

        public static Value getValue(int i) {
            return Value.values[i];
        }
    }

    private final Color color;
    private final Value value;

    public Card(final Color color, final Value value) {
        this.color = color;
        this.value = value;
    }


    public Color getCardColor() {
        return this.color;
    }

    public Value getCardValue() {
        return this.value;
    }

    public int getCardOrdinalValue() {
        return this.value.ordinal();
    }

    @Override
    public String toString() {
        return color + "_" + value;
    }


}
