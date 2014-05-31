package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Payer {

@Expose
private String email;
@Expose
private String name;
@Expose
private String surname;

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSurname() {
return surname;
}

public void setSurname(String surname) {
this.surname = surname;
}

}