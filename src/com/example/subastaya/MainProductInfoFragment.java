package com.example.subastaya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainProductInfoFragment extends Fragment {
	
	TextView productTitle = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	    
        return inflater.inflate(R.layout.mainproduct_view, container, false);

    }
    
    public void setLoading() {
    	initProductTitle();
    	this.productTitle.setText("Loading...");   	
    }
    
    private void initProductTitle() {
    	if ( this.productTitle == null ) {
    		this.productTitle = (TextView) getView().findViewById(R.id.productTitle);
 	    	this.productTitle.setTextSize(40);
    	}
    }
    
    public void setContent(Product product) {
    	initProductTitle();
    	if ( product != null ) {
    		this.productTitle.setText(product.getTitle());
    	} else {
    		this.setLoading();
    	}
    }

	public void showEmptyResultsMessage() {
		initProductTitle();
    	this.productTitle.setText("No results were found"); 
	}

}