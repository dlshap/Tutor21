package com.dlsa.tutor21;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blackjack.cards.Card;
import com.blackjack.cards.Card.Rank;
import com.blackjack.cards.Card.Suit;

public class DrillActivity extends Activity {

	TextView tvDCard, tvPCard1, tvPCard2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drill);

		 Card c = Card.makeCard(Rank.ACE, Suit.SPADES);
		
//		String c = "Hi There";

		// Card dCard = new Card(3,1); // 3 of Spades
		// Card pCard1 = new Card(1,4); // Ace of Clubs
		// Card pCard2 = new Card(13,2); //King of Hearts
		//
		// tvDCard = (TextView) findViewById(R.id.txtDealerCard1);
		// tvDCard.setText(dCard.toString());
		// tvPCard1 = (TextView) findViewById(R.id.txtPlayerCard1);
		// tvPCard1.setText(pCard1.toString());
		tvPCard2 = (TextView) findViewById(R.id.txtPlayerCard2);
		tvPCard2.setText(c.toString());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_drill, menu);

		final Button doubleButton = (Button) findViewById(R.id.btnDeal);
		doubleButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tvPCard2.setText("You hit the Double button!");
			}
		});

		return true;
	}

}
