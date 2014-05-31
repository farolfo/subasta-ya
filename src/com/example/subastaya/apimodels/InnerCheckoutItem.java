package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class InnerCheckoutItem {

@Expose
private String title;
@Expose
private Integer quantity;
@Expose
private String currency_id;
@Expose
private Double unit_price;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Integer getQuantity() {
return quantity;
}

public void setQuantity(Integer quantity) {
this.quantity = quantity;
}

public String getCurrency_id() {
return currency_id;
}

public void setCurrency_id(String currency_id) {
this.currency_id = currency_id;
}

public Double getUnit_price() {
return unit_price;
}

public void setUnit_price(Double unit_price) {
this.unit_price = unit_price;
}

}