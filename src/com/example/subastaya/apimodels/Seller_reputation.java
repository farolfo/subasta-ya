package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Seller_reputation {

@Expose
private Object level_id;
@Expose
private Object power_seller_status;
@Expose
private Transactions transactions;

public Object getLevel_id() {
return level_id;
}

public void setLevel_id(Object level_id) {
this.level_id = level_id;
}

public Object getPower_seller_status() {
return power_seller_status;
}

public void setPower_seller_status(Object power_seller_status) {
this.power_seller_status = power_seller_status;
}

public Transactions getTransactions() {
return transactions;
}

public void setTransactions(Transactions transactions) {
this.transactions = transactions;
}

}