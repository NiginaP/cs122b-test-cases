package testcases.model.hw3.submodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreModel {
    @JsonProperty("genre_id")
    Integer genre_id;

    @JsonProperty("name")
    String name;

    public GenreModel(@JsonProperty(value = "genre_id") Integer genre_id,
                      @JsonProperty(value = "name") String name) {
        this.genre_id = genre_id;
        this.name = name;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public String getName() {
        return name;
    }
}
