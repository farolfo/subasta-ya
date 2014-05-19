package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Result {

@Expose
private String id;
@Expose
private String site_id;
@Expose
private String title;
@Expose
private Object subtitle;
@Expose
private Seller seller;
@Expose
private Double price;
@Expose
private String currency_id;
@Expose
private Integer available_quantity;
@Expose
private Integer sold_quantity;
@Expose
private String buying_mode;
@Expose
private String listing_type_id;
@Expose
private String stop_time;
@Expose
private String condition;
@Expose
private String permalink;
@Expose
private String thumbnail;
@Expose
private Boolean accepts_mercadopago;
@Expose
private Installments installments;
@Expose
private Address address;
@Expose
private Shipping shipping;
@Expose
private Seller_address seller_address;
@Expose
private List<Object> attributes = new ArrayList<Object>();
@Expose
private Object original_price;
@Expose
private String category_id;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getSite_id() {
return site_id;
}

public void setSite_id(String site_id) {
this.site_id = site_id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Object getSubtitle() {
return subtitle;
}

public void setSubtitle(Object subtitle) {
this.subtitle = subtitle;
}

public Seller getSeller() {
return seller;
}

public void setSeller(Seller seller) {
this.seller = seller;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public String getCurrency_id() {
return currency_id;
}

public void setCurrency_id(String currency_id) {
this.currency_id = currency_id;
}

public Integer getAvailable_quantity() {
return available_quantity;
}

public void setAvailable_quantity(Integer available_quantity) {
this.available_quantity = available_quantity;
}

public Integer getSold_quantity() {
return sold_quantity;
}

public void setSold_quantity(Integer sold_quantity) {
this.sold_quantity = sold_quantity;
}

public String getBuying_mode() {
return buying_mode;
}

public void setBuying_mode(String buying_mode) {
this.buying_mode = buying_mode;
}

public String getListing_type_id() {
return listing_type_id;
}

public void setListing_type_id(String listing_type_id) {
this.listing_type_id = listing_type_id;
}

public String getStop_time() {
return stop_time;
}

public void setStop_time(String stop_time) {
this.stop_time = stop_time;
}

public String getCondition() {
return condition;
}

public void setCondition(String condition) {
this.condition = condition;
}

public String getPermalink() {
return permalink;
}

public void setPermalink(String permalink) {
this.permalink = permalink;
}

public String getThumbnail() {
return thumbnail;
}

public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

public Boolean getAccepts_mercadopago() {
return accepts_mercadopago;
}

public void setAccepts_mercadopago(Boolean accepts_mercadopago) {
this.accepts_mercadopago = accepts_mercadopago;
}

public Installments getInstallments() {
return installments;
}

public void setInstallments(Installments installments) {
this.installments = installments;
}

public Address getAddress() {
return address;
}

public void setAddress(Address address) {
this.address = address;
}

public Shipping getShipping() {
return shipping;
}

public void setShipping(Shipping shipping) {
this.shipping = shipping;
}

public Seller_address getSeller_address() {
return seller_address;
}

public void setSeller_address(Seller_address seller_address) {
this.seller_address = seller_address;
}

public List<Object> getAttributes() {
return attributes;
}

public void setAttributes(List<Object> attributes) {
this.attributes = attributes;
}

public Object getOriginal_price() {
return original_price;
}

public void setOriginal_price(Object original_price) {
this.original_price = original_price;
}

public String getCategory_id() {
return category_id;
}

public void setCategory_id(String category_id) {
this.category_id = category_id;
}

}

