package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class User {

@Expose
private Integer id;
@Expose
private String nickname;
@Expose
private String registration_date;
@Expose
private String country_id;
@Expose
private Address address;
@Expose
private String user_type;
@Expose
private List<String> tags = new ArrayList<String>();
@Expose
private Object logo;
@Expose
private Integer points;
@Expose
private String site_id;
@Expose
private String permalink;
@Expose
private Seller_reputation seller_reputation;
@Expose
private Status status;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getNickname() {
return nickname;
}

public void setNickname(String nickname) {
this.nickname = nickname;
}

public String getRegistration_date() {
return registration_date;
}

public void setRegistration_date(String registration_date) {
this.registration_date = registration_date;
}

public String getCountry_id() {
return country_id;
}

public void setCountry_id(String country_id) {
this.country_id = country_id;
}

public Address getAddress() {
return address;
}

public void setAddress(Address address) {
this.address = address;
}

public String getUser_type() {
return user_type;
}

public void setUser_type(String user_type) {
this.user_type = user_type;
}

public List<String> getTags() {
return tags;
}

public void setTags(List<String> tags) {
this.tags = tags;
}

public Object getLogo() {
return logo;
}

public void setLogo(Object logo) {
this.logo = logo;
}

public Integer getPoints() {
return points;
}

public void setPoints(Integer points) {
this.points = points;
}

public String getSite_id() {
return site_id;
}

public void setSite_id(String site_id) {
this.site_id = site_id;
}

public String getPermalink() {
return permalink;
}

public void setPermalink(String permalink) {
this.permalink = permalink;
}

public Seller_reputation getSeller_reputation() {
return seller_reputation;
}

public void setSeller_reputation(Seller_reputation seller_reputation) {
this.seller_reputation = seller_reputation;
}

public Status getStatus() {
return status;
}

public void setStatus(Status status) {
this.status = status;
}

}