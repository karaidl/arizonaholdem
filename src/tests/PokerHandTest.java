package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the PokerHand class and the enums
 * 
 * Rick includes all 52 cards to save you time (see end of file, after the @Test
 * methods)
 * 
 * There are also some additional test cases here. But this is in no way
 * complete. Many more are needed
 */

/*
 * Kyle Raidl
 * Project 1 - PokerHand
 * CSC335, Summer 2017
 * 
 * This class tests the PokerHand class.
 */
public class PokerHandTest {

	@Test
	public void testSuitEnum() {
		String result = "";
		for (Suit suit : Suit.values())
			result += suit + " ";
		assertEquals("CLUBS DIAMONDS HEARTS SPADES", result.trim());
	}

	@Test
	public void testRankEnum() {
		String result = "";
		for (Rank rank : Rank.values())
			result += rank + " ";
		assertEquals("DEUCE THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE", result.trim());
	}

	// Do not allow duplicate cards, throw an exception
//	@Test(expected = DuplicateCardException.class)
//	public void tryToAddTheSameCardTwiceA() {
//		new PokerHand(C2, C3, C4, C5, C5);
//	}
//
//	@Test(expected = DuplicateCardException.class)
//	public void testPair2() {
//		PokerHand a = new PokerHand(H3, CA, D4, H6, DA);
//		a.toString();
//		PokerHand b = new PokerHand(H3, C5, HA, SA, C6);
//		assertTrue(a.compareTo(b) < 0);
//	}

	@Test
	public void testTwoPairWhenOnePairIsEqual() {
		PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
		PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testAceLowStraight() {
		PokerHand a = new PokerHand(CA, C2, C3, C4, H5);
		PokerHand b = new PokerHand(D2, D3, D4, D5, H6);
		boolean answer = a.compareTo(b) < 0;
		assertTrue(answer);
	}

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce,
	// Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	// TEST CARD HGH HANDS

	private static PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
	private static PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
	private static PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
	private static PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
	private static PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
	private static PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);

	@Test
	public void testNothing0() {
		assertTrue(nothing73.compareTo(nothing72) > 0);
	}

	@Test
	public void testNothing1() {
		assertTrue(nothingJ.compareTo(nothing73) > 0);
	}

	@Test
	public void testNothing2() {
		assertTrue(nothingK8.compareTo(nothingJ) > 0);
	}

	@Test
	public void testNothing3() {
		assertTrue(nothingK9.compareTo(nothingK8) > 0);
	}

	@Test
	public void testNothing4() {
		assertTrue(nothingA.compareTo(nothingK8) > 0);
	}

	// Many more tests needed
	
	private static PokerHand straightFlush = new PokerHand(S10, SJ, SQ, SK, SA);
	private static PokerHand straight = new PokerHand(H10, HJ, HQ, HK, CA);
	private static PokerHand wheel = new PokerHand(HA, S2, S3, S4, S5);
	private static PokerHand fourOfAKind = new PokerHand(C6, S6, H6, D6, H5);
	private static PokerHand fullHouse = new PokerHand(C2, D2, H2, C3, D3);
	private static PokerHand flush1 = new PokerHand(C7, C8, C9, C10, CQ);
	private static PokerHand flush2 = new PokerHand(D7, D8, D9, D10, DQ);
	private static PokerHand threeOfAKind = new PokerHand(C4, D4, H4, C5, S7);
	private static PokerHand twoPair = new PokerHand(S8, H8, S9, H9, DJ);
	private static PokerHand pair = new PokerHand(CK, DK, CJ, DA, H7);
	
	@Test
	public void testStraightFlush() {
		assertTrue(straightFlush.compareTo(fourOfAKind) > 0);
		assertTrue(straightFlush.compareTo(fullHouse) > 0);
		assertTrue(straightFlush.compareTo(flush1) > 0);
		assertTrue(straightFlush.compareTo(flush2) > 0);
		assertTrue(straightFlush.compareTo(straight) > 0);
		assertTrue(straightFlush.compareTo(wheel) > 0);
		assertTrue(straightFlush.compareTo(threeOfAKind) > 0);
		assertTrue(straightFlush.compareTo(twoPair) > 0);
		assertTrue(straightFlush.compareTo(pair) > 0);
	}
	
