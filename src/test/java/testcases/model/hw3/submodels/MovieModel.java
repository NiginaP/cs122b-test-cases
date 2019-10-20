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
    PeopleMovieModel[] people;

    public MovieModel(String movie_id, String title, Integer year, String director, Float rating, Integer num_votes, String budget, String revenue, String overview, String backdrop_path, String poster_path, Boolean hidden, GenreModel[] genres, PeopleMovieModel[] people) {
        this.movie_id = movie_id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.num_votes = num_votes;
        this.budget = budget;
        this.revenue = revenue;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.hidden = hidden;
        this.genres = genres;
        this.people = people;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Float getRating() {
        return rating;
    }

    public Integer getNum_votes() {
        return num_votes;
    }

    public String getBudget() {
        return budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public GenreModel[] getGenres() {
        return genres;
    }

    public PeopleMovieModel[] getPeople() {
        return people;
    }
}
