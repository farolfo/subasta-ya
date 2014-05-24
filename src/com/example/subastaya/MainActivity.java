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

public class MainActivity extends ActionBarActivity {

    static final String EXTRA_QUERY = "QUERY";
	static final String EXTRA_INDEX = "INDEX";
	static final String EXTRA_MELI_URL = "MELI_URL";

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    
    @Override
	public void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
	    Intent intent = getIntent();
	    Uri uri = intent.getData();
	    
	    if ( hasCode(uri) ) {
	    	// add message "Logging in..."
	    	// Disable search
	    	getToken(uri);
	    }
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
    	/*Intent intent = new Intent(this, AuctionActivity.class);
    	EditText editText = (EditText) findViewById(R.id.query);
    	String query = editText.getText().toString();   	
    	intent.putExtra(EXTRA_QUERY, query);  
    	startActivity(intent);*/
    	
    	RestAdapter restAdapterOAuth = new RestAdapter.Builder().setEndpoint("http://auth.mercadolibre.com").build();
		MeliOAuth meliOAuthService = restAdapterOAuth.create(MeliOAuth.class);	
		final MainActivity self = this; 
		
		meliOAuthService.authorize("code", "6684097356045737", "http://subastaya.com", new Callback<String>() {

			public void processResponse(Response response) {
				System.out.println("Got authorizd with response status: " + response.getStatus());
				if ( response.getStatus() == 200 ) {
					Intent intent = new Intent(self, MeliOAuthWebActivity.class);
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

}
