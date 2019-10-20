package testcases.model.hw3.submodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieModel {

    @JsonProperty("movie_id")
    String movie_id;
    @JsonProperty("title")
    String title;
    @JsonProperty("year")
    Integer year;
    @JsonProperty("director")
    String director;
    @JsonProperty("rating")
    Float rating;
    @JsonProperty("num_votes")
    Integer num_votes;
    @JsonProperty("budget")
    String budget;
    @JsonProperty("revenue")
    String revenue;
    @JsonProperty("overview")
    String overview;
    @JsonProperty("backdrop_path")
    String backdrop_path;
    @JsonProperty("poster_path")
    String poster_path;
    @JsonProperty("hidden")
    Boolean hidden;

    @JsonProperty("genres")
    GenreModel[] genres;
    @JsonProperty("people")
    PeopleModel[] people;
}
