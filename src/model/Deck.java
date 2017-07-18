package model;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class creates an instance of a list of unique Card objects to make
 * a full deck of cards.
 */

public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();
		
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}
		
		this.shuffle();
	}

	public int size() {
		return deck.size();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card drawCard() {
		return deck.remove(0);
	}
}