	@Test
	public void testFourOfAKind() {
		assertTrue(fourOfAKind.compareTo(straightFlush) < 0);
		assertTrue(fourOfAKind.compareTo(fullHouse) > 0);
		assertTrue(fourOfAKind.compareTo(flush1) > 0);
		assertTrue(fourOfAKind.compareTo(flush2) > 0);
		assertTrue(fourOfAKind.compareTo(straight) > 0);
		assertTrue(fourOfAKind.compareTo(wheel) > 0);
		assertTrue(fourOfAKind.compareTo(threeOfAKind) > 0);
		assertTrue(fourOfAKind.compareTo(twoPair) > 0);
		assertTrue(fourOfAKind.compareTo(pair) > 0);
	}
	
	@Test
	public void testFullHouse() {
		assertTrue(fullHouse.compareTo(straightFlush) < 0);
		assertTrue(fullHouse.compareTo(fourOfAKind) < 0);
		assertTrue(fullHouse.compareTo(flush1) > 0);
		assertTrue(fullHouse.compareTo(flush2) > 0);
		assertTrue(fullHouse.compareTo(straight) > 0);
		assertTrue(fullHouse.compareTo(wheel) > 0);
		assertTrue(fullHouse.compareTo(threeOfAKind) > 0);
		assertTrue(fullHouse.compareTo(twoPair) > 0);
		assertTrue(fullHouse.compareTo(pair) > 0);
	}
	
	@Test
	public void testFlush() {
		assertTrue(flush1.compareTo(straightFlush) < 0);
		assertTrue(flush1.compareTo(fourOfAKind) < 0);
		assertTrue(flush1.compareTo(fullHouse) < 0);
		assertTrue(flush1.compareTo(flush2) == 0);
		assertTrue(flush1.compareTo(straight) > 0);
		assertTrue(flush1.compareTo(wheel) > 0);
		assertTrue(flush1.compareTo(threeOfAKind) > 0);
		assertTrue(flush1.compareTo(twoPair) > 0);
		assertTrue(flush1.compareTo(pair) > 0);
		
		assertTrue(flush2.compareTo(straightFlush) < 0);
		assertTrue(flush2.compareTo(fourOfAKind) < 0);
		assertTrue(flush2.compareTo(fullHouse) < 0);
		assertTrue(flush2.compareTo(flush1) == 0);
		assertTrue(flush2.compareTo(straight) > 0);
		assertTrue(flush2.compareTo(wheel) > 0);
		assertTrue(flush2.compareTo(threeOfAKind) > 0);
		assertTrue(flush2.compareTo(twoPair) > 0);
		assertTrue(flush2.compareTo(pair) > 0);
	}

	@Test
	public void testStraight() {
		assertTrue(straight.compareTo(straightFlush) < 0);
		assertTrue(straight.compareTo(fourOfAKind) < 0);
		assertTrue(straight.compareTo(fullHouse) < 0);
		assertTrue(straight.compareTo(flush1) < 0);
		assertTrue(straight.compareTo(flush2) < 0);
		assertTrue(straight.compareTo(wheel) > 0);
		assertTrue(straight.compareTo(threeOfAKind) > 0);
		assertTrue(straight.compareTo(twoPair) > 0);
		assertTrue(straight.compareTo(pair) > 0);
	}

	@Test
	public void testWheel() {
		assertTrue(wheel.compareTo(straightFlush) < 0);
		assertTrue(wheel.compareTo(fourOfAKind) < 0);
		assertTrue(wheel.compareTo(fullHouse) < 0);
		assertTrue(wheel.compareTo(flush1) < 0);
		assertTrue(wheel.compareTo(flush2) < 0);
		assertTrue(wheel.compareTo(straight) < 0);
		assertTrue(wheel.compareTo(threeOfAKind) > 0);
		assertTrue(wheel.compareTo(twoPair) > 0);
		assertTrue(wheel.compareTo(pair) > 0);
	}
	
	@Test
	public void testThreeOfAKind() {
		assertTrue(threeOfAKind.compareTo(straightFlush) < 0);
		assertTrue(threeOfAKind.compareTo(fourOfAKind) < 0);
		assertTrue(threeOfAKind.compareTo(fullHouse) < 0);
		assertTrue(threeOfAKind.compareTo(flush1) < 0);
		assertTrue(threeOfAKind.compareTo(flush2) < 0);
		assertTrue(threeOfAKind.compareTo(straight) < 0);
		assertTrue(threeOfAKind.compareTo(wheel) < 0);
		assertTrue(threeOfAKind.compareTo(twoPair) > 0);
		assertTrue(threeOfAKind.compareTo(pair) > 0);
	}

