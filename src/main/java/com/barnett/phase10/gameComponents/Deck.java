package com.barnett.phase10.gameComponents;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//    ninety-six numbered cards: two of each value from one through twelve, in each of four colors. Therefore, there are 24 cards of each color and eight of each value.
//            eight Wild cards;
//            four Skip cards;

@Data
public class Deck {
    private Card[] cards;
    private int cardsInDeck;

    // todo implement this when wilds are implemented :
    //  public Deck() {
    //    cards = new Card[108];
    //}

    public Deck() {
        cards = new Card[100];
    }

    public void reset() {
        Card.Color[] colors = Card.Color.values();
        cardsInDeck = 0;

        for (Card.Color color : colors) {
            for (int x = 0; x < 12; x++) {
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(x));
                cards[cardsInDeck++] = new Card(color, Card.Value.getValue(x));

            }
            //cards[cardsInDeck++] = new Card(color, Card.Value.wild);
            //cards[cardsInDeck++] = new Card(color, Card.Value.wild);
            cards[cardsInDeck++] = new Card(color, Card.Value.skip);
        }

    }


    public void replaceDeckWith(ArrayList<Card> cards) {
        this.cards = cards.toArray(new Card[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    public boolean isEmpty() {
        return cardsInDeck == 0;
    }

    public void shuffle() {
        int x = cards.length;
        Random rand = new Random();

        for (int s = 0; s < cards.length; s++) {
            //get random index of the array past the current index
            // the argument is the exclusive bound
            // swap the random element with the present element

            int randValue = s + rand.nextInt(x - s);
            Card randomCard = cards[randValue];
            cards[randValue] = cards[s];
            cards[s] = randomCard;
        }
    }

    public Card drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot draw a card from empty deck");
        }

        return cards[--cardsInDeck];
    }


    public List<Card> drawCard(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("must draw positive card number but tried to draw negative cards.");
        }
        if (number > cardsInDeck) {
            throw new IllegalArgumentException("Cannot draw " + number + " cards since there is only " + cardsInDeck + " cards.");
        }

        Card[] returnCards = new Card[number];

        for (int i = 0; i < number; i++) {
            returnCards[i] = cards[--cardsInDeck];
        }
        List<Card> cards = Arrays.asList(returnCards); // this return an unmodifiable list so I need to create a modifiable one.
        return new ArrayList<>(cards);
    }
}
