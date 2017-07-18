package model;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class enumerates the suits of a deck of playing cards.
 */

public enum Suit {
	CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
	
	private int value;

	Suit(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
