package com.example.subastaya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AuctionActivity extends ActionBarActivity {

	private Auction auction;
	private TextView productTitle;
	private Product product;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auction);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String query = intent.getStringExtra(MainActivity.EXTRA_QUERY);
	
	    this.productTitle = new TextView(this); 
	    productTitle = (TextView) findViewById(R.id.productTitle);
	    productTitle.setTextSize(40);
	    
	    this.auction = new AuctionImpl(query);
	    this.product = this.auction.nextProduct();
	    displayCurrentProduct();
	}
	
	private void displayCurrentProduct() {
	    productTitle.setText(this.product.getName());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auction, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_auction,
					container, false);
			return rootView;
		}
	}
	
	public void nextProduct(View view) {
		Product product = this.auction.nextProduct();
		if ( product != null ) {
			this.product = product;
			displayCurrentProduct();
		}
	}

	public void prevProduct(View view) {
		Product product = this.auction.prevProduct();
		if ( product != null ) {
			this.product = product;
			displayCurrentProduct();
		}
	}
}
