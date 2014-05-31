package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Back_urls {

@Expose
private String success;
@Expose
private String failure;
@Expose
private String pending;

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public String getFailure() {
return failure;
}

public void setFailure(String failure) {
this.failure = failure;
}

public String getPending() {
return pending;
}

public void setPending(String pending) {
this.pending = pending;
}

}