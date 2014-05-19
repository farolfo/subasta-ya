package com.example.subastaya.apimodels;

import com.google.gson.annotations.Expose;

public class Paging {

@Expose
private Integer total;
@Expose
private Integer offset;
@Expose
private Integer limit;

public Integer getTotal() {
return total;
}

public void setTotal(Integer total) {
this.total = total;
}

public Integer getOffset() {
return offset;
}

public void setOffset(Integer offset) {
this.offset = offset;
}

public Integer getLimit() {
return limit;
}

public void setLimit(Integer limit) {
this.limit = limit;
}

}