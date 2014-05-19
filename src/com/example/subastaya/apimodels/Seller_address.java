package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Seller_address {

@Expose
private Integer id;
@Expose
private String comment;
@Expose
private String address_line;
@Expose
private String zip_code;
@Expose
private Country country;
@Expose
private State state;
@Expose
private City city;
@Expose
private String latitude;
@Expose
private String longitude;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getComment() {
return comment;
}

public void setComment(String comment) {
this.comment = comment;
}

public String getAddress_line() {
return address_line;
}

public void setAddress_line(String address_line) {
this.address_line = address_line;
}

public String getZip_code() {
return zip_code;
}

public void setZip_code(String zip_code) {
this.zip_code = zip_code;
}

public Country getCountry() {
return country;
}

public void setCountry(Country country) {
this.country = country;
}

public State getState() {
return state;
}

public void setState(State state) {
this.state = state;
}

public City getCity() {
return city;
}

public void setCity(City city) {
this.city = city;
}

public String getLatitude() {
return latitude;
}

public void setLatitude(String latitude) {
this.latitude = latitude;
}

public String getLongitude() {
return longitude;
}

public void setLongitude(String longitude) {
this.longitude = longitude;
}

}