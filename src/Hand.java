import java.util.ArrayList;
import java.util.Collections;

/**
 * Players hand
 * hand consist of 5 cards
 */
public class Hand {
    // reference to a deck that this hand is drawing cards from
    private StandardDeck cardDeck;
    // array of cards in this hand
    private ArrayList<Card> hand = new ArrayList<>();
    // array of booleans that shows which cards in this hand
    // are being held on next draw
    private boolean[] heldCards = new boolean[5];

    /**
     * Hand class constructor
     * draws 5 cards from referenced deck to this hand on object construction
     * @param cardDeck references a deck that this hand is drawing its cards from
     */
    public Hand(StandardDeck cardDeck) {
        // assign a reference to the deck that the hand is dealt cards from
        this.cardDeck = cardDeck;
        // draw 5 cards from deck
        for(int i = 0; i < 5; ++i) {
            this.hand.add(cardDeck.draw());
        }
    }

    /**
     * Hand class constructor
     * Cards are passed manually here
     * Used mainly for testing
     * @param cardDeck references a deck that this hand is drawing its cards from
     * @param card1 first card
     * @param card2 second card
     * @param card3 third card
     * @param card4 fourth card
     * @param card5 fifth card
     */
    public Hand(StandardDeck cardDeck, Card card1, Card card2,
                Card card3, Card card4, Card card5) {
        // assign a reference to the deck that the hand is dealt cards from
        this.cardDeck = cardDeck;

        // add cards manually
        this.hand.add(card1);
        this.hand.add(card2);
        this.hand.add(card3);
        this.hand.add(card4);
        this.hand.add(card5);
    }

    /**
     * Draws a card from deck and adds it to this hand
     * @param index index of a card in this hand to redraw
     */
    public void redrawCard(int index) {
        if (index < 0 || index > 5) {
            System.err.println("ERROR in method redrawCard() of class Hand. " +
                    "Invalid index " + index);
                    return;
        }

        // place the card from this hand to the bottom of the deck
        cardDeck.place(hand.get(index));
        hand.remove(index);
        // draw a new card from the deck and add it to the index position of this hand
        hand.add(index, cardDeck.draw());
        System.out.println("Card at index " + (index+1) + " redrawn");
    }

    /**
     * Redraws cards in hand that are not marked as held
     * cards are drawn from the card deck referenced on object creation
     */
    public void drawCards() {
        for(int i = 0; i < heldCards.length; ++i) {
            if (!heldCards[i]) {
                redrawCard(i);
            } else {
                heldCards[i] = false;
            }
        }
    }

    /**
     * Toggles the specified card as held / hold cancelled
     * @param index index of card in hand
     */
    public void toggleCardHold(int index) {
        if (this.heldCards[index]) {
            cancelCardHold(index);
        } else {
            markCardAsHeld(index);
        }
    }

    /**
     * Marks a card a player want to hold
     * @param index index of a card to hold
     */
    public void markCardAsHeld(int index) {
        if (this.heldCards[index]) {
            System.out.println("The card with index " + (index+1) + " is already held");
            return;
        }

        System.out.println("Card with index " + (index+1) + " marked as held");
        this.heldCards[index] = true;
    }

    /**
     * Removes a mark from card so that is not held anymore
     * @param index index of a held card
     */
    public void cancelCardHold(int index) {
        if (!this.heldCards[index]) {
            System.out.println("The card with index " + (index+1) + " is currently not held");
            return;
        }

        System.out.println("Cancelled holding of card with index " + (index+1));
        this.heldCards[index] = false;
    }

