package com.example.subastaya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainProductInfoFragment extends Fragment {
	
	TextView productTitle = null;
	LoadingFragment loadingFragment;
	TextView price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	    
        return inflater.inflate(R.layout.mainproduct_view, container, false);

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
    	if ( this.productTitle == null ) {
    		this.productTitle = (TextView) getView().findViewById(R.id.productTitle);
 	    	this.productTitle.setTextSize(40);
    	}
    	if ( this.loadingFragment == null) {
    		this.loadingFragment = (LoadingFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.loading_fragment); 
    	}
    	if ( this.price == null ) {
    		this.price = (TextView) getView().findViewById(R.id.price);
    	}
    }
    
    public void setContent(Product product) {
    	initProductTitle();
    	if ( product != null ) {
    		FragmentManager fm = getActivity().getSupportFragmentManager();    	
        	fm.beginTransaction()
        	          .hide(this.loadingFragment)
        	          .commit();
    		this.productTitle.setText(product.getTitle());
    		this.price.setText("$ " + product.getPrice().toString());
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

}