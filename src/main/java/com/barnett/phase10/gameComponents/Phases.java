package com.barnett.phase10.gameComponents;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Phases {

    public List<String> whichPhases(List<Card> cards) {
        removeSkipCards(cards);
        List<String> completePhases = new ArrayList<String>();
        List<Card> testCards = new ArrayList<>(cards);

        //Phase 1: 2 sets of 3
        if (nSetsOfX(testCards, 2, 3)) {
            completePhases.add("Phase 1");
        }

        testCards = new ArrayList<>(cards);

        //Phase 2: 1 set of 3 + 1 run of 4
        if (nSetsOfX(testCards, 1, 3) && nRunOfX(testCards, 1, 4)) {
            completePhases.add("Phase 2");
        }

        testCards = new ArrayList<>(cards);
        //Phase 3: 1 set of 4 + 1 run of 4
        if (nSetsOfX(testCards, 1, 4) && nRunOfX(testCards, 1, 4)) {
            completePhases.add("Phase 3");
        }

        testCards = new ArrayList<>(cards);
        //Phase 4: 1 run of 7
        if (nRunOfX(testCards, 1, 7)) {
            completePhases.add("Phase 4");
        }

        testCards = new ArrayList<>(cards);
        //Phase 5: 1 run of 8
        if (nRunOfX(testCards, 1, 8)) {
            completePhases.add("Phase 5");
        }

        testCards = new ArrayList<>(cards);
        //Phase 6: 1 run of 9
        if (nRunOfX(testCards, 1, 9)) {
            completePhases.add("Phase 6");
        }

        testCards = new ArrayList<>(cards);
        //Phase 7: 2 sets of 4
        if (nSetsOfX(testCards, 2, 4)) {
            completePhases.add("Phase 7");
        }

        testCards = new ArrayList<>(cards);
        //Phase 8: 7 cards of one color (Ignore this phase)
        if (sevenOfSameColor(testCards)) {
            completePhases.add("Phase 8");
        }

        testCards = new ArrayList<>(cards);
        //Phase 9: 1 set of 5 + 1 set of 2
        if (nSetsOfX(testCards, 1, 5)) {
            if (nSetsOfX(testCards, 1, 2))
                completePhases.add("Phase 9");
        }

        testCards = new ArrayList<>(cards);
        //Phase 10: 1 set of 5 + 1 set of 3
        if (nSetsOfX(testCards, 1, 5) && nSetsOfX(testCards, 1, 3)) {
            completePhases.add("Phase 10");
        }

        if (completePhases.isEmpty()) {
            completePhases.add("None");
        }

        return completePhases;
    }

    public boolean sevenOfSameColor(List<Card> cards) {
        Map<String, Integer> colorsMap = new HashMap<>();

        for(Card card : cards){
            String cardColor = card.getCardColor().toString();
            Integer count = colorsMap.get(cardColor);
            colorsMap.put(cardColor, (count == null) ? 1 : count+1);
        }

        for(int x : colorsMap.values()){
            if (x >= 7){
                return true;
            }
        }

        return false;
    }

    public List<Card> isHasRunX(List<Card> cards, int numberInRun) {
        removeSkipCards(cards);
        List<Card> retRunCards = new ArrayList<>();
        List<Card> noDups = cards.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<Card>(comparingInt(Card::getCardOrdinalValue))), ArrayList::new));
        Collections.sort(noDups);

        for (int i = 0; i < noDups.size(); i++) {
            if (i + numberInRun <= noDups.size()) {
                List<Card> subCards = noDups.subList(i, i + numberInRun);
                List<Card> runCards = HasConsecutive(subCards, numberInRun);
                if (runCards.size() == numberInRun) {
                    retRunCards = runCards;
                    break;
                }
            }
        }
        return retRunCards;
    }

    public List<Card> HasConsecutive(List<Card> cards, int length) {
        removeSkipCards(cards);

        List<Card> runCards = new ArrayList<>();
        boolean result = true;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getValue().ordinal() - cards.get(i).getValue().ordinal() == 1) {
                runCards.add(cards.get(i));
                if (i == cards.size() - 2) {
                    runCards.add(cards.get(i + 1));
                }
            } else {
                break;
            }
        }
        return runCards;
    }

    public boolean nRunOfX(List<Card> cards, int numberOfRuns, int numberInRun) {
        int count = 0;

        removeSkipCards(cards);

        if (numberOfRuns * numberInRun > cards.size()) {
            return false;
        }

        for (int x = 0; x < numberOfRuns; x++) {
            List<Card> runCards = isHasRunX(cards, numberInRun);
            if (!runCards.isEmpty()) {
                count++;
                // System.out.println("remove Cards LoopNumber: " + x + " " + runCards);
                for (Card removeCard : runCards) {
                    cards.remove(removeCard);
                }
            }
        }

        return count == numberOfRuns;
    }

    private void removeSkipCards(List<Card> cards) {
        if (cards.stream().anyMatch(card -> Card.Value.skip == card.getValue())){
            cards.removeIf(card -> card.getValue() == Card.Value.skip);
        }
    }


    //A set means two or more cards with the same value or number on its face.
    public boolean nSetsOfX(List<Card> cards, int numberOfSets, int numberInSet) {
        removeSkipCards(cards);
        Collections.sort(cards);
        Map<Integer, Long> matchMap = new HashMap<>();
        if (numberInSet <= 1) {
            return false;
        }

        for (Card card : cards) {
            matchMap.merge(card.getCardOrdinalValue(), 1L, Long::sum);
        }

        // find all the cards that match the condition of the number in set. This will be used to remove them so
        // they can't be used to make another set
        List<Card> cardsToRemove = new ArrayList<>();
        cards.forEach((card) -> {
            matchMap.forEach((key, value) -> {
                if (value >= numberInSet) {
                    if (card.getCardOrdinalValue() == key && cardsToRemove.size() < numberInSet) {
                        cardsToRemove.add(card);
                    }
                }
            });
        });

        for (Card c : cardsToRemove) {
            cards.remove(c);
        }

        int valueTest = (int) matchMap.entrySet().stream().filter(x -> x.getValue().intValue() >= numberInSet).count();

        return valueTest >= numberOfSets;
    }


}

