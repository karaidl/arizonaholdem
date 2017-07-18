package model;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class enumerates the rankings of a deck of playing cards.
 */

public enum Rank {
	DEUCE(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6), NINE(7), TEN(8), JACK(9), QUEEN(10), KING(
			11), ACE(12);

	private int value;

	Rank(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
