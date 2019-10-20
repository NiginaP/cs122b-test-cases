package testcases.tests.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uci.ics.cs122b.test.common.Result;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import org.junit.Test;
import testcases.model.hw3.request.ThumbnailRequestModel;
import testcases.model.hw3.response.ThumbnailResponseModel;
import testcases.model.hw3.submodels.ThumbnailModel;
import testcases.socket.IdmSocket;
import testcases.socket.MovieSocket;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    //*********************************************
    //
    //                Thumbnail Tests
    //
    //*********************************************

    @Test
    public  void validThumbnailRequest()
    {
        ObjectMapper mapper = new ObjectMapper();
        Result expectedResult = Result.MOVIES_FOUND;
        ThumbnailModel[] thumbnails = {new ThumbnailModel("tt0007507", "The Vagabond", "/7TjAXT67ubvI0RInvX1WnnJ5m8v.jpg", "/idwJD2LtlHgAAvuZQllEcULQXWc.jpg"),
                                        new ThumbnailModel("tt0018806","The Crowd","/l1VH0FCTMaeduwO1k78wQ1xBBm3.jpg","/iyGK2tzYaQA87UDMj3VxjoXlT9c.jpg"),
                                        new ThumbnailModel("tt0019130","The Man Who Laughs","/rZgbJwwLgzxDD1SAdnLw78uDkYg.jpg","/8eVqvmUFRPp7nXrxVVcVYJ5pfbN.jpg")};
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult, thumbnails);
        String[] movie_ids = {"tt0007507","tt0018806","tt0019130"};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedModel, response.getEntity());
    }


}
