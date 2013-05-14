package com.dlsa.tutor21;

import java.util.ArrayList;
import java.util.Iterator;

public class Deck {
	ArrayList<Card> cards = new ArrayList<Card>(52);
	Iterator<Card> deckIter = cards.iterator();

	public Deck() {
		super();
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				cards.add(new Card(j, i));
			}
		}
	}
	
	public Card deal() {
		
		
//		if (deckIter.hasNext())
//			return deckIter.next();
//		else
			return null;
	}

}
