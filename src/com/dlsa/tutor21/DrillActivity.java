package com.dlsa.tutor21;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DrillActivity extends Activity {
	
	TextView tvDCard, tvPCard1, tvPCard2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drill);
		
		Card dCard = new Card(3,1); // 3 of Spades
		Card pCard1 = new Card(1,4); // Ace of Clubs
		Card pCard2 = new Card(13,2); //King of Hearts
		
		tvDCard = (TextView) findViewById(R.id.txtDealerCard1);
		tvDCard.setText(dCard.getCard());
		tvPCard1 = (TextView) findViewById(R.id.txtPlayerCard1);
		tvPCard1.setText(pCard1.getCard());
		tvPCard2 = (TextView) findViewById(R.id.txtPlayerCard2);
		tvPCard2.setText(pCard2.getCard());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_drill, menu);
		return true;
	}

}
