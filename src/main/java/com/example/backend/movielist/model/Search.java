package com.example.backend.movielist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    private String imdbID;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Poster")
    private String poster;

    private Boolean favouriteMovie;

    private Long idToRemove;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return this.imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Boolean getFavouriteMovie() {
        return this.favouriteMovie;
    }

    public void setFavouriteMovie(Boolean favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public Long getIdToRemove() {
        return this.idToRemove;
    }

    public void setIdToRemove(Long idToRemove) {
        this.idToRemove = idToRemove;
    }
}
