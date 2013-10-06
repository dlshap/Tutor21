package com.dlsa.tutor21;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.blackjack.cards.Card;
import com.blackjack.cards.Card.Rank;
import com.blackjack.cards.Card.Suit;
import com.blackjack.cards.Hand;
import com.blackjack.player.IPlayerPanel;
import com.blackjack.player.Play;
import com.blackjack.player.PlayerView;

public class DrillActivity extends Activity implements IPlayerPanel {

	TextView tvMessage, tvDCard, tvPCard1, tvPCard2;
	PlayerView playerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drill);

		Card c1 = Card.makeCard(Rank.ACE, Suit.SPADES);
		Card c2 = Card.makeCard(Rank.QUEEN, Suit.DIAMONDS);
		Card dc = Card.makeCard(Rank.SIX, Suit.CLUBS);

		// String c = "Hi There";

		// Card dCard = new Card(3,1); // 3 of Spades
		// Card pCard1 = new Card(1,4); // Ace of Clubs
		// Card pCard2 = new Card(13,2); //King of Hearts
		//
		// tvDCard = (TextView) findViewById(R.id.txtDealerCard1);
		// tvDCard.setText(dCard.toString());
		// tvPCard1 = (TextView) findViewById(R.id.txtPlayerCard1);
		// tvPCard1.setText(pCard1.toString());
		tvMessage = (TextView) findViewById(R.id.txtMessage);
		tvMessage.setText("");
		tvPCard2 = (TextView) findViewById(R.id.txtPlayerCard2);
		tvPCard2.setText(c1.toString());
		tvPCard1 = (TextView) findViewById(R.id.txtPlayerCard1);
		tvPCard1.setText(c2.toString());
		tvDCard = (TextView) findViewById(R.id.txtDealerCard1);
		tvDCard.setText(dc.toString());
		
		//set up stacker spinner (drop-down menu)
		Spinner stackerSpinner = (Spinner) findViewById(R.id.spnStacker);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.stacker_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		stackerSpinner.setAdapter(adapter);
		
		setPlayerView(PlayerView.createPlayerView(this));
		// start the drill
		playerView.startPlay();
	}

	private void setPlayerView(PlayerView playerView) {
		this.playerView = playerView;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_drill, menu);

		final Button dealButton = (Button) findViewById(R.id.btnDeal);
		final Button hitButton = (Button) findViewById(R.id.btnHit);
		final Button stickButton = (Button) findViewById(R.id.btnStick);
		final Button doubleButton = (Button) findViewById(R.id.btnDouble);
		final Button splitButton = (Button) findViewById(R.id.btnSplit);
		final Spinner stackerSpinner = (Spinner) findViewById(R.id.spnStacker);
		
		dealButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvMessage.setText("You hit the Deal button!");
			}
		});
		hitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvMessage.setText("You hit the Hit button!");
			}
		});
		stickButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvMessage.setText("You hit the Stick button!");
			}
		});
		doubleButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvMessage.setText("You hit the Double button!");
			}
		});
		splitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvMessage.setText("You hit the Split button!");
			}
		});
		stackerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, 
		            int pos, long id) {
		        tvMessage.setText("Game type: "+parent.getItemAtPosition(pos).toString());
		    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				tvMessage.setText("Nothing Selected");
				
			}

		});
		return true;
	}

	@Override
	public void clearCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableAllButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableButton(Play arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableAllButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableButton(Play arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCards(Hand arg0, Hand arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showJokers() {
		// TODO Auto-generated method stub
		
	}

}
