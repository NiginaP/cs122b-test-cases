package testcases.tests.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uci.ics.cs122b.test.common.Result;
import edu.uci.ics.cs122b.test.util.ServiceResponse;
import org.junit.Test;
import testcases.model.hw3.request.ThumbnailRequestModel;
import testcases.model.hw3.response.BrowseKeywordResponseModel;
import testcases.model.hw3.response.ThumbnailResponseModel;
import testcases.model.hw3.submodels.BrowseMovieModel;
import testcases.model.hw3.submodels.ThumbnailModel;
import testcases.socket.IdmSocket;
import testcases.socket.MovieSocket;

import javax.ws.rs.core.MultivaluedHashMap;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    /*
    *** Regex used to trim the json param name
    *  ["]([a-z]|[A-Z]|[_])+["][:] (Simply find and replace and it will trim down almost all white space.)
    * use:
    *       find: '["]([a-z]|[A-Z]|[_])+["][:]'
    *       replace ''
    * e.g.
    * {
    *   "example param": hiya
    *  }
    * Becomes
    * {
    *       hiya
    * }
    *
    * Regex used to trim white space
    *  ,\s+] - Trim down almost all white space
    *   use: find ',\s+'
    *       replace ','
    *
    * e.g.
    * {
    *   "param1": "hi sir",
    *   "param2": 1234,
    *   "param3": "sup dude"
    * }
    * {
    *   "param1": "hi sir","param2": 1234,"param3": "sup dude"
    * }
     */

    //*********************************************
    //
    //                Thumbnail Tests
    //
    //*********************************************

    @Test
    public  void validThumbnailRequestThreeMovies()
    {
        Result expectedResult = Result.MOVIES_FOUND;
        ThumbnailModel[] thumbnails = {new ThumbnailModel("tt0007507", "The Vagabond", "/7TjAXT67ubvI0RInvX1WnnJ5m8v.jpg", "/idwJD2LtlHgAAvuZQllEcULQXWc.jpg"),
                                        new ThumbnailModel("tt0018806","The Crowd","/l1VH0FCTMaeduwO1k78wQ1xBBm3.jpg","/iyGK2tzYaQA87UDMj3VxjoXlT9c.jpg"),
                                        new ThumbnailModel("tt0019130","The Man Who Laughs","/rZgbJwwLgzxDD1SAdnLw78uDkYg.jpg","/8eVqvmUFRPp7nXrxVVcVYJ5pfbN.jpg")};
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult, thumbnails);
        String[] movie_ids = {"tt0007507","tt0018806","tt0019130"};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void validThumbnailRequestOneMovie()
    {
        Result expectedResult = Result.MOVIES_FOUND;
        ThumbnailModel[] thumbnails = {new ThumbnailModel("tt0037248", "The Scarlet Claw", "/fGQLfhUo3Gog5WVQQceZKjeXYnA.jpg", "/bxSNJPcF8dd1au7maOatScDPkEI.jpg")};
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult, thumbnails);
        String[] movie_ids = {"tt0037248"};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void validThumbnailRequestOneMovieFound()
    {
        Result expectedResult = Result.MOVIES_FOUND;
        ThumbnailModel[] thumbnails = {new ThumbnailModel("tt0037303", "The Spider Woman", "/meOq8Q3YVgMRh4Meg7iZZmwGW1s.jpg", "/7SasjHkOK7QpqmRrOi0nqFcMLzf.jpg"),
                                        new ThumbnailModel("tt0046303", "Shane", "/w7nnWraudThsdq6V38nMAELh7UR.jpg", "/fPCjyrZK1evjm2vocMpsHZ0xFOa.jpg")};
        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult, thumbnails);
        String[] movie_ids = {"tt0037303", "ii123213", "kk123123", "asd12323", "tt0046303"};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void validThumbnailRequestMovieListEmpty()
    {
        Result expectedResult = Result.MOVIES_NOT_FOUND;

        ThumbnailResponseModel expectedModel = new ThumbnailResponseModel(expectedResult);
        String[] movie_ids = {};

        ServiceResponse<ThumbnailResponseModel> response = MovieSocket.getThumbnail(movie_ids);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    //TODO
    //Need poster path

    //*********************************************
    //
    //                BrowseKeyword Tests
    //
    //*********************************************

    @Test
    public  void validBrowseKeywordDefaultQueryParams()
    {
        String email = "existing3@existing.com";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "sequel,alien invasion";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {
                new BrowseMovieModel("tt4154796",
                "Avengers: Endgame", 2019, "Anthony Russo", 8.6f,
                "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg", "/or06FN3Dka5tukK1e9sl16pB3iy.jpg", false),
                new BrowseMovieModel("tt0060278",
                        "Daleks' Invasion Earth: 2150 A.D.", 1966, "Gordon Flemyng",6.3f,
                        "/mmKJXRxmb0BkYvKaXqvSDByKQfw.jpg","/dzBpFVOgxwd8G95aOFQxd3PKcdz.jpg",
                        false),
                new BrowseMovieModel("tt1935302",
                        "Monsters: Dark Continent",2014,"Tom Green", 4.4f,
                        "/jAEBOMDIK11njs2jWPggn1xTNWi.jpg","/ssnnmRnJVxCFefvxvSQH62RQV04.jpg", false)
        };
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());

    }

    @Test
    public  void validBrowseKeywordQueryParamsDesc()
    {
        String email = "existing3@existing.com";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "sequel,alien invasion";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {
                new BrowseMovieModel("tt1935302", "Monsters: Dark Continent",2014,"Tom Green", 4.4f, "/jAEBOMDIK11njs2jWPggn1xTNWi.jpg","/ssnnmRnJVxCFefvxvSQH62RQV04.jpg", false),
                new BrowseMovieModel("tt0060278", "Daleks' Invasion Earth: 2150 A.D.", 1966, "Gordon Flemyng",6.3f, "/mmKJXRxmb0BkYvKaXqvSDByKQfw.jpg","/dzBpFVOgxwd8G95aOFQxd3PKcdz.jpg", false),
                new BrowseMovieModel("tt4154796", "Avengers: Endgame", 2019, "Anthony Russo", 8.6f, "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg", "/or06FN3Dka5tukK1e9sl16pB3iy.jpg", false)

        };
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("direction", "desc");

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());

    }

    @Test
    public void validBrowseKeywordQueryParamsOrderby_Year_Limit_25_Offset_25_Asc()
    {
        String email = "existing3@existing.com";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "spy";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {                new BrowseMovieModel("tt0093405","Leonard Part 6",1987,"Paul Weiland",2.8f,"/2OoykhydUHRQlmqdQ3tqX53LwKs.jpg","/aauZlMqKIDxTlgRZgZlRrJJ9JU2.jpg",false),
                new BrowseMovieModel("tt0093428","The Living Daylights",1987,"John Glen",6.4f,"/gt0TafbcheJeT9SFewDLqYWk3Sd.jpg","/yEryMe58dx7zm1QBhQFeuYcv2aH.jpg",false),
                new BrowseMovieModel("tt0095532","Little Nikita",1988,"Richard Benjamin",6.1f,"/AqxLvOpShOVjR8TNK9cV451s9gb.jpg","/tWL8kUcdz5MBE7dlm8YbxeNTUsq.jpg",false),
                new BrowseMovieModel("tt0109444","Clear and Present Danger",1994,"Phillip Noyce",6.6f,"/dxzko1cqui9Scowo53u6lJuEhug.jpg","/avRDucB3FLf1Xz5532hbOYd1giX.jpg",false),
                new BrowseMovieModel("tt0111503","True Lies",1994,"James Cameron",6.9f,"/o2agns0LEqyEUCByMT8ViIOio7r.jpg","/9yOzwgGdVoRhDYSwVbhyhgNMoUi.jpg",false),
                new BrowseMovieModel("tt0116493","Harriet the Spy",1996,"Bronwen Hughes",6.0f,"/jZvnkh7TO1DvmmT0FsAzmj78Hmg.jpg","/erYGaztkz1tJbmyiB8uLMa9e4ZG.jpg",false),
                new BrowseMovieModel("tt0117060","Mission: Impossible",1996,"Brian De Palma",6.9f,"/tjQHn6xW5BiB1RJ3OZIPDzIOSkF.jpg","/1PVKS17pIBFsIhgFws2uagPDNLW.jpg",false),
                new BrowseMovieModel("tt0120746","The Mask of Zorro",1998,"Martin Campbell",6.4f,"/zQu6bClLL0wnrHDlQYA43wtSiWg.jpg","/QBxafkXiqUadYWsVZGhi8qyPT6.jpg",false),
                new BrowseMovieModel("tt0236784","The Tailor of Panama",2001,"John Boorman",6.1f,"/nUZ8nCoAyWmjcjsVcjsTpb6739Y.jpg","/crJTnaCvzw3gCCqNSzEK6yerzJU.jpg",false),
                new BrowseMovieModel("tt0246460","Die Another Day",2002,"Lee Tamahori",5.9f,"/3YQfmtpbiFCMHcXY3lJ7fGEcOL6.jpg","/1iUZqUXS7x5FcGM5J0u01xuObWC.jpg",false),
                new BrowseMovieModel("tt0287717","Spy Kids 2: The Island of Lost Dreams",2002,"Robert Rodriguez",5.5f,"/5rKa5UKXnTdLsgY0mJbjAEQX3gB.jpg","/tt8IpWLJYmTlATHFhsxmA1U5RDy.jpg",false),
                new BrowseMovieModel("tt0295178","Austin Powers in Goldmember",2002,"Jay Roach",5.9f,"/mzZraP6PV34eVjB8giKbKIMXVeW.jpg","/tFR7dTbX5BsmoUwKHfa2cWoZbwK.jpg",false),
                new BrowseMovieModel("tt0274166","Johnny English",2003,"Peter Howitt",6.2f,"/wNEsGAHws1UATmZfnjNBRi2Ln5.jpg","/fvFOJFDwgtINOxxtrFFiCMUrGdR.jpg",false),
                new BrowseMovieModel("tt0313911","Agent Cody Banks",2003,"Harald Zwart",5.2f,"/rHuyKvgXGv59mzx70E3t5jzONxS.jpg","/fhK0mqqirPsckxkNisvi32A4lf6.jpg",false),
                new BrowseMovieModel("tt0318155","Looney Tunes: Back in Action",2003,"Joe Dante",5.9f,"/3yc2at1aIrK0ri7Z8vvfS9o9vgK.jpg","/ownVrxw7OYOo8vwk2g4q74Oe8Wa.jpg",false),
                new BrowseMovieModel("tt0386140","The Legend of Zorro",2005,"Martin Campbell",6.0f,"/iRD5SBgro8MRmcU9Y4JNJxYmh3k.jpg","/rH3WJbSE3APS1l1hTXZZbz3NVP1.jpg",false),
                new BrowseMovieModel("tt0405336","Southland Tales",2006,"Richard Kelly",5.1f,"/lkcBZcPjxukB64uZB4ToXHTFZuT.jpg","/oYcJjhtLWJbgdlQMZFrH3LFYyhH.jpg",false),
                new BrowseMovieModel("tt0425061","Get Smart",2008,"Peter Segal",6.1f,"/jrWrNLPeeB4d7II30EJRSYX7Sbr.jpg","/zS3UhYJvy6oLTBgNckpoyAa0qNs.jpg",false),
                new BrowseMovieModel("tt1212974","Bitch Slap",2009,"Rick Jacobson",4.8f,"/9MniRAXnacFcARalrfqpEAFWYPP.jpg","/s6bvosVfeLUBMgFz0GCxqZAUz3i.jpg",false),
                new BrowseMovieModel("tt1375666","Inception",2010,"Christopher Nolan",8.3f,"/s2bT29y0ngXxxu2IA8AOzzXTRhd.jpg","/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg",false),
                new BrowseMovieModel("tt1013743","Knight and Day",2010,"James Mangold",6.0f,"/clq0YPDQYCql9ekC17YFklk8FwX.jpg","/aHEpzwXvMtIEMBE13tWXS5oHZ7d.jpg",false),
                new BrowseMovieModel("tt1517489","Spy Kids: All the Time in the World",2011,"Robert Rodriguez",4.7f,"/aezGIrtl4Q8KaLltPum0hR4VRuB.jpg","/eHldUGDNxb4ZPQSPDnGolyFDECa.jpg",false),
                new BrowseMovieModel("tt1229238","Mission: Impossible - Ghost Protocol",2011,"Brad Bird",6.9f,"/pc7a2qrIkIxzqWGqcexd3mHzIxy.jpg","/s58mMsgIVOFfoXPtwPWJ3hDYpXf.jpg",false),
                new BrowseMovieModel("tt1340800","Tinker Tailor Soldier Spy",2011,"Tomas Alfredson",6.7f,"/bqpGceqQuHbtnjEqUG9acSYIVIh.jpg","/2N3P730TYXEcNL0BO8WBuMc6yJz.jpg",false),
                new BrowseMovieModel("tt1074638","Skyfall",2012,"Sam Mendes",7.1f,"/6bjRujKSnCVSrzC1qjmqfAyaiET.jpg","/lQCkPLDxFONmgzrWLvq085v1g2d.jpg",false)
            };
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("orderby", "year");
        query.putSingle("direction", "asc");
        query.putSingle("limit", 25);
        query.putSingle("offset", 25);

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }


    @Test
    public void validBrowseKeywordQueryParamsLimit_25_Offset_25Asc()
    {
        String email = "existing3@existing.com";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "spy";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {    new BrowseMovieModel("tt0274166", "Johnny English", 2003, "Peter Howitt", 6.2f, "/wNEsGAHws1UATmZfnjNBRi2Ln5.jpg", "/fvFOJFDwgtINOxxtrFFiCMUrGdR.jpg", false), new BrowseMovieModel("tt4649466", "Kingsman: The Golden Circle", 2017, "Matthew Vaughn", 7.0f, "/uExPmkOHJySrbJyJDJylHDqaT58.jpg", "/34xBL6BXNYFqtHO9zhcgoakS4aP.jpg", false),
                new BrowseMovieModel("tt2802144", "Kingsman: The Secret Service", 2015, "Matthew Vaughn", 7.6f, "/7McaexSsSTLD8V17UgaZAfI0Cu9.jpg", "/8x7ej0LnHdKUqilNNJXYOeyB6L9.jpg", false),
                new BrowseMovieModel("tt1013743", "Knight and Day", 2010, "James Mangold", 6.0f, "/clq0YPDQYCql9ekC17YFklk8FwX.jpg", "/aHEpzwXvMtIEMBE13tWXS5oHZ7d.jpg", false),
                new BrowseMovieModel("tt0093405", "Leonard Part 6", 1987, "Paul Weiland", 2.8f, "/2OoykhydUHRQlmqdQ3tqX53LwKs.jpg", "/aauZlMqKIDxTlgRZgZlRrJJ9JU2.jpg", false),
                new BrowseMovieModel("tt0095532", "Little Nikita", 1988, "Richard Benjamin", 6.1f, "/AqxLvOpShOVjR8TNK9cV451s9gb.jpg", "/tWL8kUcdz5MBE7dlm8YbxeNTUsq.jpg", false),
                new BrowseMovieModel("tt0070328", "Live and Let Die", 1973, "Guy Hamilton", 6.5f, "/1N4CeQyy3kh1pqmTGvMU090sCvh.jpg", "/p34OScaro2KdISrT4EMfeh1aS0E.jpg", false),
                new BrowseMovieModel("tt0318155", "Looney Tunes: Back in Action", 2003, "Joe Dante", 5.9f, "/3yc2at1aIrK0ri7Z8vvfS9o9vgK.jpg", "/ownVrxw7OYOo8vwk2g4q74Oe8Wa.jpg", false),
                new BrowseMovieModel("tt0037075", "Ministry of Fear", 1944, "Fritz Lang", 6.8f, "/mKGpi9rdFdRwtKmHzlFLGWKh4Cq.jpg", "/6NK6v5AVMl7iPgxhT8sKb0rnAHX.jpg", false),
                new BrowseMovieModel("tt0117060", "Mission: Impossible", 1996, "Brian De Palma", 6.9f, "/tjQHn6xW5BiB1RJ3OZIPDzIOSkF.jpg", "/1PVKS17pIBFsIhgFws2uagPDNLW.jpg", false),
                new BrowseMovieModel("tt4912910", "Mission: Impossible - Fallout", 2018, "Christopher McQuarrie", 7.3f, "/aw4FOsWr2FY373nKSxbpNi3fz4F.jpg", "/AkJQpZp9WoNdj7pLYSj1L0RcMMN.jpg", false),
                new BrowseMovieModel("tt1229238", "Mission: Impossible - Ghost Protocol", 2011, "Brad Bird", 6.9f, "/pc7a2qrIkIxzqWGqcexd3mHzIxy.jpg", "/s58mMsgIVOFfoXPtwPWJ3hDYpXf.jpg", false),
                new BrowseMovieModel("tt0086006", "Never Say Never Again", 1983, "Irvin Kershner", 6.0f, "/jYO08KXUKvJvzx3KcE7MoaDYvoM.jpg", "/s9tBlhTEW0OtYJdemVMPbRcD7wk.jpg", false),
                new BrowseMovieModel("tt0053125", "North by Northwest", 1959, "Alfred Hitchcock", 8.0f, "/AplR1QRswlXiM65GoifX8sDadME.jpg", "/aNV789h3oHm2pTHK5Bdq5RuiumZ.jpg", false),
                new BrowseMovieModel("tt0059557", "Our Man Flint", 1966, "Daniel Mann", 6.6f, "/fAOM20EdOS0Fz2ezs8FhfUPLa4A.jpg", "/2rMEYchRwPYXbvQxEdsF78kjtWN.jpg", false),
                new BrowseMovieModel("tt0054152", "Our Man in Havana", 1959, "Carol Reed", 7.1f, "/hhDOs96SMsq5BCcgjus6qOWAKHS.jpg", "/e9L89r5olLhPDKU9yYBy5mpsnbu.jpg", false),
                new BrowseMovieModel("tt1074638", "Skyfall", 2012, "Sam Mendes", 7.1f, "/6bjRujKSnCVSrzC1qjmqfAyaiET.jpg", "/lQCkPLDxFONmgzrWLvq085v1g2d.jpg", false),
                new BrowseMovieModel("tt0405336", "Southland Tales", 2006, "Richard Kelly", 5.1f, "/lkcBZcPjxukB64uZB4ToXHTFZuT.jpg", "/oYcJjhtLWJbgdlQMZFrH3LFYyhH.jpg", false),
                new BrowseMovieModel("tt0090056", "Spies Like Us", 1985, "John Landis", 6.0f, "/4yIBci2iAtyXgl9nwhbvRTB7Ofz.jpg", "/s0Sx8nd9Irq0aCPbsN78s0DYVlG.jpg", false),
                new BrowseMovieModel("tt0287717", "Spy Kids 2: The Island of Lost Dreams", 2002, "Robert Rodriguez", 5.5f, "/5rKa5UKXnTdLsgY0mJbjAEQX3gB.jpg", "/tt8IpWLJYmTlATHFhsxmA1U5RDy.jpg", false),
                new BrowseMovieModel("tt1517489", "Spy Kids: All the Time in the World", 2011, "Robert Rodriguez", 4.7f, "/aezGIrtl4Q8KaLltPum0hR4VRuB.jpg", "/eHldUGDNxb4ZPQSPDnGolyFDECa.jpg", false),
                new BrowseMovieModel("tt0046359", "Stalag 17", 1953, "Billy Wilder", 7.8f, "/zgM5leh0dKPXllIJwemc3dVRyE7.jpg", "/2PtDbmN7HAu4W5WqrUocBV8lgiZ.jpg", false),
                new BrowseMovieModel("tt4602066", "The Catcher Was a Spy", 2018, "Ben Lewin", 6.2f, "/tq5Dq9IvXlag9iOdqoMWDx9cw7z.jpg", "/eF6LubTEp1KI6NXUP2o5G4g9AOP.jpg", false),
                new BrowseMovieModel("tt4721124", "The Exception", 2017, "David Leveaux", 7.0f, "/kgSE6tciPqn9aKGB69K7cPQljNA.jpg", "/nNCS7JdLFzLKaqtce4lzjtGfdp4.jpg", false),
                new BrowseMovieModel("tt0087231", "The Falcon and the Snowman", 1985, "John Schlesinger", 6.7f, "/YtnXUaJk3rDxdC90vl5Zd4puod.jpg", "/9bEjyzGYqtUfnKt7DSRac3U48km.jpg", false)
        };
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("direction", "asc");
        query.putSingle("limit", 25);
        query.putSingle("offset", 25);

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }


}
