package com.dlsa.tutor21.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dlsa.tutor21.deckstackers.DeckStacker;
import com.dlsa.tutor21.deckstackers.DeckStackerFactory;
import com.dlsa.tutor21.deckstackers.FairDeckStacker;

public class Shoe {

	private int numberOfDecks = 6; // default 6 deck shoe
	private List<Card> shoe = (List<Card>) Collections
			.synchronizedList(new ArrayList<Card>());
	private List<Card> discardPile = (List<Card>) Collections
			.synchronizedList(new ArrayList<Card>());
	private DeckStacker deckStacker;

	public Shoe() {
		super();
		// TODO Auto-generated constructor stub
		setupDeckStacker(DeckStackerFactory.getFairDeckStacker());
	}

	public Shoe(int numberOfDecks) {
		super();
		this.numberOfDecks = numberOfDecks;
		setupDeckStacker(DeckStackerFactory.getFairDeckStacker());
	}
	
	public Shoe(DeckStacker deckStacker) {
		super();
		setupDeckStacker(deckStacker);
	}
	
	public Shoe(int numberOfDecks, DeckStacker deckStacker) {
		this.numberOfDecks = numberOfDecks;
		setupDeckStacker(deckStacker);
	}

	private void ShoeInit() {
		
	}

	private void setupDeckStacker(DeckStacker deckStacker) {
		this.deckStacker = deckStacker;
		this.deckStacker.setShoe(this);
		buildShoe();
	}

	public void setDeckStacker(DeckStacker deckStacker) {
		setupDeckStacker(deckStacker);
	}

	public int getNumberOfDecks() {
		return numberOfDecks;
	}

	public void shuffle() {
		Collections.shuffle(shoe);
	}

	public void add(Card card) {
		shoe.add(card);
	}

	public Card nextCard() throws EmptyShoeException {
		if (shoe.size() > 0) {
			Card nextCard = shoe.get(0); // Get the next card
			discardPile.add(nextCard); // Add to discard pile
			shoe.remove(0); // Remove it from the shoe
			return nextCard;
		} else
			throw new EmptyShoeException(); // empty shoe
	}

	public String toString() {
		String shoeString = "";
		for (int i = 0; i < shoe.size(); i++) {
			if (i > 0)
				shoeString += "\n";
			shoeString += shoe.get(i).toString();
		}
		return shoeString;
	}

	public void buildShoe() {
		shoe.clear();
		discardPile.clear();
		this.deckStacker.buildShoe();
	}
}
