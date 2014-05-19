package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Available_filter {

@Expose
private String id;
@Expose
private String name;
@Expose
private String type;
@Expose
private List<Value_> values = new ArrayList<Value_>();

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

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public List<Value_> getValues() {
return values;
}

public void setValues(List<Value_> values) {
this.values = values;
}

}