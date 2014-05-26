package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Transactions {

@Expose
private String period;
@Expose
private Integer total;
@Expose
private Integer completed;
@Expose
private Integer canceled;
@Expose
private Ratings ratings;

public String getPeriod() {
return period;
}

public void setPeriod(String period) {
this.period = period;
}

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getCompleted() {
return completed;
}

public void setCompleted(Integer completed) {
this.completed = completed;
}

public Integer getCanceled() {
return canceled;
}

public void setCanceled(Integer canceled) {
this.canceled = canceled;
}

public Ratings getRatings() {
return ratings;
}

public void setRatings(Ratings ratings) {
this.ratings = ratings;
}

}