package model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class creates a Player object to store a PokerHand and
 * a balance.
 */

public class Player implements Comparable<Player> {

	private double balance;
	private Card card1, card2;
	private PokerHand bestHand;
	private String name;

	@Override
	public int compareTo(Player other) {
		return bestHand.compareTo(other.getBestHand());
	}

	public Player(String name) {
		card1 = null;
		card2 = null;
		bestHand = null;

		this.name = name;
		balance = 100.0;
	}

	public void dealToPlayer(ArrayList<Card> flop, Card c1, Card c2) {
		card1 = c1;
		card2 = c2;

		bestHand = new PokerHand(flop, c1, c2);
	}

	public double getBalance() {
		return balance;
	}

	public void changeBalance(double value) {
		balance += value;
	}

	public PokerHand getBestHand() {
		return bestHand;
	}

	@Override
	public String toString() {
		NumberFormat formatter = DecimalFormat.getCurrencyInstance();
		String str = name + ": ";

		str += formatter.format(balance);
		str += " - ";

		str += card1.toString();
		str += " " + card2.toString();

		return str;
	}

	public String getNameAndBalance() {
		return name + " " + DecimalFormat.getCurrencyInstance().format(balance);
	}
}