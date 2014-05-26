package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Status {

@Expose
private String site_status;

public String getSite_status() {
return site_status;
}

public void setSite_status(String site_status) {
this.site_status = site_status;
}

}