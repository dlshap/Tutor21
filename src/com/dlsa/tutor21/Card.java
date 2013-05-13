package com.dlsa.tutor21;

public class Card {
	int theNumber;
	int theSuit;
	static String cardSuits[] = { "Spades", "Hearts", "Diamonds", "Clubs" };
	static String cardNumbers[] = { "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "Ten", "Jack", "Queen", "King" };

	static String getCardSuit(int suit) {
		if (suit >= 1 && suit <= 4)
			return cardSuits[suit - 1];
		else
			return "";
	}

	static String getCardNumber(int cardNumber) {
		if (cardNumber >= 0 && cardNumber <= 13)
			return cardNumbers[cardNumber - 1];
		else
			return "";
	}
	

	public Card(int theNumber, int theSuit) {
		super();
		this.theNumber = theNumber;
		this.theSuit = theSuit;
	}

	public int getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}

	public int getTheSuit() {
		return theSuit;
	}

	public void setTheSuit(int theSuit) {
		this.theSuit = theSuit;
	}

	
	public String getCard() {
		return getCardNumber(this.getTheNumber())+" of "+getCardSuit(this.getTheSuit());
	}
	

	

	

	

}
