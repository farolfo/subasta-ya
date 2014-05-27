package com.example.subastaya;

import java.util.LinkedList;
import java.util.List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ArrayAdapter;

public class PaymentDialogFragment extends DialogFragment {
	
	private AlertDialog  dialog;
	private String token;
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
        token = getArguments().getString(OfferFormFragment.EXTRA_USER_TOKEN);
        
        List<String> items = new LinkedList<String>();
        items.add("Metodo 1");
        items.add("Metodo 2");
        items.add("Metodo 3");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item, items);
    	
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.select_payment_method);
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
            // The 'which' argument contains the index position
            // of the selected item
        	}
        });

        System.out.println("In dialog with token " + token);
        // 3. Get the AlertDialog from create()
        this.dialog = builder.create();
        return dialog;
    }
}