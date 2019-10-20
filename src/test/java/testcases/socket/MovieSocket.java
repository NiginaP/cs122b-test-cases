package testcases.socket;

import edu.uci.ics.cs122b.test.util.ServiceResponse;
import edu.uci.ics.cs122b.test.util.ServiceSocket;
import edu.uci.ics.cs122b.test.util.ServiceSocketFactory;
import testcases.model.hw2.request.LoginRequestModel;
import testcases.model.hw2.response.LoginResponseModel;
import testcases.model.hw3.request.ThumbnailRequestModel;
import testcases.model.hw3.response.ThumbnailResponseModel;

import java.net.URI;

public class MovieSocket {
    private final static String SCHEME;
    private final static String ADDRESS;
    private final static String PORT;
    private final static String API_PATH;

    private final static URI FULL_URI;

    private final static String MOVIES_SEARCH_EP = "/search";
    private final static String BROWSE_PHRASE_EP = "/browse/{phrase}";
    private final static String GET_MOVIE_EP = "/get/{movie_id}";
    private final static String THUMBNAIL_EP = "/thumbnail";
    private final static String PEOPLE_EP = "/people";
    private final static String PEOPLE_SEARCH_EP = "/people/search";
    private final static String GET_PEOPLE_EP = "/people/get/{person_id}";



    private final static ServiceSocketFactory SOCKET_FACTORY;

    static {
        SCHEME = "http://";
        ADDRESS = "127.0.0.1";
        PORT = ":12345";
        API_PATH = "/api/movies";

        FULL_URI = URI.create(SCHEME + ADDRESS + PORT + API_PATH);

        SOCKET_FACTORY = ServiceSocketFactory.createFactory(FULL_URI);
    }

    public static ServiceResponse<ThumbnailResponseModel> getThumbnail(String[] movie_ids)
    {
        ThumbnailRequestModel requestModel = new ThumbnailRequestModel(movie_ids);

        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(THUMBNAIL_EP);

        return serviceSocket.post(ThumbnailResponseModel.class, requestModel);
    }


}
