package com.dlsa.tutor21.deckstackers;

import java.util.ArrayList;

import com.dlsa.tutor21.cards.Card;
import com.dlsa.tutor21.cards.Shoe;

public abstract class DeckStacker {
	
	private boolean shuffle = true;
	protected Shoe shoe;
	protected ArrayList<Card> newDeck = Card.newDeck();
	
	public DeckStacker() {
		super();
	}
	
	public DeckStacker(boolean shuffle) {
		super();
		this.shuffle = shuffle;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}
	
	protected Shoe getShoe() {
		return this.shoe;
	}
	
	protected boolean getShuffle() {
		return shuffle;
	}

	public abstract void buildShoe();
		
}
