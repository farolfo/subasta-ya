package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Value_ {

@Expose
private String id;
@Expose
private String name;
@Expose
private Integer results;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getResults() {
return results;
}

public void setResults(Integer results) {
this.results = results;
}

}