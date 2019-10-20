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
    public void validThumbnailRequest()
    {
        ObjectMapper mapper = new ObjectMapper();
        Result expectedResult = Result.MOVIES_FOUND;
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult);
        String[] movie_ids = {"tt0007507","tt0018806","tt0019130"};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedModel, response.getEntity());
    }
}
