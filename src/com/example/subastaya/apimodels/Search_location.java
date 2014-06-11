package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Search_location {

@Expose
private Neighborhood neighborhood;
@Expose
private City city;
@Expose
private State state;

public Neighborhood getNeighborhood() {
return neighborhood;
}

public void setNeighborhood(Neighborhood neighborhood) {
this.neighborhood = neighborhood;
}

public City getCity() {
return city;
}

public void setCity(City city) {
this.city = city;
}

public State getState() {
return state;
}

public void setState(State state) {
this.state = state;
}

}