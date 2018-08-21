package com.company;

public class Card {

    private Color color;
    private Figure figure;

    public enum Figure {
        NUMBER_2,
        NUMBER_3,
        NUMBER_4,
        NUMBER_5,
        NUMBER_6,
        NUMBER_7,
        NUMBER_8,
        NUMBER_9,
        NUMBER_10,
        JACK,
        QUEEN,
        KING,
        ACE,
        JOKER
    }

    public enum Color {
        Heart,
        Spade,
        Club,
        Diamond,
        Black,
        Red,
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Card(Color color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return
                color +
                        "" + figure;
    }
}
