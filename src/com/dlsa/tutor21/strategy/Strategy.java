package com.dlsa.tutor21.strategy;

import com.dlsa.tutor21.cards.Card;
import com.dlsa.tutor21.player.Play;
import com.dlsa.tutor21.table.Hand;

public interface Strategy {
	
	public abstract Play getPlay(Card dealerCard, Hand playerHand);
}
