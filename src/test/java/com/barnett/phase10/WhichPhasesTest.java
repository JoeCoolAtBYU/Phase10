package com.barnett.phase10;

import com.barnett.phase10.gameComponents.Card;
import com.barnett.phase10.gameComponents.Deck;
import com.barnett.phase10.gameComponents.Phases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhichPhasesTest {
    Card[] cardArray;
    List<Card> cards;
    Deck deck;
    Phases phases;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        deck.reset();
        deck.shuffle();

        cards = deck.drawCard(10);
        phases = new Phases();
    }

    @Test
    void testPhase1() {
        //Phase 1: 2 sets of 3
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.two);
        Card e = new Card(Card.Color.Red, Card.Value.two);
        Card f = new Card(Card.Color.Green, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.two);
        Card h = new Card(Card.Color.Red, Card.Value.two);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        assertEquals("Phase 1", phases.whichPhases(forceCards).get(0));
    }

    @Test
    void testPhase2() {
        //Phase 2: 1 set of 3 + 1 run of 4
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.two);
        Card e = new Card(Card.Color.Red, Card.Value.three);
        Card f = new Card(Card.Color.Green, Card.Value.four);
        Card g = new Card(Card.Color.Blue, Card.Value.one);
        Card h = new Card(Card.Color.Red, Card.Value.two);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertEquals("Phase 1", results.get(0));
        assertEquals("Phase 2", results. get(1));
    }

    @Test
    void testPhase3() {
        //Phase 3: 1 set of 4 + 1 run of 4
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Red, Card.Value.one);
        Card f = new Card(Card.Color.Green, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.three);
        Card h = new Card(Card.Color.Red, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 3"));
    }

    @Test
    void testPhase4() {
        //Phase 4: 1 run of 7
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Red, Card.Value.five);
        Card f = new Card(Card.Color.Green, Card.Value.six);
        Card g = new Card(Card.Color.Blue, Card.Value.seven);
        Card h = new Card(Card.Color.Red, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 4"));
    }

    @Test
    void testPhase5() {
        //Phase 5: 1 run of 8
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Red, Card.Value.five);
        Card f = new Card(Card.Color.Green, Card.Value.six);
        Card g = new Card(Card.Color.Blue, Card.Value.seven);
        Card h = new Card(Card.Color.Red, Card.Value.eight);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 5"));
    }

    @Test
    void testPhase6() {
        //Phase 6: 1 run of 9
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Red, Card.Value.five);
        Card f = new Card(Card.Color.Green, Card.Value.six);
        Card g = new Card(Card.Color.Blue, Card.Value.seven);
        Card h = new Card(Card.Color.Red, Card.Value.eight);
        Card i = new Card(Card.Color.Green, Card.Value.nine);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 6"));
    }

    @Test
    void testPhase7() {
        //Phase 7: 2 sets of 4
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Red, Card.Value.two);
        Card f = new Card(Card.Color.Green, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.two);
        Card h = new Card(Card.Color.Red, Card.Value.two);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 7"));
    }

    @Test
    void testPhase8() {
        //Phase 8: 7 cards of one color (Ignore this phase)
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Blue, Card.Value.one);
        Card c = new Card(Card.Color.Blue, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Blue, Card.Value.one);
        Card f = new Card(Card.Color.Blue, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.three);
        Card h = new Card(Card.Color.Red, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Yellow, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 8"));
    }

    @Test
    void testPhase9() {
        //Phase 9: 1 set of 5 + 1 set of 2
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Red, Card.Value.one);
        Card f = new Card(Card.Color.Green, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.three);
        Card h = new Card(Card.Color.Red, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 9"));
    }
    @Test
    void testPhase9Break() {
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

        List<String> results = phases.whichPhases(forceCards);
        assertFalse(results.contains("Phase 9"), "should not contain phase 9 not enough correct cards");
    }

    @Test
    void testPhase10() {
        //Phase 10: 1 set of 5 + 1 set of 3
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.one);
        Card e = new Card(Card.Color.Red, Card.Value.one);
        Card f = new Card(Card.Color.Green, Card.Value.two);
        Card g = new Card(Card.Color.Blue, Card.Value.three);
        Card h = new Card(Card.Color.Red, Card.Value.four);
        Card i = new Card(Card.Color.Green, Card.Value.four);
        Card j = new Card(Card.Color.Blue, Card.Value.four);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 10"));
    }

//    For example, if the hand contains the cards 1, 2, 3, 4, 5, 6, 7, 8, 8, and 8, the function should indicate that phases 2, 4, and 5 are met.
//• Phase 2 is met because there is a set of three 8's and there is at least one run of four in the remaining cards: 1-4, 2-5, 3-6, or 4-7.
//• Phase 4 is met because there is at least one run of seven: 1-7, or 2-8.
//• Phase 5 is met because there is a run of 8: 1-8.

    @Test
    void testPhaseExampleFromCodeingChallenge() {
        //Phase 10: 1 set of 5 + 1 set of 3
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.two);
        Card c = new Card(Card.Color.Green, Card.Value.three);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Red, Card.Value.five);
        Card f = new Card(Card.Color.Green, Card.Value.six);
        Card g = new Card(Card.Color.Blue, Card.Value.seven);
        Card h = new Card(Card.Color.Red, Card.Value.eight);
        Card i = new Card(Card.Color.Green, Card.Value.eight);
        Card j = new Card(Card.Color.Blue, Card.Value.eight);

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

        List<String> results = phases.whichPhases(forceCards);
        assertTrue(results.contains("Phase 2"));
        assertTrue(results.contains("Phase 4"));
        assertTrue(results.contains("Phase 5"));
    }

    @Test
    void testNumberOfPhases() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Red, Card.Value.one);
        Card c = new Card(Card.Color.Green, Card.Value.one);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);

        assertEquals("None", phases.whichPhases(forceCards).get(0));
    }

    @Test
    void testNumberOfPhases2() {
        Card a = new Card(Card.Color.Blue, Card.Value.one);
        Card b = new Card(Card.Color.Blue, Card.Value.one);
        Card c = new Card(Card.Color.Blue, Card.Value.one);
        Card d = new Card(Card.Color.Blue, Card.Value.four);
        Card e = new Card(Card.Color.Blue, Card.Value.five);
        Card f = new Card(Card.Color.Blue, Card.Value.four);

        List<Card> forceCards = new ArrayList<>();
        forceCards.add(a);
        forceCards.add(b);
        forceCards.add(c);
        forceCards.add(d);
        forceCards.add(e);
        forceCards.add(f);

        assertEquals("None", phases.whichPhases(forceCards).get(0));
    }


}