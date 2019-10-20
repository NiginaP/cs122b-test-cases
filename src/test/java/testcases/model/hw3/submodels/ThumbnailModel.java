package testcases.model.hw3.submodels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThumbnailModel {

    @JsonProperty("movie_id")
    String movie_id;
    @JsonProperty("title")
    String title;
    @JsonProperty("backdrop_path")
    String backdrop_path;
    @JsonProperty("poster_path")
    String poster_path;

    public ThumbnailModel(String movie_id, String title, String backdrop_path, String poster_path) {
        this.movie_id = movie_id;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        ThumbnailModel that = (ThumbnailModel) o;
        if (this.movie_id.equals(that.movie_id)) {
            //we good
        } else
            return false;

        if (this.title.equals(that.title)) {
            //we good
        } else
            return false;
        if (this.backdrop_path.equals(that.backdrop_path))
        {
            //we good
        } else
            return false;

        //poster path not required, so if it's not nul then we can check. otherwise if it is null and the other one is not null then we hae an issue
        if (this.poster_path != null && this.poster_path.equals(that.poster_path))
        {
            // we good

        } else
        {

            return false;
        }


        //All parameters were equal. We good.
        return true;
    }
}
