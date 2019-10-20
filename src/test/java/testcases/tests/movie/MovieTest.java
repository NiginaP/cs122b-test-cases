package testcases.tests.movie;

import edu.uci.ics.cs122b.test.common.Result;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import org.junit.Test;
import testcases.model.hw3.request.ThumbnailRequestModel;
import testcases.model.hw3.response.ThumbnailResponseModel;
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
        Result expectedResult = Result.CALCULATION_SUCCESSFUL;
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult);
        String[] movie_ids = {"","",""};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }
}
