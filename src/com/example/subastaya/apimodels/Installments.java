package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Installments {

@Expose
private Integer quantity;
@Expose
private Double amount;
@Expose
private String currency_id;

public Integer getQuantity() {
return quantity;
}

public void setQuantity(Integer quantity) {
this.quantity = quantity;
}

public Double getAmount() {
return amount;
}

public void setAmount(Double amount) {
this.amount = amount;
}

public String getCurrency_id() {
return currency_id;
}

public void setCurrency_id(String currency_id) {
this.currency_id = currency_id;
}

}