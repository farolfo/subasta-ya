package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Value {

@Expose
private String id;
@Expose
private String name;
@Expose
private List<Path_from_root> path_from_root = new ArrayList<Path_from_root>();

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

public List<Path_from_root> getPath_from_root() {
return path_from_root;
}

public void setPath_from_root(List<Path_from_root> path_from_root) {
this.path_from_root = path_from_root;
}

}