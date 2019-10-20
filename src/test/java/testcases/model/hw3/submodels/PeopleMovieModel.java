package testcases.model.hw3.submodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleMovieModel {

    @JsonProperty("person_id")
    Integer person_id;

    @JsonProperty("name")
    String name;

    public PeopleMovieModel(Integer person_id, String name) {
        this.person_id = person_id;
        this.name = name;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public String getName() {
        return name;
    }
}
