package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Non_mercado_pago_payment_method {

@Expose
private String id;
@Expose
private String description;
@Expose
private String type;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

}