package com.dlsa.tutor21;

public class Card {
	int number;
	int suit;
	static String suits[] = { "Spades", "Hearts", "Diamonds", "Clubs" };
	static String Numbers[] = { "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "Ten", "Jack", "Queen", "King" };

	static String getCardSuit(int suit) {
		if (suit >= 1 && suit <= 4)
			return suits[suit - 1];
		else
			return "";
	}

	static String getCardNumber(int number) {
		if (number >= 0 && number <= 13)
			return Numbers[number - 1];
		else
			return "";
	}

	public Card(int number, int suit) {
		super();
		this.number = number;
		this.suit = suit;
	}

	private int getNumber() {
		return number;
	}

	private int getSuit() {
		return suit;
	}

	public String toString() {
		return getCardNumber(this.getNumber()) + " of "
				+ getCardSuit(this.getSuit());
	}

}