    /**
     * Get prize multiplier of this hand
     * Possible hands | prizes by index:
     * [9]     Royal Flush | 800
     * [8]  Straight Flush | 50
     * [7]  Four of a kind | 25
     * [6]      Full House | 9
     * [5]           Flush | 6
     * [4]        Straight | 4
     * [3] Three of a kind | 3
     * [2]        Two Pair | 2
     * [1] Jacks or Better | 1
     * [0]       All Other | 0
     * @return prize multiplier for this hand
     */
    public int getHandPrize() {
        switch (getHand()) {
            case ROAYL_FLUSH:
                return 800;
            case STRAIGHT_FLUSH:
                return 50;
            case FOUR_OF_A_KIND:
                return 25;
            case FULL_HOUSE:
                return 9;
            case FLUSH:
                return 6;
            case STRAIGHT:
                return 4;
            case THREE_OF_A_KIND:
                return 3;
            case TWO_PAIR:
                return 2;
            case JACKS_OR_BETTER:
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Analyzes the combination of cards in this hand and
     * returns the type of this hand (flush, pair, etc...)
     * @return type of current player hand
     */
    private HandRanking getHand() {
        System.out.print("Players hand is: ");
        if(isRoyalFlush()) {
            System.out.println(HandRanking.ROAYL_FLUSH);
            return HandRanking.ROAYL_FLUSH;
        }
        else if (isStraightFlush()) {
            System.out.println(HandRanking.STRAIGHT_FLUSH);
            return HandRanking.STRAIGHT_FLUSH;
        }
        else if (isFourOfAKind()) {
            System.out.println(HandRanking.FOUR_OF_A_KIND);
            return HandRanking.FOUR_OF_A_KIND;
        }
        else if (isFullHouse()) {
            System.out.println(HandRanking.FULL_HOUSE);
            return HandRanking.FULL_HOUSE;
        }
        else if (isFlush()) {
            System.out.println(HandRanking.FLUSH);
            return HandRanking.FLUSH;
        }
        else if (isStraight()) {
            System.out.println(HandRanking.STRAIGHT);
            return HandRanking.STRAIGHT;
        }
        else if (isThreeOfAKind()) {
            System.out.println(HandRanking.THREE_OF_A_KIND);
            return HandRanking.THREE_OF_A_KIND;
        }
        else if (isTwoPair()) {
            System.out.println(HandRanking.TWO_PAIR);
            return HandRanking.TWO_PAIR;
        }
        else if (isJacksOrBetter()) {
            System.out.println(HandRanking.JACKS_OR_BETTER);
            return HandRanking.JACKS_OR_BETTER;
        }
        else {
            System.out.println(HandRanking.OTHER);
            return HandRanking.OTHER;
        }
    }

    /**
     * Hand contains a pair of Jacks or higher ranked cards
     * @return true if this hand ranking is Jacks or Better; false otherwise
     */
    public boolean isJacksOrBetter() {
        Card card1;
        Card card2;
        for(int i = 0; i < hand.size() - 1; ++i) {
            card1 = hand.get(i);
            // a card needs to have a rank of jack at least to consider it for possible pair check
            if (Utils.getCardRankIndex(card1) < Rank.valueOf("JACK").ordinal()) {
                continue;
            }

            for(int j = i + 1; j < hand.size(); ++j) {
                card2 = hand.get(j);
                // if another card is found here with equal rank - we have
                // Jacks or Better hand
                if (isEqualRank(card1, card2)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Hand contains two pairs of same rank cards
     * @return true if this hand ranking is Two Pair; false otherwise
     */
    public boolean isTwoPair() {
        Card card1;
        Card card2;
        int pairCount = 0;
        ArrayList<Card> handCopy = new ArrayList<>(hand);
        for(int i = 0; i < handCopy.size() - 1; ++i) {
            if ((pairCount == 0) && (i > 1)) {
                // there is no possible combinations for a two pairs
                return false;
            }

            for (int j = i + 1; j < handCopy.size(); ++j) {
                card1 = handCopy.get(i);
                card2 = handCopy.get(j);
                if (isEqualRank(card1, card2)) {
                    if (pairCount == 0) {
                        handCopy.remove(card1);
                        handCopy.remove(card2);
                        // we removed elements from list so we need to
                        // start iterating from the same i position again
                        --i;
                        j = 5; // ends loop within a loop -> increments i
                        ++pairCount;
                    } else if (pairCount > 0) {
                        return true; // two pairs found
                    }
                }
            }
        }

        return false;
    }

    /**
     * Hand contains three same rank cards
     * @return true if this hand ranking is Three of a Kind; false otherwise
     */
    public boolean isThreeOfAKind() {
        for(int i = 0; i < hand.size() - 2; ++i) {
            for(int j = i + 1; j < hand.size() - 1; ++j) {
                for(int k = j + 1; k < hand.size(); ++k) {
                    if (isEqualRank(hand.get(i), hand.get(j)) &&
                            isEqualRank(hand.get(j), hand.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Hand contains five cards of sequential rank, not all of the same suit
     * @return true if this hand ranking is Straight; false otherwise
     */
    public boolean isStraight() {
        ArrayList<Card> handCopy = sortHandByRank(); // sort cards for easier implementation
        int cardIndex1;
        int cardIndex2;
        for(int i = 0; i < handCopy.size() - 1; ++i) {
            cardIndex1 = Utils.getCardRankIndex(handCopy.get(i));
            cardIndex2 = Utils.getCardRankIndex(handCopy.get(i + 1));
            if (cardIndex1 + 1 != cardIndex2) {
                return false;
            }
        }

        return true;
    }

    /**
     * Hand contains five cards all of the same suit, not all of sequential rank
     * @return true if this hand ranking is Flush; false otherwise
     */
    public boolean isFlush() {
        return (isEqualSuit(hand.get(0), hand.get(1)) && isEqualSuit(hand.get(1), hand.get(2)) &&
                isEqualSuit(hand.get(2), hand.get(3)) && isEqualSuit(hand.get(3), hand.get(4)));
    }

    /**
     * Hand contains three cards of one rank and two cards of another rank
     * @return true if this hand ranking is Full House; false otherwise
     */
    public boolean isFullHouse() {
        Card card1;
        Card card2;
        Card card3;
        ArrayList<Card> handCopy = new ArrayList<>(hand);
        boolean breakLoop = false;
        boolean isThreeOfAKind = false;
        for(int i = 0; i < hand.size() - 2; ++i) {
            for(int j = i + 1; j < hand.size() - 1; ++j) {
                for(int k = j + 1; k < hand.size(); ++k) {
                    card1 = hand.get(i);
                    card2 = hand.get(j);
                    card3 = hand.get(k);
                    if (isEqualRank(card1, card2) && isEqualRank(card2, card3)) {
                        handCopy.remove(card1);
                        handCopy.remove(card2);
                        handCopy.remove(card3);
                        isThreeOfAKind = true;
                        breakLoop = true;
                        break;
                    }
                }
                if(breakLoop)
                    break;
            }
            if(breakLoop)
                break;
        }

        if (!isThreeOfAKind) {
            return false;
        }


        System.out.println();
        return isEqualRank(handCopy.get(0), handCopy.get(1));
    }

    /**
     * Hand contains four cards of same rank
     * @return true if this hand ranking is Four of a Kind; false otherwise
     */
    public boolean isFourOfAKind() {
        for(int i = 0; i < hand.size() - 3; ++i) {
            for(int j = i + 1; j < hand.size() - 2; ++j) {
                for(int k = j + 1; k < hand.size() - 1; ++k) {
                    for(int l = k + 1; l < hand.size(); ++l) {
                        // works because of transitive relation of equality
                        if (isEqualRank(hand.get(i), hand.get(j)) &&
                        isEqualRank(hand.get(j), hand.get(k)) &&
                        isEqualRank(hand.get(k), hand.get(l))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Hand contains five cards of sequential rank, all of the same suit
     * NOTE: high card cannot be Ace
     * @return true if this hand ranking is Straight Flush; false otherwise
     */
    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    /**
     * Hand contains Hand contains five cards of sequential rank, all of the same suit
     * NOTE: high card must be Ace
     * @return true if this hand ranking is Royal Flush; false otherwise
     */
    public boolean isRoyalFlush() {
        return isStraightFlush() && getHighCardRank().equals(Rank.ACE);
    }

    /**
     * Checks if one card has a higher rank than the one
     * @param card1 checking if this cards ranks is higher than the other ones'
     * @param card2 compared card
     * @return true if card1 rank is higher then card2 rank; false otherwise
     */
    private boolean isHigherRank(Card card1, Card card2) {
        return Utils.getCardRankIndex(card1) > Utils.getCardRankIndex(card2);
    }

    /**
     * Get the card with the highest rank in this hand
     * @return card reference that has the highest rank in this hand
     */
    private Card getHighCard() {
        int highCardIndex = 0;
        for(int i = 1; i < hand.size(); ++i) {
            if (isHigherRank(hand.get(i), hand.get(highCardIndex))) {
                highCardIndex = i;
            }
        }

        return hand.get(highCardIndex);
    }

    /**
     * Get the highest rank of this hand
     * @return enumerator of highest rank in this hand
     */
    private Rank getHighCardRank() {
        return getHighCard().getRank();
    }

    /**
     * Checks if ranks of two cards are equal
     * @param card1 one of the compared cards
     * @param card2 one of the compared cards
     * @return true if ranks of two cards are equal; false otherwise
     */
    private boolean isEqualRank(Card card1, Card card2) {
        return card1.getRank().equals(card2.getRank());
    }

    /**
     * Checks if suits of two cards are equal
     * @param card1 one of the compared cards
     * @param card2 one of the compared cards
     * @return true if suits of two cards are equal; false otherwise
     */
    private boolean isEqualSuit(Card card1, Card card2) {
        return card1.getSuit().equals(card2.getSuit());
    }

    /**
     * Sorts this hand by rank and returns its' copy object
     * We use bubble sort here for easier implementation
     * @return a copy ArrayList of sorted cards in this hand
     */
    private ArrayList<Card> sortHandByRank() {
        ArrayList<Card> handCopy = new ArrayList<>(hand);
        for(int i = 0; i < handCopy.size() - 1; ++i) {
            for(int j = i + 1; j < handCopy.size(); ++j) {
                if (isHigherRank(handCopy.get(i), handCopy.get(j))) {
                    Collections.swap(handCopy, i, j);
                }
            }
        }
        return handCopy;
    }

    /**
     * When parsing this object to String - String representations
     * of hand cards are returned
     * @return String representation of this hand
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cards in hand:\n");
        for(int i = 0; i < hand.size(); ++i) {
            sb.append("[").append(i+1).append("] ").append(hand.get(i).toString());
            if (heldCards[i]) {
                sb.append(" <- HELD");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
