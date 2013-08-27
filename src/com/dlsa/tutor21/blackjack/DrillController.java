package com.dlsa.tutor21.blackjack;

import com.dlsa.tutor21.cards.Card;
import com.dlsa.tutor21.cards.EmptyShoeException;
import com.dlsa.tutor21.cards.Shoe;
import com.dlsa.tutor21.deckstackers.DeckStackerFactory;
import com.dlsa.tutor21.player.Play;
import com.dlsa.tutor21.player.PlayerView;
import com.dlsa.tutor21.strategy.BasicStrategy;
import com.dlsa.tutor21.strategy.Strategy;
import com.dlsa.tutor21.table.Hand;

public class DrillController {

	private GameConfig playConfig = new GameConfig();
	private Strategy strategy = BasicStrategy.createBasicStrategy();
	private Shoe shoe;
	private PlayerView playerView;

	private DrillController() {
		super();
		createShoe();
		pickDeckStacker();
		
	}

	public static DrillController createDrillController(PlayerView playerView) {
		DrillController drillController = new DrillController();
		drillController.setPlayerView(playerView);
		return drillController;
	}

	private void pickDeckStacker() {
		// if only pairs, use that deck stacker; otherwise use fair deck stacker
		if (playConfig.isDrillOnPairs() && (!playConfig.isDrillOnHardHands())
				&& (!playConfig.isDrillOnSoftHands()))
			shoe.setDeckStacker(DeckStackerFactory.getPairsOnlyDeckStacker());
		else
			// for now this is only other option...later we'll have more
			// stackers
			shoe.setDeckStacker(DeckStackerFactory.getFairDeckStacker());
	}

	public void startPlay() {
		setupPanelForNewGame(); // disable buttons until ready to play
		waitForDeal(); // enable "Deal" button and wait for user
	}

	private void createShoe() {
		shoe = new Shoe(playConfig.getDeckCount());
	}

	private Card deal() {
		Card nextCard;
		try {
			nextCard = shoe.nextCard();
		} catch (EmptyShoeException e) {
			nextCard = reshuffleShoe();
		}
		return nextCard;
	}

	private Card reshuffleShoe() {
		shoe.buildShoe();
		return deal();
	}

	public boolean checkPlay(Play play, Card dealerCard, Hand playerHand) {
		Play correctPlay = strategy.getPlay(dealerCard, playerHand);
		if (play == correctPlay)
			return true;
		else
			return false;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;

	}

	private void dealAHand() {
		playerView.emptyHands();
		playerView.givePlayerACard(deal());
		playerView.giveDealerACard(deal());
		playerView.givePlayerACard(deal());
		playerView.showCards();
	}

	private void waitForDeal() {
		playerView.enableButton(Play.DEAL);

	}

	private void waitForPlay() {
		playerView.enableAllButtons();
		playerView.disableButton(Play.DEAL);
	}

	private void setupPanelForNewGame() {
		playerView.clearCards();
		playerView.disableAllButtons();
	}

	public void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
	}

	public void doAction(Play buttonAction) {
		switch (buttonAction) {
		case DEAL:
			dealAHand();
			waitForPlay();
			break;
		case HIT:
		case SPLIT:
		case STAND:
		case DOUBLE:
			Card dealerCard = playerView.getDealerCard();
			Hand playerHand = playerView.getPlayerHand();
			boolean result = checkPlay(buttonAction, dealerCard, playerHand);
			System.out.print(buttonAction.toString()+": ");
			if (result) playerView.enableButton(Play.DEAL);
			playerView.showResult(result);
		}

	}

}
