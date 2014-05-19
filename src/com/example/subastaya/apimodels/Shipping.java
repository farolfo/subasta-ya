package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Shipping {

@Expose
private Boolean free_shipping;
@Expose
private String mode;

public Boolean getFree_shipping() {
return free_shipping;
}

public void setFree_shipping(Boolean free_shipping) {
this.free_shipping = free_shipping;
}

public String getMode() {
return mode;
}

public void setMode(String mode) {
this.mode = mode;
}

}