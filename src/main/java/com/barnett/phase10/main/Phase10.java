package com.barnett.phase10.main;

import com.barnett.phase10.gameComponents.Card;
import com.barnett.phase10.gameComponents.Deck;
import com.barnett.phase10.gameComponents.Phases;

import java.util.List;

public class Phase10 {
    public static void main(String[] args) {
        List<Card> cards;
        Deck deck = new Deck();
        Phases phases = new Phases();
        deck.reset();
        deck.shuffle();

        for (int runs = 100; runs > 0; runs--) {

            if (deck.isEmpty()) {
                deck.reset();
                deck.shuffle();
            }

            cards = deck.drawCard(10);

            System.out.println("These are your cards: ");
            System.out.println(cards);

            List<String> completePhases = phases.whichPhases(cards);

            StringBuilder result = new StringBuilder();
            result.append("You can complete these phases: ");

            for (String s : completePhases) {
                if (completePhases.size() == 1) {
                    result.append(s);
                } else {
                    result.append(s).append(", ");
                }
            }


            System.out.println(result);
        }
    }
}
