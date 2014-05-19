package com.example.subastaya.apimodels;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class ProductSearch {

@Expose
private String site_id;
@Expose
private String query;
@Expose
private Paging paging;
@Expose
private List<Result> results = new ArrayList<Result>();
@Expose
private List<Object> secondary_results = new ArrayList<Object>();
@Expose
private List<Object> related_results = new ArrayList<Object>();
@Expose
private Sort sort;
@Expose
private List<Available_sort> available_sorts = new ArrayList<Available_sort>();
@Expose
private List<Filter> filters = new ArrayList<Filter>();
@Expose
private List<Available_filter> available_filters = new ArrayList<Available_filter>();

public String getSite_id() {
return site_id;
}

public void setSite_id(String site_id) {
this.site_id = site_id;
}

public String getQuery() {
return query;
}

public void setQuery(String query) {
this.query = query;
}

public Paging getPaging() {
return paging;
}

public void setPaging(Paging paging) {
this.paging = paging;
}

public List<Result> getResults() {
return results;
}

public void setResults(List<Result> results) {
this.results = results;
}

public List<Object> getSecondary_results() {
return secondary_results;
}

public void setSecondary_results(List<Object> secondary_results) {
this.secondary_results = secondary_results;
}

public List<Object> getRelated_results() {
return related_results;
}

public void setRelated_results(List<Object> related_results) {
this.related_results = related_results;
}

public Sort getSort() {
return sort;
}

public void setSort(Sort sort) {
this.sort = sort;
}

public List<Available_sort> getAvailable_sorts() {
return available_sorts;
}

public void setAvailable_sorts(List<Available_sort> available_sorts) {
this.available_sorts = available_sorts;
}

public List<Filter> getFilters() {
return filters;
}

public void setFilters(List<Filter> filters) {
this.filters = filters;
}

public List<Available_filter> getAvailable_filters() {
return available_filters;
}

public void setAvailable_filters(List<Available_filter> available_filters) {
this.available_filters = available_filters;
}

}