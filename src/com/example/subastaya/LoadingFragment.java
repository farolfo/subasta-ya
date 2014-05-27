package com.example.subastaya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoadingFragment extends Fragment {


	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	    
        return inflater.inflate(R.layout.loading_view, container, false);
    }

	public void showMessageLoggingIn() {
		TextView loggingMessage = (TextView) getActivity().findViewById(R.id.loggingInMessage);
		loggingMessage.setVisibility(View.VISIBLE);
	}
	
}