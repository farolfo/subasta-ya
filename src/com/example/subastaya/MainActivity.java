package com.example.subastaya;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.subastaya.apimodels.TokenAuthorization;
import com.example.subastaya.apimodels.User;

public class MainActivity extends ActionBarActivity {

    static final String EXTRA_QUERY = "QUERY";
	static final String EXTRA_INDEX = "INDEX";
	static final String APP_TOKEN = "uk3qZb6iSmSEd75paPiYVCYsD8mHbFPD";
	
	MercadoLibreAPI mercadoLibreService;
	
	AuthUser user;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
        this.mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public boolean hasCode(Uri uri) {
    	String code;
    	if ( uri != null ) {
    		code = uri.getQueryParameter("code");
    		return code != null;
    	} 
    	return false;
    }
    
    public Long getClienIdFromToken(String token) {
    	String[] splitted = token.split("_");
    	String id = splitted[splitted.length - 1];
    	id = id.substring(1, id.length());
    	return Long.parseLong(id, 10);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	// Show loading
    	// Disable search
		Intent intent = getIntent();
	    Uri uri = intent.getData();
	    
	    if ( hasCode(uri) ) {
	    	// Add message "Logging in..."
	    	getToken(uri, new Callback<String>() {

				@Override
				public void failure(RetrofitError arg0) {					
				}

				@Override
				public void success(final String token, Response arg1) {
					mercadoLibreService.getUser(getClienIdFromToken(token), "OAuth " + token, new Callback<User>() {

						@Override
						public void failure(RetrofitError arg0) {
							System.out.println("");
							//TODO HANDLE OAUTH ERROR
						}

						@Override
						public void success(User arg0, Response arg1) {
							user = new AuthUser(token, arg0.getNickname());
							System.out.println("Logged in succesfully with " + user.getNickname() + ", token " + user.getToken());
							// Add logged in text
							// hide loading
							// enable search
						}
						
					});
					
				}
	    		
	    	});
	    } else {
	    	//hide loading
			//enable search
	    }   
    }

    private void getToken(Uri uri, final Callback<String> callback) {
    	mercadoLibreService.getToken(uri.getQueryParameter("code"), "http://subastaya.com", "OAuth " + APP_TOKEN,new Callback<TokenAuthorization>() {
			
			@Override
			public void failure(RetrofitError arg0) {
				System.out.println("failed oauth");
				//TODO Handle oauth service not working 
			}

			@Override
			public void success(TokenAuthorization arg0, Response arg1) {
				callback.success(arg0.getAccess_token(), null);
			}
			
		});
		
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    /** Called when the user clicks the Search button */
    public void search(View view) {
    	Intent intent = new Intent(this, AuctionActivity.class);
    	EditText editText = (EditText) findViewById(R.id.query);
    	String query = editText.getText().toString();   	
    	intent.putExtra(EXTRA_QUERY, query);  
    	startActivity(intent);
    }

}
