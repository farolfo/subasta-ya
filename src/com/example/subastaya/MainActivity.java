package com.example.subastaya;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.subastaya.apimodels.TokenAuthorization;
import com.example.subastaya.apimodels.User;

public class MainActivity extends ActionBarActivity {

    static final String EXTRA_QUERY = "QUERY";
	static final String EXTRA_INDEX = "INDEX";
	static final String APP_TOKEN = "uk3qZb6iSmSEd75paPiYVCYsD8mHbFPD";
	static final String EXTRA_USER = "USER";
	
	MercadoLibreAPI mercadoLibreService;
	AuthUser user = null;
	
	LoadingFragment loadingFragment;
	
	private boolean searchEnabled = false;
	private EditText queryEditText;
	private Button searchButton;
	private TextView loggedInMessage;

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
    
    public void showLoggedInLabel() {
    	this.loggedInMessage.setText("Usuario " + user.getNickname() + " loggeado");
    	this.loggedInMessage.setVisibility(View.VISIBLE);
    }
    
    public void hideActions() {
    	this.queryEditText.setVisibility(View.GONE);
    	this.searchButton.setVisibility(View.GONE);
    }
    
    public void showActions() {
    	this.queryEditText.setVisibility(View.VISIBLE);
    	this.searchButton.setVisibility(View.VISIBLE);
    }
    
    public void disableActions() {
    	this.searchEnabled = false;
    }
    
    public void enableActions() {
    	this.searchEnabled = true;
    }
    
    public void showLoading() {
    	FragmentManager fm = getSupportFragmentManager();    	
    	fm.beginTransaction()
    	          .show(loadingFragment)
    	          .commit();
    }
    
    public void hideLoading() {
    	FragmentManager fm = getSupportFragmentManager();    	
    	fm.beginTransaction()
    	          .hide(loadingFragment)
    	          .commit();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	if ( user != null ) {
    		return;
    	}
    	
    	hideActions();
    	disableActions();
    	showLoading();
    	
		Intent intent = getIntent();
	    Uri uri = intent.getData();
	    
	    if ( hasCode(uri) ) {
	    	loadingFragment.showMessageLoggingIn();
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
							showLoggedInLabel();
							hideLoading();
							showActions();
							enableActions();
						}
						
					});
					
				}
	    		
	    	});
	    } else {
	    	hideLoading();
			showActions();
			enableActions();
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
			//TODO DELETEME APP_USR-6684097356045737-052621-2070e51da0c155d8d7dd87947658da0f__B_H__-159535818
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
    
    @Override
    public void onPostCreate(Bundle bundle) {
    	super.onPostCreate(bundle);
    	
    	this.loadingFragment = (LoadingFragment) getSupportFragmentManager().findFragmentById(R.id.loading_fragment);    
    	this.queryEditText = (EditText) findViewById(R.id.query);
    	this.searchButton = (Button) findViewById(R.id.search);
    	this.loggedInMessage = (TextView) findViewById(R.id.loggedIn);
    }
    
    /** Called when the user clicks the Search button */
    public void search(View view) {
    	if ( searchEnabled ) {
	    	Intent intent = new Intent(this, AuctionActivity.class);
	    	String query = this.queryEditText.getText().toString(); 
	    	if ( query.length() != 0  ) {
		    	intent.putExtra(EXTRA_QUERY, query);  
		    	intent.putExtra(EXTRA_USER, user);  
		    	startActivity(intent);
	    	}
    	}
    }

}
