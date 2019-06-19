/**
 * "French playing cards are cards that use the French suits of clubs, diamonds,
 * hearts and spades. each suit contains three face cards: jack, queen and king."
 *
 * reference: https://en.wikipedia.org/wiki/French_playing_cards
 */
public class Card {
    private final Rank rank;    // rank of the card
    private final Suit suit;    // suit of the card

    /**
     *
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Construct a card object by passing indexes of enumerators
     * @param rankIndex rank index in Rank enumerator class
     * @param suitIndex suit index in Suit enumerator class
     */
    public Card(int rankIndex, int suitIndex) {
        if (rankIndex < 0 || rankIndex >= Rank.values().length) {
            System.err.println("ERROR in Card class constructor: rankIndex " +
                    rankIndex + " is invalid.");
        }

        if (suitIndex < 0 || suitIndex >= Suit.values().length) {
            System.err.println("ERROR in Card class constructor: suitIndex " +
                    suitIndex + " is invalid.");
        }

        this.rank = Rank.values()[rankIndex];
        this.suit = Suit.values()[suitIndex];
    }

    /**
     * rank getter
     * @return rank of this card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * suit getter
     * @return suit of this card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Card is represented as string following this format: <{RANK} OF {SUIT}>
     * @return String representation of this card
     */
    @Override
    public String toString() {
        return rank.toString() + " OF " + suit.toString();
    }
}
