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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.subastaya.apimodels.CheckoutItems;
import com.example.subastaya.apimodels.InnerCheckoutItem;
import com.example.subastaya.apimodels.OrderResponse;

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
		
		mercadoLibreService.createOrder(new OrderItems(), token, new Callback<OrderResponse>() {

			@Override
			public void failure(RetrofitError arg0) {
				System.out.println("Fail checkout");			
			}

			@Override
			public void success(OrderResponse arg0, Response arg1) {
				System.out.println("Checkout succeded");							
			}
			
		});
	}
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
        token = getArguments().getString(OfferFormFragment.EXTRA_USER_TOKEN);
        product = (Product) getArguments().getSerializable(OfferFormFragment.SELECTED_PRODUCT);
        System.out.println("token is !!! " + token);
        
        LayoutInflater factory = LayoutInflater.from(this.getActivity());
        final View textEntryView = factory.inflate(R.layout.confirm_payment_dialog, null);   	
            	
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.confirm_payment_title);
        
        builder.setView(textEntryView);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	        public void onClick(DialogInterface dialog, int whichButton) {  
	            EditText offeredPriceET = (EditText) textEntryView.findViewById(R.id.offered_price);
	            String offeredPrice = offeredPriceET.getText().toString();
	            System.out.println("The user bought the thing for $" + offeredPrice);
	            return;                  
	        }  
         }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int id) {
        			// User cancelled the dialog, do nothing
        		}
        	});

        this.dialog = builder.create();
        return dialog;
    }
}