package com.company;

import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //create two additional cards (joker)
        Card JokerOne = new Card(Card.Color.Black, Card.Figure.JOKER);
        Card JokerTwo = new Card(Card.Color.Red, Card.Figure.JOKER);

        //add joker to deck
        List<Card> deck = new LinkedList<>();
        deck.add(JokerOne);
        deck.add(JokerTwo);

        //create others cards
        for (Card.Color color : Card.Color.values()) {
            for (Card.Figure figure : Card.Figure.values()) {
                if (figure != Card.Figure.JOKER || color != Card.Color.Black || color != Card.Color.Red)
                    deck.add(new Card(color, figure));
            }

            boolean currentPlayer = false;

            //create degue
            ArrayDeque<Card> DeckA = new ArrayDeque<>();
            ArrayDeque<Card> DeckB = new ArrayDeque<>();
            ArrayDeque<Card> Table = new ArrayDeque();

            // share cards
            while (deck.size() != 0) {
                SecureRandom random = new SecureRandom();
                int n = random.nextInt(deck.size());
                // remove - Retrieves and removes the head of the queue represented by this deque.
                Card selectedCard = deck.remove(n);
                if (currentPlayer) {
                    DeckA.add(selectedCard);
                } else {
                    DeckB.add(selectedCard);
                }
                currentPlayer = !currentPlayer;
            }


            //game
            while (!(DeckA.isEmpty() || DeckB.isEmpty())) {
                Card selectedCardA = DeckA.pop();
                //pop - Pops an element from the stack represented by this deque.
                System.out.println(selectedCardA.toString());
                Card selectedCardB = DeckB.pop();
                System.out.println(selectedCardB.toString());

                if (selectedCardA.getFigure().ordinal() > selectedCardB.getFigure().ordinal()) {
                    DeckA.addLast(selectedCardA);
                    DeckA.addLast(selectedCardB);
                } else if (selectedCardA.getFigure().ordinal() < selectedCardB.getFigure().ordinal()) {
                    DeckB.addLast(selectedCardA);
                    DeckB.addLast(selectedCardB);
                } else
                    while (selectedCardA.getFigure().ordinal() == selectedCardB.getFigure().ordinal()) {
                        if (DeckA.isEmpty()) {
                            System.out.println("Wygrał gracz B");
                            break;
                        }
                        Card tieCardA = DeckA.pop();

                        if (DeckB.isEmpty()) {
                            System.out.println("Wygrał gracz A");
                            break;
                        }
                        Card tieCardB = DeckB.pop();

                        Table.add(selectedCardA);
                        Table.add(selectedCardB);
                        Table.add(tieCardA);
                        Table.add(tieCardB);

                        if (DeckA.isEmpty()) {
                            System.out.println("Wygrał gracz B");
                            break;
                        }

                        selectedCardA = DeckA.pop();

                        if (DeckB.isEmpty()) {
                            System.out.println("Wygrał gracz A");
                            break;
                        }

                        selectedCardB = DeckB.pop();

                        if (selectedCardA.getFigure().ordinal() > selectedCardB.getFigure().ordinal()) {
                            DeckA.addLast(selectedCardA);
                            DeckA.addLast(selectedCardB);
                            DeckA.addAll(Table.clone());
                            Table.clear();

                        } else if (selectedCardA.getFigure().ordinal() < selectedCardB.getFigure().ordinal()) {
                            DeckB.addLast(selectedCardA);
                            DeckB.addLast(selectedCardB);
                            DeckB.addAll(Table.clone());
                            Table.clear();

                        }
                    }
                if (DeckA.isEmpty()) {
                    System.out.println("Wygrał gracz B");
                } else
                    System.out.println("Wygrał gracz A");
            }
        }
    }
}


