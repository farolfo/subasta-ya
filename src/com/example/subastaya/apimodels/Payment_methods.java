package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Payment_methods {

@Expose
private List<Excluded_payment_method> excluded_payment_methods = new ArrayList<Excluded_payment_method>();
@Expose
private List<Excluded_payment_type> excluded_payment_types = new ArrayList<Excluded_payment_type>();
@Expose
private Integer installments;

public List<Excluded_payment_method> getExcluded_payment_methods() {
return excluded_payment_methods;
}

public void setExcluded_payment_methods(List<Excluded_payment_method> excluded_payment_methods) {
this.excluded_payment_methods = excluded_payment_methods;
}

public List<Excluded_payment_type> getExcluded_payment_types() {
return excluded_payment_types;
}

public void setExcluded_payment_types(List<Excluded_payment_type> excluded_payment_types) {
this.excluded_payment_types = excluded_payment_types;
}

public Integer getInstallments() {
return installments;
}

public void setInstallments(Integer installments) {
this.installments = installments;
}

}
