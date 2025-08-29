package coe318.lab5;

import java.util.ArrayList;
import java.util.Random;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    
    // Instance variables
    private final ArrayList<Card> cards;

    public CardPile() {
        // Initialize the instance variable.
        this.cards = new ArrayList<>();
    }

    /**
     * Add a card to the pile.
     * @param card the card to be added
     */
    public void add(Card card) {
        cards.add(card); // Adds the card to the pile
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return the randomly removed card
     */
    public Card removeRandom() {
        if (cards.isEmpty()) {
            return null; // No cards to remove
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(cards.size()); // Get a random index
        return cards.remove(randomIndex); // Remove and return the card
    }

    /**
     * The string representation is a space-separated list of each card.
     * @return the string representation of the pile
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Card card : cards) {
            result.append(card.toString()).append(" ");
        }
        return result.toString().trim(); // Remove the trailing space
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));   // 2 of Diamonds
        p.add(new Card(3, 2, true));   // 3 of Hearts
        p.add(new Card(4, 3, false));  // 4 of Spades (facedown)
        p.add(new Card(14, 1, true));  // Ace of Diamonds
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());

        System.out.println();

        // Create a deck with 52 cards
        CardPile deck = new CardPile();
        for (int i = 2; i < 15; i++) {  // 2 to Ace
            for (int j = 0; j < 4; j++) {  // Clubs, Diamonds, Hearts, Spades
                deck.add(new Card(i, j, true));
            }
        }

        // Remove and print all 52 cards from the deck randomly
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());
        }
    }
}
