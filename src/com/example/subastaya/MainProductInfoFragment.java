package com.example.subastaya;

import java.io.InputStream;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.subastaya.apimodels.ItemResponse;
import com.example.subastaya.apimodels.Picture;

public class MainProductInfoFragment extends Fragment {
	
	TextView productTitle;
	LoadingFragment loadingFragment;
	TextView price;
	TextView timeRemaining;
	ImageView image;
	
	MercadoLibreAPI mercadoLibreService;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	    
        return inflater.inflate(R.layout.mainproduct_view, container, false);

    }
    
    public void setTimeRemaining(Product product) {
    	DateTime end = new DateTime(product.getStopTime());
    	DateTime now = new DateTime();
    	Duration dur = new Duration(now, end);
    	
    	String date = "";
    	if ( dur.getStandardDays() > 0 ) {
    		date += (dur.getStandardDays() + " dia" + (dur.getStandardDays() == 1 ? "" : "s") + " y "); 
		}
    	date = date + dur.getStandardHours() % 24 + ":" + dur.getStandardMinutes() % 60 + ":" +dur.getStandardSeconds() % 60 + "s";
 		
		
    	this.timeRemaining.setText("Termina en " + date);
    }
    
    public void setLoading() {
    	initProductTitle();
    	this.productTitle.setText("");
    	FragmentManager fm = getActivity().getSupportFragmentManager();    	
    	fm.beginTransaction()
    	          .show(this.loadingFragment)
    	          .commit();
    }
    
    private void initProductTitle() {
    	if ( this.mercadoLibreService == null) {
    		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
    		this.mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);
    	}
    	if ( this.productTitle == null ) {
    		this.productTitle = (TextView) getView().findViewById(R.id.productTitle);
    	}
    	if ( this.loadingFragment == null) {
    		this.loadingFragment = (LoadingFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.loading_fragment); 
    	}
    	if ( this.price == null ) {
    		this.price = (TextView) getView().findViewById(R.id.price);
    	}
    	if ( this.timeRemaining == null ) {
    		this.timeRemaining = (TextView) getView().findViewById(R.id.timeRemaining);
    	}
    	if ( this.image == null ) {
    		this.image = (ImageView) getView().findViewById(R.id.productImage);
    	}
    }
    
    public void setContent(final Product product) {
    	initProductTitle();
    	if ( product != null ) {
    		FragmentManager fm = getActivity().getSupportFragmentManager();    	
        	fm.beginTransaction()
        	          .hide(this.loadingFragment)
        	          .commit();
    		this.productTitle.setText(product.getTitle());
    		this.price.setText("$ " + product.getPrice().toString());
    		
    		setTimeRemaining(product);
    		
    		this.mercadoLibreService.getItem(product.getId(), new Callback<ItemResponse>(){

				@Override
				public void failure(RetrofitError arg0) {
				}

				@Override
				public void success(ItemResponse item, Response arg1) {
					if ( item.getPictures().size() > 0 ) {
						Picture p = item.getPictures().get(0);
			    		new DownloadImageTask(image).execute(p.getUrl());
					}
				}
    			
    		});
    	} else {
    		this.setLoading();
    	}
    }

	public void showEmptyResultsMessage() {
		initProductTitle();
    	this.productTitle.setText("No results were found"); 
    	FragmentManager fm = getActivity().getSupportFragmentManager();    	
    	fm.beginTransaction()
    	          .hide(this.loadingFragment)
    	          .commit();
	}
	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    ImageView bmImage;

	    public DownloadImageTask(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	        bmImage.setImageBitmap(result);
	    }
	}

}