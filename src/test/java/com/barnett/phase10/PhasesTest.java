package com.barnett.phase10;

import com.barnett.phase10.gameComponents.Card;
import com.barnett.phase10.gameComponents.Phases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhasesTest {
    Phases phases;

    @BeforeEach
    void setUp() {
        phases = new Phases();
    }

    @Test
    void testMatchesPhase1() {
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

    @Test
    void testMatchesPhase1_2() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);

        assertFalse(phases.nSetsOfX(forceCards, 2, 3));
    }

    @Test
    void testMatchesPhase1_3() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Blue, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.three);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);

        assertFalse(phases.nSetsOfX(forceCards, 2, 3));
    }

    @Test
    void testMatchesPhase1_4() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Blue, Card.Value.two);
        Card c = new Card(Card.Color.Blue, Card.Value.three);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Blue, Card.Value.five);
        Card f = new Card(Card.Color.Blue, Card.Value.six);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);
        forceCards.add(e);
        forceCards.add(f);

        assertFalse(phases.nSetsOfX(forceCards, 2, 3));
    }

    @Test
    void testMatchesPhase2() {
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Red, Card.Value.twelve);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.ten);
        Card e = new Card(Card.Color.Green, Card.Value.eleven);
        Card f = new Card(Card.Color.Yellow, Card.Value.nine);
        Card g = new Card(Card.Color.Red, Card.Value.eight);
        Card h = new Card(Card.Color.Blue, Card.Value.six);
        Card i = new Card(Card.Color.Green, Card.Value.seven);
        Card j = new Card(Card.Color.Green, Card.Value.five);

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
        forceCards.add(j);

        assertTrue(phases.nRunOfX(forceCards, 1, 4));
    }

    @Test
    void testAreConsecutive() {
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Red, Card.Value.twelve);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.ten);
        Card e = new Card(Card.Color.Green, Card.Value.eleven);
        Card f = new Card(Card.Color.Yellow, Card.Value.nine);
        Card g = new Card(Card.Color.Red, Card.Value.eight);
        Card h = new Card(Card.Color.Blue, Card.Value.six);
        Card i = new Card(Card.Color.Green, Card.Value.seven);
        Card j = new Card(Card.Color.Green, Card.Value.five);

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
        forceCards.add(j);

        assertTrue(phases.isHasRunX(forceCards, 4).size() == 4);
    }


    @Test
    void testNRunOfX() {
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Red, Card.Value.twelve);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.ten);
        Card e = new Card(Card.Color.Green, Card.Value.eleven);
        Card f = new Card(Card.Color.Yellow, Card.Value.nine);
        Card g = new Card(Card.Color.Red, Card.Value.eight);
        Card h = new Card(Card.Color.Blue, Card.Value.six);
        Card i = new Card(Card.Color.Green, Card.Value.seven);
        Card j = new Card(Card.Color.Green, Card.Value.five);

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
        forceCards.add(j);

        assertTrue(phases.nRunOfX(forceCards, 1,4));
    }

    @Test
    void testNRunOfX2() {
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Red, Card.Value.twelve);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.ten);
        Card e = new Card(Card.Color.Green, Card.Value.eleven);
        Card f = new Card(Card.Color.Yellow, Card.Value.nine);
        Card g = new Card(Card.Color.Red, Card.Value.eight);
        Card h = new Card(Card.Color.Blue, Card.Value.six);
        Card i = new Card(Card.Color.Green, Card.Value.seven);
        Card j = new Card(Card.Color.Green, Card.Value.five);

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
        forceCards.add(j);

        assertTrue(phases.nRunOfX(forceCards, 2,4));
    }

    @Test
    void testNRunOfX3() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.four);
        Card e = new Card(Card.Color.Green, Card.Value.five);
        Card f = new Card(Card.Color.Yellow, Card.Value.six);
        Card g = new Card(Card.Color.Red, Card.Value.seven);
        Card h = new Card(Card.Color.Blue, Card.Value.eight);
        Card i = new Card(Card.Color.Green, Card.Value.nine);
        Card j = new Card(Card.Color.Green, Card.Value.ten);

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
        forceCards.add(j);

        assertTrue(phases.nRunOfX(forceCards, 1,10));
    }

    @Test
    void testNRunOfX4() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.four);
        Card e = new Card(Card.Color.Green, Card.Value.five);
        Card f = new Card(Card.Color.Yellow, Card.Value.six);
        Card g = new Card(Card.Color.Red, Card.Value.seven);
        Card h = new Card(Card.Color.Blue, Card.Value.eight);
        Card i = new Card(Card.Color.Green, Card.Value.nine);
        Card j = new Card(Card.Color.Green, Card.Value.ten);

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
        forceCards.add(j);

        assertFalse(phases.nRunOfX(forceCards, 2,10));
    }

    @Test
    void testNRunOfX5() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Yellow, Card.Value.four);
        Card e = new Card(Card.Color.Green, Card.Value.one);
        Card f = new Card(Card.Color.Yellow, Card.Value.two);
        Card g = new Card(Card.Color.Red, Card.Value.three);
        Card h = new Card(Card.Color.Blue, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.nine);
        Card j = new Card(Card.Color.Green, Card.Value.ten);

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
        forceCards.add(j);

        assertTrue(phases.nRunOfX(forceCards, 2,4));
    }

    @Test
    void testNSetofXRemoveCards(){
        //Phase 9: 1 set of 5 + 1 set of 2
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Red, Card.Value.one);
        Card f = new Card(Card.Color.Green, Card.Value.seven);
        Card g = new Card(Card.Color.Blue, Card.Value.eight);
        Card h = new Card(Card.Color.Red, Card.Value.nine);
        Card i = new Card(Card.Color.Green, Card.Value.ten);
        Card j = new Card(Card.Color.Blue, Card.Value.eleven);

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
        forceCards.add(j);

        assertTrue(phases.nSetsOfX(forceCards, 1,5));
        assertFalse(phases.nSetsOfX(forceCards, 1,2));
    }

    @Test
    void testRunWithSpecialCards(){
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Red, Card.Value.twelve);
        Card c = new Card(Card.Color.Green, Card.Value.eleven);
        Card d = new Card(Card.Color.Blue, Card.Value.ten);


        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);

        assertFalse(phases.nRunOfX(forceCards, 1, 4));
    }

    @Test
    void testSevenOfSameColor(){
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Blue, Card.Value.twelve);
        Card c = new Card(Card.Color.Blue, Card.Value.eleven);
        Card d = new Card(Card.Color.Blue, Card.Value.ten);
        Card e = new Card(Card.Color.Blue, Card.Value.skip);
        Card f = new Card(Card.Color.Blue, Card.Value.twelve);
        Card g = new Card(Card.Color.Blue, Card.Value.eleven);


        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);
        forceCards.add(e);
        forceCards.add(f);
        forceCards.add(g);

        assertTrue(phases.sevenOfSameColor(forceCards));
    }

    @Test
    void testSevenOfSameColor2(){
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Blue, Card.Value.twelve);
        Card c = new Card(Card.Color.Blue, Card.Value.eleven);
        Card d = new Card(Card.Color.Blue, Card.Value.ten);
        Card e = new Card(Card.Color.Blue, Card.Value.skip);
        Card f = new Card(Card.Color.Blue, Card.Value.twelve);
        Card g = new Card(Card.Color.Blue, Card.Value.eleven);
        Card h = new Card(Card.Color.Blue, Card.Value.eleven);


        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);
        forceCards.add(e);
        forceCards.add(f);
        forceCards.add(g);
        forceCards.add(h);

        assertTrue(phases.sevenOfSameColor(forceCards));
    }

    @Test
    void testSevenOfSameColor3(){
        Card a = new Card(Card.Color.Blue, Card.Value.skip);
        Card b = new Card(Card.Color.Blue, Card.Value.twelve);
        Card c = new Card(Card.Color.Blue, Card.Value.eleven);
        Card d = new Card(Card.Color.Blue, Card.Value.ten);
        Card e = new Card(Card.Color.Blue, Card.Value.skip);
        Card f = new Card(Card.Color.Blue, Card.Value.twelve);
        Card g = new Card(Card.Color.Red, Card.Value.eleven);
        Card h = new Card(Card.Color.Yellow, Card.Value.eleven);
        Card i = new Card(Card.Color.Green, Card.Value.eleven);
        Card j = new Card(Card.Color.Red, Card.Value.eleven);


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
        forceCards.add(j);

        assertFalse(phases.sevenOfSameColor(forceCards));
    }

}