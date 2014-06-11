package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class ItemResponse {

@Expose
private String id;
@Expose
private String site_id;
@Expose
private String title;
@Expose
private Object subtitle;
@Expose
private Integer seller_id;
@Expose
private String category_id;
@Expose
private Object official_store_id;
@Expose
private Integer price;
@Expose
private Integer base_price;
@Expose
private Object original_price;
@Expose
private String currency_id;
@Expose
private Integer initial_quantity;
@Expose
private Integer available_quantity;
@Expose
private Integer sold_quantity;
@Expose
private String buying_mode;
@Expose
private String listing_type_id;
@Expose
private String start_time;
@Expose
private String stop_time;
@Expose
private String condition;
@Expose
private String permalink;
@Expose
private String thumbnail;
@Expose
private String secure_thumbnail;
@Expose
private List<Picture> pictures = new ArrayList<Picture>();
@Expose
private Object video_id;
@Expose
private List<Description> descriptions = new ArrayList<Description>();
@Expose
private Boolean accepts_mercadopago;
@Expose
private List<Non_mercado_pago_payment_method> non_mercado_pago_payment_methods = new ArrayList<Non_mercado_pago_payment_method>();
@Expose
private Shipping shipping;
@Expose
private Seller_address seller_address;
@Expose
private Object seller_contact;
@Expose
private Location location;
@Expose
private Geolocation geolocation;
@Expose
private List<Object> coverage_areas = new ArrayList<Object>();
@Expose
private List<Object> attributes = new ArrayList<Object>();
@Expose
private String listing_source;
@Expose
private List<Object> variations = new ArrayList<Object>();
@Expose
private String status;
@Expose
private List<Object> sub_status = new ArrayList<Object>();
@Expose
private List<String> tags = new ArrayList<String>();
@Expose
private Object warranty;
@Expose
private Object catalog_product_id;
@Expose
private String parent_item_id;
@Expose
private Object differential_pricing;
@Expose
private Boolean automatic_relist;
@Expose
private String date_created;
@Expose
private String last_updated;

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

public Integer getSeller_id() {
return seller_id;
}

public void setSeller_id(Integer seller_id) {
this.seller_id = seller_id;
}

public String getCategory_id() {
return category_id;
}

public void setCategory_id(String category_id) {
this.category_id = category_id;
}

public Object getOfficial_store_id() {
return official_store_id;
}

public void setOfficial_store_id(Object official_store_id) {
this.official_store_id = official_store_id;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public Integer getBase_price() {
return base_price;
}

public void setBase_price(Integer base_price) {
this.base_price = base_price;
}

public Object getOriginal_price() {
return original_price;
}

public void setOriginal_price(Object original_price) {
this.original_price = original_price;
}

public String getCurrency_id() {
return currency_id;
}

public void setCurrency_id(String currency_id) {
this.currency_id = currency_id;
}

public Integer getInitial_quantity() {
return initial_quantity;
}

public void setInitial_quantity(Integer initial_quantity) {
this.initial_quantity = initial_quantity;
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

public String getStart_time() {
return start_time;
}

public void setStart_time(String start_time) {
this.start_time = start_time;
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

public String getSecure_thumbnail() {
return secure_thumbnail;
}

public void setSecure_thumbnail(String secure_thumbnail) {
this.secure_thumbnail = secure_thumbnail;
}

public List<Picture> getPictures() {
return pictures;
}

public void setPictures(List<Picture> pictures) {
this.pictures = pictures;
}

public Object getVideo_id() {
return video_id;
}

public void setVideo_id(Object video_id) {
this.video_id = video_id;
}

public List<Description> getDescriptions() {
return descriptions;
}

public void setDescriptions(List<Description> descriptions) {
this.descriptions = descriptions;
}

public Boolean getAccepts_mercadopago() {
return accepts_mercadopago;
}

public void setAccepts_mercadopago(Boolean accepts_mercadopago) {
this.accepts_mercadopago = accepts_mercadopago;
}

public List<Non_mercado_pago_payment_method> getNon_mercado_pago_payment_methods() {
return non_mercado_pago_payment_methods;
}

public void setNon_mercado_pago_payment_methods(List<Non_mercado_pago_payment_method> non_mercado_pago_payment_methods) {
this.non_mercado_pago_payment_methods = non_mercado_pago_payment_methods;
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

public Object getSeller_contact() {
return seller_contact;
}

public void setSeller_contact(Object seller_contact) {
this.seller_contact = seller_contact;
}

public Location getLocation() {
return location;
}

public void setLocation(Location location) {
this.location = location;
}

public Geolocation getGeolocation() {
return geolocation;
}

public void setGeolocation(Geolocation geolocation) {
this.geolocation = geolocation;
}

public List<Object> getCoverage_areas() {
return coverage_areas;
}

public void setCoverage_areas(List<Object> coverage_areas) {
this.coverage_areas = coverage_areas;
}

public List<Object> getAttributes() {
return attributes;
}

public void setAttributes(List<Object> attributes) {
this.attributes = attributes;
}

public String getListing_source() {
return listing_source;
}

public void setListing_source(String listing_source) {
this.listing_source = listing_source;
}

public List<Object> getVariations() {
return variations;
}

public void setVariations(List<Object> variations) {
this.variations = variations;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public List<Object> getSub_status() {
return sub_status;
}

public void setSub_status(List<Object> sub_status) {
this.sub_status = sub_status;
}

public List<String> getTags() {
return tags;
}

public void setTags(List<String> tags) {
this.tags = tags;
}

public Object getWarranty() {
return warranty;
}

public void setWarranty(Object warranty) {
this.warranty = warranty;
}

public Object getCatalog_product_id() {
return catalog_product_id;
}

public void setCatalog_product_id(Object catalog_product_id) {
this.catalog_product_id = catalog_product_id;
}

public String getParent_item_id() {
return parent_item_id;
}

public void setParent_item_id(String parent_item_id) {
this.parent_item_id = parent_item_id;
}

public Object getDifferential_pricing() {
return differential_pricing;
}

public void setDifferential_pricing(Object differential_pricing) {
this.differential_pricing = differential_pricing;
}

public Boolean getAutomatic_relist() {
return automatic_relist;
}

public void setAutomatic_relist(Boolean automatic_relist) {
this.automatic_relist = automatic_relist;
}

public String getDate_created() {
return date_created;
}

public void setDate_created(String date_created) {
this.date_created = date_created;
}

public String getLast_updated() {
return last_updated;
}

public void setLast_updated(String last_updated) {
this.last_updated = last_updated;
}

}