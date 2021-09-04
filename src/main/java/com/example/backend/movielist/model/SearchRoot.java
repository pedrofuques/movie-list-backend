package com.example.backend.movielist.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRoot {
    @JsonProperty("Search")
    public List<Search> search;

    public String totalResults;

    @JsonProperty("Response")
    public String response;

    public List<Search> getSearch() {
        return this.search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return this.totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
