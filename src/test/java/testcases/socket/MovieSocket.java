package testcases.socket;

import edu.uci.ics.cs122b.test.util.ServiceResponse;
import edu.uci.ics.cs122b.test.util.ServiceSocket;
import edu.uci.ics.cs122b.test.util.ServiceSocketFactory;
import testcases.model.hw2.request.LoginRequestModel;
import testcases.model.hw2.response.LoginResponseModel;
import testcases.model.hw3.request.BrowseKeywordRequestModel;
import testcases.model.hw3.request.ThumbnailRequestModel;
import testcases.model.hw3.response.BrowseKeywordResponseModel;
import testcases.model.hw3.response.MovieSearchResponseModel;
import testcases.model.hw3.response.ThumbnailResponseModel;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.net.URI;
import java.util.Hashtable;

public class MovieSocket {
    private final static String SCHEME;
    private final static String ADDRESS;
    private final static String PORT;
    private final static String API_PATH;

    private final static URI FULL_URI;

    private final static String MOVIES_SEARCH_EP = "/search";
    private final static String BROWSE_PHRASE_EP = "/browse/";
    private final static String GET_MOVIE_EP = "/get/";
    private final static String THUMBNAIL_EP = "/thumbnail";
    private final static String PEOPLE_EP = "/people";
    private final static String PEOPLE_SEARCH_EP = "/people/search";
    private final static String GET_PEOPLE_EP = "/people/get/";



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

    public static ServiceResponse<BrowseKeywordResponseModel> getBrowseByKeyword(MultivaluedHashMap<String, Object> headers, MultivaluedHashMap<String, Object> query, String keywords)
    {
        BrowseKeywordRequestModel requestModel = new BrowseKeywordRequestModel();

        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(BROWSE_PHRASE_EP + keywords);

        serviceSocket = serviceSocket.headers(headers);
        serviceSocket = serviceSocket.queries(query);
        return serviceSocket.get(BrowseKeywordResponseModel.class);
    }

    public static MultivaluedHashMap<String, Object> getHeader(String email, String session_id){
        MultivaluedHashMap<String, Object> header = new MultivaluedHashMap<>();
        header.putSingle("email", email);
        header.putSingle("session_id", session_id);//"bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123123");

        return header;
    }

    public static MultivaluedHashMap<String, Object> getQueries(String title,
                                                                Integer year,
                                                                String director,
                                                                String genre,
                                                                Boolean hidden,
                                                                Integer limit,
                                                                Integer offset,
                                                                String orderby,
                                                                String direction){
        MultivaluedHashMap<String, Object> queries = new MultivaluedHashMap<>();
        queries.putSingle("title", title);
        queries.putSingle("year", year);
        queries.putSingle("director", director);
        queries.putSingle("genre", genre);
        queries.putSingle("hidden", hidden);
        queries.putSingle("limit", limit);
        queries.putSingle("offset", offset);
        queries.putSingle("orderby", orderby);
        queries.putSingle("direction", direction);

        return queries;
    }

    public static ServiceResponse<MovieSearchResponseModel> getSearch(String email,
                                                                      String session_id,
                                                                      String title,
                                                                      Integer year,
                                                                      String director,
                                                                      String genre,
                                                                      Boolean hidden,
                                                                      Integer limit,
                                                                      Integer offset,
                                                                      String orderby,
                                                                      String direction){
        MultivaluedHashMap<String, Object> header = getHeader(email,session_id);
        MultivaluedHashMap<String, Object> queries = getQueries(title, year, director, genre, hidden, limit, offset, orderby, direction);
        //System.out.println(header.toString());
        //System.out.println(queries.toString());

        ServiceSocket serviceSocket = SOCKET_FACTORY.createSocket(MOVIES_SEARCH_EP);//.headers(header).queries(queries);
        serviceSocket = serviceSocket.headers(header);
        serviceSocket = serviceSocket.queries(queries);

        return serviceSocket.get(MovieSearchResponseModel.class);
    }
}
