import java.util.ArrayList;
import java.util.Collections;

/**
 * "The standard 52-card deck of French playing cards includes 13
 * ranks in each of four suits: clubs, diamonds, hearts and spades."
 *
 * "French suited cards are the most common playing cards used internationally"
 *
 * reference: https://en.wikipedia.org/wiki/Standard_52-card_deck
 */
public class StandardDeck {
    // list of cards in this deck
    // a card with index 0 is "at the bottom" of this deck
    // a card with a last index is "at the top" of this deck
    private ArrayList<Card> deck = new ArrayList<>();

    /**
     * StandardDeck object constructor
     * adds 52 and shuffles 52 cards to this deck on construction
     */
    public StandardDeck() {
        for(int i = 0; i < Rank.values().length; ++i) {
            for(int j = 0; j < Suit.values().length; ++j) {
                this.deck.add(new Card(Rank.values()[i], Suit.values()[j]));
            }
        }
        Collections.shuffle(deck); // shuffle this deck
    }

    /**
     * Shuffles the order of cards in this deck
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Places a card at the bottom of this deck
     * @param card a card to be places at the bottom of this deck
     */
    public void place(Card card) {
        deck.add(0, card);
    }

    /**
     * Draws a card from the top of this deck
     * Drawn card is removed from deck array afterwards
     * @return a card that is drawn from the top of this deck
     */
    public Card draw() {
        Card card = deck.get(deck.size()-1);  // get a reference of a card at the top of this deck
        deck.remove(card);  // remove the card from this deck
        return card;  // return a reference of the card
    }
}
