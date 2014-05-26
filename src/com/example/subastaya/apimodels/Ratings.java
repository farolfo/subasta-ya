package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Ratings {

@Expose
private Integer positive;
@Expose
private Integer negative;
@Expose
private Integer neutral;

public Integer getPositive() {
return positive;
}

public void setPositive(Integer positive) {
this.positive = positive;
}

public Integer getNegative() {
return negative;
}

public void setNegative(Integer negative) {
this.negative = negative;
}

public Integer getNeutral() {
return neutral;
}

public void setNeutral(Integer neutral) {
this.neutral = neutral;
}

}