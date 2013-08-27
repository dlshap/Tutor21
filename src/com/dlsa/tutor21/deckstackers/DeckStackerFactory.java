package com.dlsa.tutor21.deckstackers;

public class DeckStackerFactory {
	
	public static DeckStacker getPairsOnlyDeckStacker() {
		return new PairsOnlyDeckStacker();
	}
	
	public static DeckStacker getFairDeckStacker() {
		return new FairDeckStacker();
	}
	
}
