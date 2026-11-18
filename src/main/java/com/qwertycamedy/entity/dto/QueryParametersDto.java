package com.qwertycamedy.entity.dto;

public class QueryParametersDto {
    private int id;
    private String filter;

    public QueryParametersDto() {
    }

    public QueryParametersDto(int id, String filter) {
        this.id = id;
        this.filter = filter;
    }

    public int getId() {
        return id;
    }

    public String getFilter() {
        return filter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String homeRequestString(String filter) {
        return "redirect:/home" + (filter != null && !filter.isBlank()
                ? "?filter=" + filter
                : "");
    }
}
