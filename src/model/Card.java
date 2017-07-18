package model;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class creates an instance of a Card.
 */

public class Card implements Comparable<Card> {

	@Override
	public int compareTo(Card other) {
		return rank.getValue() - other.rank.getValue();
	}

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		String name = "";

		switch (rank) {
		case ACE:
			name += "A";
			break;
		case DEUCE:
			name += "2";
			break;
		case THREE:
			name += "3";
			break;
		case FOUR:
			name += "4";
			break;
		case FIVE:
			name += "5";
			break;
		case SIX:
			name += "6";
			break;
		case SEVEN:
			name += "7";
			break;
		case EIGHT:
			name += "8";
			break;
		case NINE:
			name += "9";
			break;
		case TEN:
			name += "T";
			break;
		case JACK:
			name += "J";
			break;
		case QUEEN:
			name += "Q";
			break;
		case KING:
			name += "K";
			break;
		default:
			break;
		}

		switch (suit) {
		case CLUBS:
			name += '\u2663';
			break;
		case DIAMONDS:
			name += '\u2666';
			break;
		case HEARTS:
			name += '\u2665';
			break;
		case SPADES:
			name += '\u2660';
			break;
		default:
			break;
		}

		return name;
	}
}