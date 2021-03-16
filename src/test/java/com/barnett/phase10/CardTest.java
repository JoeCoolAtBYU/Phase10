package com.barnett.phase10;

import com.barnett.phase10.gameComponents.Card;
import com.barnett.phase10.gameComponents.Phases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Phases phases;

    @BeforeEach
    void setUp() {
        phases = new Phases();
    }

    @Test
    void compareTo() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.one);
        Card e = new Card(Card.Color.Green, Card.Value.two);
        Card f = new Card(Card.Color.Yellow, Card.Value.three);
        Card g = new Card(Card.Color.Red, Card.Value.one);
        Card h = new Card(Card.Color.Blue, Card.Value.two);
        Card i = new Card(Card.Color.Green, Card.Value.three);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);
        forceCards.add(e);
        forceCards.add(f);
        forceCards.add(g);
        forceCards.add(h);
        forceCards.add(i);

        assertTrue(phases.nSetsOfX(forceCards, 2, 3));
    }
}