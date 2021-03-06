package com.example.subastaya;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AuctionActivity extends ActionBarActivity {

	private Auction auction;
	private Product product;
	
	private MainProductInfoFragment mainProductInfo;
	private OfferFormFragment offerForm;
	
	private AuthUser user = null;
	
	private ImageView prev;
	private ImageView next;
	
	private Boolean canGoPrev = false; // checks if the user is able to go click on prev button
	private Boolean canGoNext = false; // checks if the user is able to go click on prev button
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auction);
		getIntent();
		
		ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
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
	    this.user = (AuthUser) intent.getSerializableExtra(MainActivity.EXTRA_USER);
	    
		this.offerForm = (OfferFormFragment) getSupportFragmentManager().findFragmentById(R.id.offerform_fragment);
	    this.mainProductInfo = (MainProductInfoFragment) getSupportFragmentManager().findFragmentById(R.id.mainproductinfo_fragment);
	    
    	this.prev = (ImageView) findViewById(R.id.prevArrow);
    	this.next = (ImageView) findViewById(R.id.nextArrow);

	    this.auction = new AuctionImpl(query);
	    
	    mainProductInfo.setLoading();
	    disableActions();
	    
	    this.auction.nextProduct(new Callback<AuctionResponse>() {
			    @Override
				public void success(AuctionResponse auctionResponse, Response arg1) {
					/*
					*/
			    	if (auctionResponse.getState() == AuctionState.API_ERROR) {
			    		//displayServerError();
			    		//return;
			    	} else if (auctionResponse.getState() == AuctionState.EMPTY_RESULTS) {
			    		mainProductInfo.showEmptyResultsMessage();
			    		return;
			    	}
			    	product = auctionResponse.getProduct();
			    	displayCurrentProduct();
			    	
			    	canGoNext = auctionResponse.hasNext();
			    	canGoPrev = auctionResponse.hasPrevious();
			    	updateActionEnableing();
				}

				@Override
				public void failure(RetrofitError arg0) {
				}
	    });
	    	   
	}
	
	public void disableActions() {
	    this.next.setVisibility(View.GONE);
	    this.prev.setVisibility(View.GONE);
	}
	
	public void updateActionEnableing() {
		if ( canGoNext ) {
	    	this.next.setVisibility(View.VISIBLE);
		} else {
	    	this.next.setVisibility(View.GONE);
		}
		
		if ( canGoPrev ) {
	    	this.prev.setVisibility(View.VISIBLE);
		} else {
	    	this.prev.setVisibility(View.GONE);
		}	
	}
		
	public void displayCurrentProduct() {
		this.mainProductInfo.setContent(this.product);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
		if ( this.canGoNext ) {
			this.canGoNext = false;
			this.canGoPrev = false;
		    mainProductInfo.setLoading();
		    disableActions();
		    
			this.auction.nextProduct(new Callback<AuctionResponse>() {
			    @Override
				public void success(AuctionResponse auctionResponse, Response arg1) {
			    	if (auctionResponse.getState() == AuctionState.API_ERROR) {
			    		//displayServerError();
			    		//return;
			    	}
			    	product = auctionResponse.getProduct();
			    	displayCurrentProduct();
			    	canGoNext = auctionResponse.hasNext();
			    	canGoPrev = auctionResponse.hasPrevious();
			    	updateActionEnableing();
				}
	
				@Override
				public void failure(RetrofitError arg0) {
				}
			});
		}
	}
	
	public void prevProduct(View view) {
		if ( this.canGoPrev ) {
			this.canGoNext = false;
			this.canGoPrev = false;
		    mainProductInfo.setLoading();
		    disableActions();
		    
			this.auction.prevProduct(new Callback<AuctionResponse>() {
			    @Override
				public void success(AuctionResponse auctionResponse, Response arg1) {
			    	if (auctionResponse.getState() == AuctionState.API_ERROR) {
			    		//displayServerError();
			    		//return;
			    	}
			    	product = auctionResponse.getProduct();
			    	displayCurrentProduct();
			    	canGoNext = auctionResponse.hasNext();
			    	canGoPrev = auctionResponse.hasPrevious();
			    	updateActionEnableing();
				}
	
				@Override
				public void failure(RetrofitError arg0) {
				}
			});
		}
	}
	
	public void offer(View view) {
		this.offerForm.offer(view, user, product);
	}
}
