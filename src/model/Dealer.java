package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Kyle Raidl
 * Project 2 - Arizona Hold'em
 * CSC335, Summer 2017
 * 
 * This class creates a Dealer object and plays rounds of Arizona Hold'em.
 * Client may select number of players.
 */

public class Dealer {

	private ArrayList<Player> playerList;
	private ArrayList<Player> winnerList;

	private Deck deck;
	private ArrayList<Card> flop;
	private double pot;
	private int winnerCount;

	public Dealer(int numOfPlayers) {
		shuffleDeck();
		pot = 0.0;
		playerList = new ArrayList<Player>();

		for (int i = 0; i < numOfPlayers; i++)
			playerList.add(new Player("Player " + (i + 1)));

		winnerList = new ArrayList<Player>(playerList);
	}

	private void takeAnte() {
		for (Player player : playerList) {
			player.changeBalance(-2.0);
			pot += 2.0;
		}
	}

	private void dealCards() {
		flop = new ArrayList<Card>();
		flop.add(deck.drawCard());
		flop.add(deck.drawCard());
		flop.add(deck.drawCard());
		flop.add(deck.drawCard());
		flop.add(deck.drawCard());

		for (Player player : playerList)
			player.dealToPlayer(flop, deck.drawCard(), deck.drawCard());

		Collections.sort(winnerList);
	}

	private void givePot() {
		winnerCount = 0;
		for (Player player : playerList)
			if (0 == player.compareTo(winnerList.get(winnerList.size() - 1)))
				winnerCount++;

		for (int i = winnerList.size() - winnerCount; i < winnerList.size(); i++)
			winnerList.get(i).changeBalance(pot / winnerCount);

		pot = 0.0;
	}

	private void shuffleDeck() {
		deck = new Deck();
	}

	private void printReadOut() {
		System.out.print("Community Cards:");
		for (Card card : flop)
			System.out.print(" " + card.toString());

		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++");

		for (Player player : playerList) {
			System.out.println(player.toString());
			System.out.println("   Best Hand: " + player.getBestHand().toString());
			System.out.println();
		}
	}

	private void printWinner() {
		if (winnerCount > 1) {
			printTie();
			return;
		}

		System.out.println("Winner: " + winnerList.get(winnerList.size() - 1).getNameAndBalance());
		System.out.println("++++++++++++++++++++++++++++++++++++");
		System.out.println(winnerList.get(winnerList.size() - 1).getBestHand().toString());
		System.out.println();
	}

	private void printTie() {
		System.out.println("Winning hands (tie)");
		System.out.println("++++++++++++++++++++++++++++++++++++");

		for (int i = winnerList.size() - winnerCount; i < winnerList.size(); i++)
			System.out.println(winnerList.get(i).getBestHand().toString());

		System.out.println();
	}

	public static void main(String[] args) {
		System.out.print("How many players? ");
		Scanner scanner = new Scanner(System.in);
		int numOfPlayers = Integer.parseInt(scanner.nextLine());

		Dealer dealer = new Dealer(numOfPlayers);

		while (true) {
			dealer.takeAnte();
			dealer.dealCards();
			dealer.printReadOut();
			dealer.givePot();
			dealer.printWinner();

			System.out.print("Play another game? ");
			if (!scanner.nextLine().toLowerCase().equals("y"))
				break;

			System.out.println();
		}

		scanner.close();
	}

}