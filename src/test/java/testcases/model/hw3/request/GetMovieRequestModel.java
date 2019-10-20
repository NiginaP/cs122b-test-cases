package testcases.model.hw3.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMovieRequestModel {

    @JsonProperty("movie_id")
    String movie_id;

}