	@Test
	public void testTwoPair() {
		assertTrue(twoPair.compareTo(straightFlush) < 0);
		assertTrue(twoPair.compareTo(fourOfAKind) < 0);
		assertTrue(twoPair.compareTo(fullHouse) < 0);
		assertTrue(twoPair.compareTo(flush1) < 0);
		assertTrue(twoPair.compareTo(flush2) < 0);
		assertTrue(twoPair.compareTo(straight) < 0);
		assertTrue(twoPair.compareTo(wheel) < 0);
		assertTrue(twoPair.compareTo(threeOfAKind) < 0);
		assertTrue(twoPair.compareTo(pair) > 0);
	}

	@Test
	public void testPair() {
		assertTrue(pair.compareTo(straightFlush) < 0);
		assertTrue(pair.compareTo(fourOfAKind) < 0);
		assertTrue(pair.compareTo(fullHouse) < 0);
		assertTrue(pair.compareTo(flush1) < 0);
		assertTrue(pair.compareTo(flush2) < 0);
		assertTrue(pair.compareTo(straight) < 0);
		assertTrue(pair.compareTo(wheel) < 0);
		assertTrue(pair.compareTo(threeOfAKind) < 0);
		assertTrue(pair.compareTo(twoPair) < 0);
	}

	@Test
	public void testGetRankValue() {
		assertEquals(0, C2.getRank().getValue());
		assertEquals(1, D3.getRank().getValue());
		assertEquals(2, S4.getRank().getValue());
		assertEquals(3, H5.getRank().getValue());
		assertEquals(4, C6.getRank().getValue());
		assertEquals(5, C7.getRank().getValue());
		assertEquals(6, C8.getRank().getValue());
		assertEquals(7, C9.getRank().getValue());
		assertEquals(8, C10.getRank().getValue());
		assertEquals(9, DJ.getRank().getValue());
		assertEquals(10, SQ.getRank().getValue());
		assertEquals(11, HK.getRank().getValue());
		assertEquals(12, CA.getRank().getValue());
	}

	@Test
	public void testGetSuitValue() {
		assertEquals(0, CQ.getSuit().getValue());
		assertEquals(1, D2.getSuit().getValue());
		assertEquals(2, H5.getSuit().getValue());
		assertEquals(3, SA.getSuit().getValue());
	}
	
	
	
	
	
	  // These tests were added after removing DuplicateCardException
	  // because things change when cards can be shared. This assumes
	  // there are no more DuplicateCardException checks. Notice these 
	  // output incorrectly list ties for full house. Only 2 should tie
	
	  @Test
	  public void testFullHouseHands() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);  // Both hands can have the same 3 Aces
	    PokerHand b = new PokerHand(S3, D3, DA, CA, HA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a) < 0);
	  }
	 
	  @Test
	  public void testFullHouseHands2() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C6, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) == 0);
	  }
	  
	  @Test
	  public void testFullHouseHands3() {
	    PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C7, H7, DA, CA, HA);
	    assertTrue(a.compareTo(b) < 0);
	    assertTrue(b.compareTo(a)> 0);
	  }
	 
	  @Test
	  public void testThreeOfAKind2() {
	    PokerHand a = new PokerHand(S6, D7, DA, CA, HA);
	    PokerHand b = new PokerHand(C5, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a) <  0);
	  }
	  
	  @Test
	  public void testThreeOfAKind3() {
	    PokerHand a = new PokerHand(S7, D6, DA, CA, HA);
	    PokerHand b = new PokerHand(C7, H6, DA, CA, HA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) ==  0);
	  }
	  
	  @Test
	  public void testFourOfAKind3() {
	    PokerHand a = new PokerHand(S7, CA, DA, HA, SA);
	    PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
	    assertTrue(a.compareTo(b) == 0);
	    assertTrue(b.compareTo(a) ==  0);
	  }
	  
	  @Test
	  public void testFourOfAKind4() {
	    PokerHand a = new PokerHand(S8, CA, DA, HA, SA);
	    PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
	    assertTrue(a.compareTo(b) > 0);
	    assertTrue(b.compareTo(a)<   0);
	  }
}