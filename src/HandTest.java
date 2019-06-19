import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {
    @Test
    public void getHandPrize_Return800() {
        // Arrange
        int expected = 800;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card4 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card5 = new Card(Rank.JACK, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getHandPrize_ReturnNot800() {
        // Arrange
        int expected = 800;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);
    }

    @Test
    public void getHandPrize_Return50() {
        // Arrange
        int expected = 50;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.THREE, Suit.SPADES);
        Card card2 = new Card(Rank.FOUR, Suit.SPADES);
        Card card3 = new Card(Rank.SEVEN, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.SIX, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot50() {
        // Arrange
        int expected = 50;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card4 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card5 = new Card(Rank.JACK, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return25() {
        // Arrange
        int expected = 25;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot25() {
        // Arrange
        int expected = 25;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.JACK, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return9() {
        // Arrange
        int expected = 9;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.JACK, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot9() {
        // Arrange
        int expected = 9;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return6() {
        // Arrange
        int expected = 6;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card3 = new Card(Rank.KING, Suit.HEARTS);
        Card card4 = new Card(Rank.EIGHT, Suit.HEARTS);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot6() {
        // Arrange
        int expected = 6;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card3 = new Card(Rank.KING, Suit.HEARTS);
        Card card4 = new Card(Rank.TEN, Suit.HEARTS);
        Card card5 = new Card(Rank.ACE, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return4() {
        // Arrange
        int expected = 4;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card3 = new Card(Rank.KING, Suit.HEARTS);
        Card card4 = new Card(Rank.TEN, Suit.SPADES);
        Card card5 = new Card(Rank.ACE, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot4() {
        // Arrange
        int expected = 4;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card3 = new Card(Rank.KING, Suit.HEARTS);
        Card card4 = new Card(Rank.TEN, Suit.HEARTS);
        Card card5 = new Card(Rank.ACE, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return3() {
        // Arrange
        int expected = 3;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot3() {
        // Arrange
        int expected = 3;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return2() {
        // Arrange
        int expected = 2;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot2() {
        // Arrange
        int expected = 2;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.SPADES);
        Card card2 = new Card(Rank.JACK, Suit.SPADES);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return1() {
        // Arrange
        int expected = 1;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot1() {
        // Arrange
        int expected = 1;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.TEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void getHandPrize_Return0() {
        // Arrange
        int expected = 0;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.TEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertEquals(expected, result);

    }

    @Test
    public void getHandPrize_ReturnNot0() {
        // Arrange
        int expected = 0;
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        int result = hand.getHandPrize();

        // Assert
        Assert.assertNotEquals(expected, result);

    }

    @Test
    public void isJacksOrBetter_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isJacksOrBetter();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isJacksOrBetter_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.KING, Suit.HEARTS);
        Card card2 = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card card3 = new Card(Rank.THREE, Suit.SPADES);
        Card card4 = new Card(Rank.JACK, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isJacksOrBetter();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isJacksOrBetter_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TEN, Suit.SPADES);
        Card card4 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card5 = new Card(Rank.TEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isJacksOrBetter();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isJacksOrBetter_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isJacksOrBetter();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isTwoPair_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isTwoPair();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isTwoPair_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isTwoPair();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isTwoPair_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isTwoPair();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isTwoPair_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.TEN, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isTwoPair();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isThreeOfAKind_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.TEN, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isThreeOfAKind();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isThreeOfAKind_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isThreeOfAKind();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isThreeOfAKind_ReturnsTrue3() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isThreeOfAKind();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isThreeOfAKind_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card card4 = new Card(Rank.JACK, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isThreeOfAKind();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isThreeOfAKind_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isThreeOfAKind();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isStraight_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.ACE, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraight();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isStraight_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card card3 = new Card(Rank.FOUR, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.THREE, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraight();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isStraight_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card card3 = new Card(Rank.KING, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.THREE, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraight();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isStraight_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.QUEEN, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraight();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFlush_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card3 = new Card(Rank.JACK, Suit.HEARTS);
        Card card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFlush_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card4 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFlush_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFlush_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFlush_ReturnsFalse3() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.HEARTS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFullHouse_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFullHouse();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFullHouse_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.THREE, Suit.CLUBS);
        Card card2 = new Card(Rank.TWO, Suit.DIAMONDS);
        Card card3 = new Card(Rank.TWO, Suit.SPADES);
        Card card4 = new Card(Rank.THREE, Suit.HEARTS);
        Card card5 = new Card(Rank.THREE, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFullHouse();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFullHouse_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.CLUBS);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFullHouse();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFullHouse_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFullHouse();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFourOfAKind_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.FIVE, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFourOfAKind();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFourOfAKind_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.FIVE, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFourOfAKind();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isFourOfAKind_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.JACK, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFourOfAKind();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isFourOfAKind_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.JACK, Suit.HEARTS);
        Card card2 = new Card(Rank.KING, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isFourOfAKind();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isStraightFlush_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.NINE, Suit.HEARTS);
        Card card2 = new Card(Rank.EIGHT, Suit.HEARTS);
        Card card3 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card4 = new Card(Rank.FIVE, Suit.HEARTS);
        Card card5 = new Card(Rank.SIX, Suit.HEARTS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraightFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isStraightFlush_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.NINE, Suit.SPADES);
        Card card2 = new Card(Rank.TEN, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraightFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isStraightFlush_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.NINE, Suit.SPADES);
        Card card2 = new Card(Rank.TEN, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.KING, Suit.HEARTS);
        Card card5 = new Card(Rank.JACK, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraightFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isStraightFlush_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.NINE, Suit.SPADES);
        Card card2 = new Card(Rank.TEN, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card4 = new Card(Rank.TWO, Suit.SPADES);
        Card card5 = new Card(Rank.JACK, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isStraightFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isRoyalFlush_ReturnsTrue1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card4 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isRoyalFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isRoyalFlush_ReturnsTrue2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.SPADES);
        Card card3 = new Card(Rank.JACK, Suit.SPADES);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADES);
        Card card5 = new Card(Rank.KING, Suit.SPADES);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isRoyalFlush();

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isRoyalFlush_ReturnsFalse1() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card2 = new Card(Rank.ACE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card4 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isRoyalFlush();

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isRoyalFlush_ReturnsFalse2() {
        // Arrange
        StandardDeck deck = new StandardDeck();
        Card card1 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card2 = new Card(Rank.NINE, Suit.DIAMONDS);
        Card card3 = new Card(Rank.JACK, Suit.DIAMONDS);
        Card card4 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.KING, Suit.DIAMONDS);
        Hand hand = new Hand(deck, card1, card2, card3, card4, card5);

        // Act
        boolean result = hand.isRoyalFlush();

        // Assert
        Assert.assertFalse(result);
    }
}