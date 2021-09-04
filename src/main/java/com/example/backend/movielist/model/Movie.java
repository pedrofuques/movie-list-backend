package com.example.backend.movielist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("Title")
    public String title;

    @JsonProperty("Year")
    public String year;

    @JsonProperty("Rated")
    public String rated;

    @JsonProperty("Released")
    public String released;

    @JsonProperty("Runtime")
    public String runtime;

    @JsonProperty("Genre")
    public String genre;

    @JsonProperty("Director")
    public String director;

    @JsonProperty("Writer")
    public String writer;

    @JsonProperty("Actors")
    public String actors;

    @JsonProperty("Plot")
    public String plot;

    @JsonProperty("Language")
    public String language;

    @JsonProperty("Country")
    public String country;

    @JsonProperty("Awards")
    public String awards;

    @JsonProperty("Poster")
    public String poster;

    @JsonProperty("Metascore")
    public String metascore;

    public String imdbRating;

    public String imdbVotes;

    public String imdbID;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("DVD")
    public String dVD;

    @JsonProperty("BoxOffice")
    public String boxOffice;

    @JsonProperty("Production")
    public String production;

    @JsonProperty("Website")
    public String website;

    @JsonProperty("Response")
    public String response;

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

    public String getRated() {
        return this.rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return this.released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return this.runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return this.actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return this.plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return this.awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMetascore() {
        return this.metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return this.imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return this.imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
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

    public String getDVD() {
        return this.dVD;
    }

    public void setDVD(String dVD) {
        this.dVD = dVD;
    }

    public String getBoxOffice() {
        return this.boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return this.production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
