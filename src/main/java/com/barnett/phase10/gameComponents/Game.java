package com.barnett.phase10.gameComponents;

import com.barnett.phase10.Exceptions.InvalidHandPlayException;
import com.barnett.phase10.Exceptions.InvalidPlayerTurnException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private int currentPlayer;
    private String[] playerIds;

    private Deck deck;
    private ArrayList<ArrayList<Card>> playerHands;
    private ArrayList<Card> discardPile;

    public Game(String[] players) {
        deck = new Deck();
        deck.shuffle();
        discardPile = new ArrayList<Card>();

        playerIds = players;
        currentPlayer = 0;

        playerHands = new ArrayList<ArrayList<Card>>();

        for (int i = 0; i < playerIds.length; i++) {
            ArrayList<Card> hand = new ArrayList<Card>(deck.drawCard(10));
            playerHands.add(hand);
        }
    }

    public void start(Game game) {
        Card card = deck.drawCard();

        // if the first card to be played is a skip the first player to the dealers left is skipped
        if (card.getCardValue() == Card.Value.skip) {
            JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            currentPlayer = (currentPlayer + 1) % playerIds.length;
        }

        discardPile.add(card);
    }

    public Card getTopCard() {
        return deck.drawCard();
    }

    public ImageIcon getTopCardImage() {
        Card topCard = getTopCard();
        return new ImageIcon(topCard.getCardColor() + "-" + topCard.getCardValue() + ".png");
    }

    public boolean isRoundOver() {
        for (String player : this.playerIds) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasEmptyHand(String id) {
        return getPlayersHand(id).isEmpty();
    }

    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }

    public String getPreviousPlayer(int x) {
        int index = this.currentPlayer - 1;
        if (index == -1) {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }

    public String[] getPlayers() {
        return playerIds;
    }

    public ArrayList<Card> getPlayersHand(String id) {
        int index = Arrays.asList(playerIds).indexOf(id);
        return playerHands.get(index);
    }

    public int getPlayersHandSize(String id) {
        return getPlayersHand(id).size();
    }

    public Card getPlayerCard(String id, int choice) {
        ArrayList<Card> hand = getPlayersHand(id);
        return hand.get(choice);
    }

    public boolean validPutDown(ArrayList<Card> cards) {
        //TODO implement this check to see if the card or cards played is valid for pase and what is on the table already.
        return false;
    }

    public void checkPlayerTurn(String id) throws InvalidPlayerTurnException {
        if (!this.playerIds[this.currentPlayer].equals(id)) {
            throw new InvalidPlayerTurnException("It is not " + id + "'s turn", id);
        }
    }

    public void submitDraw(String id) throws InvalidPlayerTurnException {
        checkPlayerTurn(id);

        if (deck.isEmpty()) {
            deck.replaceDeckWith(discardPile);
            deck.shuffle();
        }

        getPlayersHand(id).add(deck.drawCard());
    }

    public void submitPlayerPhaseAttempt(String playerId, Card[] cards)
            throws InvalidPlayerTurnException, InvalidHandPlayException {
        //todo check to see if the cards match a phase
        //todo check to see if the player is on that phase
    }

}
