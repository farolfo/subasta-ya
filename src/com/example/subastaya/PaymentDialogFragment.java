package com.example.subastaya;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.example.subastaya.apimodels.CheckoutItems;
import com.example.subastaya.apimodels.CheckoutResponse;
import com.example.subastaya.apimodels.InnerCheckoutItem;

public class PaymentDialogFragment extends DialogFragment {
	
	private AlertDialog  dialog;
	private String token;
	private Product product;
	
	public void checkoutOrder() {
		
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.mercadolibre.com").build();
		MercadoLibreAPI mercadoLibreService = restAdapter.create(MercadoLibreAPI.class);

		InnerCheckoutItem item = new InnerCheckoutItem();
		item.setTitle(product.getTitle());
		item.setUnit_price(product.getPrice());
		item.setQuantity(1);
		item.setCurrency_id("ARS");
		
		CheckoutItems req = new CheckoutItems();
		req.getItems().add(item);
		
		mercadoLibreService.checkout(req, token, new Callback<CheckoutResponse>() {

			@Override
			public void failure(RetrofitError arg0) {
				System.out.println("Fail checkout");			
			}

			@Override
			public void success(CheckoutResponse arg0, Response arg1) {
				System.out.println("Checkout succeded");							
			}
			
		});
	}
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
        token = getArguments().getString(OfferFormFragment.EXTRA_USER_TOKEN);
        product = (Product) getArguments().getSerializable(OfferFormFragment.SELECTED_PRODUCT);
            	
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.confirm_payment_title);
        builder.setMessage(R.string.confirm_payment_text)
        	.setPositiveButton(R.string.confirm_offer, new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
        			System.out.println("confirmada la compra");
                	checkoutOrder();
            	}
        	})
        	.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
        			// User cancelled the dialog, do nothing
        		}
        	});

        this.dialog = builder.create();
        return dialog;
    }
}