package com.example.subastaya;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OfferFormFragment extends Fragment {

	public static final String EXTRA_MELI_URL = "MELI_URL";
	public static final String EXTRA_USER_TOKEN = "USER_TOKEN";

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	    
        return inflater.inflate(R.layout.offerform_view, container, false);
    }
    
    public void login() {
    	RestAdapter restAdapterOAuth = new RestAdapter.Builder().setEndpoint("http://auth.mercadolibre.com").build();
		MeliOAuth meliOAuthService = restAdapterOAuth.create(MeliOAuth.class);	
		
		meliOAuthService.authorize("code", "6684097356045737", "http://subastaya.com", new Callback<String>() {

			public void processResponse(Response response) {
				if ( response.getStatus() == 200 ) {
					Intent intent = new Intent(getActivity(), MeliOAuthWebActivity.class);
			    	intent.putExtra(EXTRA_MELI_URL, response.getUrl());  
			    	startActivity(intent);
				} else {
					//TODO Handle oauth service not working 
				}
			}
			
			@Override
			public void failure(RetrofitError arg0) {
				processResponse(arg0.getResponse());
			}

			@Override
			public void success(String arg0, Response arg1) {
				processResponse(arg1);
			}
			
		});
	}
    
    public void offer(View view, AuthUser user) {
    	if ( user == null ) {
    		login();
    		return;
    	}
    	DialogFragment paymentDialog = new PaymentDialogFragment();
    	
    	Bundle args = new Bundle();
        args.putString(EXTRA_USER_TOKEN, user.getToken());
        paymentDialog.setArguments(args);
        
        paymentDialog.show(getActivity().getSupportFragmentManager(), "payments");    	
    }

}