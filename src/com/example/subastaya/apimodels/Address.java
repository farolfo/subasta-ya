package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Address {

@Expose
private String state_id;
@Expose
private String state_name;
@Expose
private String city_id;
@Expose
private String city_name;

public String getState_id() {
return state_id;
}

public void setState_id(String state_id) {
this.state_id = state_id;
}

public String getState_name() {
return state_name;
}

public void setState_name(String state_name) {
this.state_name = state_name;
}

public String getCity_id() {
return city_id;
}

public void setCity_id(String city_id) {
this.city_id = city_id;
}

public String getCity_name() {
return city_name;
}

public void setCity_name(String city_name) {
this.city_name = city_name;
}

}