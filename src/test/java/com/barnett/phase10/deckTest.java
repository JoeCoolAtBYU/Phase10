package com.barnett.phase10;

import com.barnett.phase10.gameComponents.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

class deckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testReset() {
        deck.reset();
        // todo this will work when wilds are implemented: assertEquals("should have 108 cards", 108, deck.getCardsInDeck());
        assertEquals("should have 100 cards", 100, deck.getCardsInDeck());
    }
}