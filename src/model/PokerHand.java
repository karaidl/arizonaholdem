package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class creates an instance of an object which stores five Cards representing
 * a single poker hand in Arizona Hold'em.
 */

public class PokerHand implements Comparable<PokerHand> {

	@Override
	public int compareTo(PokerHand other) {
		int ret = this.getHandValue() - other.getHandValue();
		return ret == 0 ? compareHighCard(other) : ret;
	}

	private int compareHighCard(PokerHand other) {
		return getTotalHandValue() - other.getTotalHandValue();
	}

	private int getTotalHandValue() {
		int totalHandValue = 0;
		for (Card card : pokerHand)
			totalHandValue += card.getRank().getValue();

		return totalHandValue;
	}

	private ArrayList<Card> pokerHand;
	private PokerHand bestHand;

	private int[] pokerHandRanks;
	private int[] pokerHandSuits;

	public PokerHand(ArrayList<Card> flop, Card c1, Card c2) {
		bestHand = new PokerHand(flop);
		Card tempCard1;
		Card tempCard2;
		PokerHand tempHand;

		for (int i = 0; i < 5; i++) {
			tempCard1 = flop.set(i, c1);
			tempHand = new PokerHand(flop);
			if (tempHand.compareTo(bestHand) > 0)
				bestHand = tempHand;

			for (int j = 0; j < 5; j++) {
				tempCard2 = flop.set(j, c2);
				tempHand = new PokerHand(flop);
				if (tempHand.compareTo(bestHand) > 0)
					bestHand = tempHand;

				flop.set(j, tempCard2);
			}

			flop.set(i, tempCard1);
		}

		pokerHand = new ArrayList<Card>(bestHand.toArrayList());

		pokerHandRanks = new int[13];
		pokerHandSuits = new int[4];

		// count up card ranks
		for (Card card : pokerHand)
			pokerHandRanks[card.getRank().getValue()]++;
		// count up card suits
		for (Card card : pokerHand)
			pokerHandSuits[card.getSuit().getValue()]++;
	}

	private PokerHand(ArrayList<Card> cards) {
		pokerHand = new ArrayList<Card>(cards);

		Collections.sort(pokerHand);

		pokerHandRanks = new int[13];
		pokerHandSuits = new int[4];

		// count up card ranks
		for (Card card : pokerHand)
			pokerHandRanks[card.getRank().getValue()]++;
		// count up card suits
		for (Card card : pokerHand)
			pokerHandSuits[card.getSuit().getValue()]++;
	}
	
	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		pokerHand = new ArrayList<Card>();
		pokerHand.add(c1);
		pokerHand.add(c2);
		pokerHand.add(c3);
		pokerHand.add(c4);
		pokerHand.add(c5);
		
		Collections.sort(pokerHand);

		pokerHandRanks = new int[13];
		pokerHandSuits = new int[4];

		// count up card ranks
		for (Card card : pokerHand)
			pokerHandRanks[card.getRank().getValue()]++;
		// count up card suits
		for (Card card : pokerHand)
			pokerHandSuits[card.getSuit().getValue()]++;
	}

	private int getHandValue() {
		if (isWheelFlush())
			return 9;
		if (isStraightFlush())
			return 10;
		if (isFourOfAKind())
			return 8;
		if (isFullHouse())
			return 7;
		if (isFlush())
			return 6;
		if (isWheel())
			return 4;
		if (isStraight())
			return 5;
		if (isThreeOfAKind())
			return 3;
		if (isTwoPair())
			return 2;
		if (isPair())
			return 1;
		else
			return 0;
	}

	private boolean isPair() {
		for (int rankCount : pokerHandRanks)
			if (rankCount == 2)
				return true;

		return false;
	}

	private boolean isTwoPair() {
		int pairs = 0;
		for (int rankCount : pokerHandRanks)
			if (rankCount == 2)
				pairs++;

		return pairs > 1;
	}

	private boolean isThreeOfAKind() {
		for (int rankCount : pokerHandRanks)
			if (rankCount == 3)
				return true;

		return false;
	}

	private boolean isStraight() {
		for (int i = 1; i < 5; i++)
			if (1 != pokerHand.get(i).getRank().getValue() - pokerHand.get(i - 1).getRank().getValue())
				return false;

		return true;
	}

	// a wheel is a low straight. A-2-3-4-5
	private boolean isWheel() {
		return (pokerHand.get(4).getRank().getValue() == 12 && pokerHand.get(0).getRank().getValue() == 0
				&& pokerHand.get(1).getRank().getValue() == 1 && pokerHand.get(2).getRank().getValue() == 2
				&& pokerHand.get(3).getRank().getValue() == 3);
	}

	private boolean isFlush() {
		for (int suits : pokerHandSuits)
			if (suits > 4)
				return true;

		return false;
	}

	private boolean isFullHouse() {
		return isPair() && isThreeOfAKind();
	}

	private boolean isFourOfAKind() {
		for (int rankCount : pokerHandRanks)
			if (rankCount == 4)
				return true;

		return false;
	}

	private boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	private boolean isWheelFlush() {
		return isWheel() && isFlush();
	}

	@Override
	public String toString() {
		String name = "";
		for (Card card : pokerHand)
			name += card.toString() + " ";

		name += " - ";

		switch (getHandValue()) {
		case 10:
			name += "STRAIGHT_FLUSH";
			break;
		case 9:
			name += "STRAIGHT_FLUSH";
			break;
		case 8:
			name += "FOUR_OF_A_KIND";
			break;
		case 7:
			name += "FULL_HOUSE";
			break;
		case 6:
			name += "FLUSH";
			break;
		case 5:
			name += "STRAIGHT";
			break;
		case 4:
			name += "STRAIGHT";
			break;
		case 3:
			name += "THREE_OF_A_KIND";
			break;
		case 2:
			name += "TWO_PAIR";
			break;
		case 1:
			name += "PAIR";
			break;
		default:
			name += "HIGH_CARD";
		}

		return name;
	}

	private ArrayList<Card> toArrayList() {
		return pokerHand;
	}
}
