package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Item {

@Expose
private String id;
@Expose
private String title;
@Expose
private String description;
@Expose
private Integer quantity;
@Expose
private Double unit_price;
@Expose
private String currency_id;
@Expose
private String picture_url;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getQuantity() {
return quantity;
}

public void setQuantity(Integer quantity) {
this.quantity = quantity;
}

public Double getUnit_price() {
return unit_price;
}

public void setUnit_price(Double unit_price) {
this.unit_price = unit_price;
}

public String getCurrency_id() {
return currency_id;
}

public void setCurrency_id(String currency_id) {
this.currency_id = currency_id;
}

public String getPicture_url() {
return picture_url;
}

public void setPicture_url(String picture_url) {
this.picture_url = picture_url;
}

}