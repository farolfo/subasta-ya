package com.example.subastaya.apimodels;
import com.google.gson.annotations.Expose;

public class Seller {

@Expose
private Integer id;
@Expose
private Object power_seller_status;
@Expose
private Boolean car_dealer;
@Expose
private Boolean real_estate_agency;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Object getPower_seller_status() {
return power_seller_status;
}

public void setPower_seller_status(Object power_seller_status) {
this.power_seller_status = power_seller_status;
}

public Boolean getCar_dealer() {
return car_dealer;
}

public void setCar_dealer(Boolean car_dealer) {
this.car_dealer = car_dealer;
}

public Boolean getReal_estate_agency() {
return real_estate_agency;
}

public void setReal_estate_agency(Boolean real_estate_agency) {
this.real_estate_agency = real_estate_agency;
}

}