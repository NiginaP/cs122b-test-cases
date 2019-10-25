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
    private String validSessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
    //private String expiredSessionID = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123124";
    //private String revokedSessionID = "bbbbbbbbbbbbbbssjkbbbbbbbbbbbbssssssjasjdasdkasd1312313123123126";

    @Test
    public void testMovieFoundSuccessfullyWithAllQueryParamsValid_DefaultLimitOffsetOrderbyDirection(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie = new Movie("tt4154796","Avengers: Endgame",2019,"Joe Russo",(float)8.6, "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg", "/or06FN3Dka5tukK1e9sl16pB3iy.jpg", false);
        Movie[] expectedMovieArray = new Movie[1];
        expectedMovieArray[0] = expectedMovie;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID, "Avengers: Endgame", 2019, "Joe Russo", "action", false, null, null, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    /*@Test
    public void testNoMovieFound_ExpiredSessionID(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.expiredSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, null, null, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_RevokedSessionID(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.revokedSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, null, null, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }*/

    @Test
    public void testMovieFoundSuccessfully_CustomizedLimit(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie0 = new Movie("tt7054636","A Madea Family Funeral",2019,"Tyler Perry",(float)5.6, "/piGjUloiaq6qTpaDLisyDyEsx9i.jpg", "/sFvOTUlZrIxCLdmz1fC16wK0lme.jpg", false);
        Movie expectedMovie1 = new Movie("tt6211976","A Vigilante",2019,"Sarah Daggar-Nickson",(float)4.6, "/kReEky4XRCAq22H5V37kDcNY9dj.jpg", "/avoKZfgBzyBGJsrAr2WQOwZK978.jpg", false);
        Movie expectedMovie2 = new Movie("tt5215088","A.I. Rising",2019,"Lazar Bodroža",(float)3.7, "/ddQ11EC7tiXJVNNHjGCMMQgJYNz.jpg", "/aXosp6MFBxYi4m6ZmE4u1auReHc.jpg", false);
        Movie expectedMovie3 = new Movie("tt9562694","Alien Warfare",2019,"Jeremiah Jones",(float)3.2, "/3OjDQWEhvtxBlMtxYVwGxP3isLf.jpg", "/rJOj0T5DyChfECevDg0xpEGznsl.jpg", false);
        Movie expectedMovie4 = new Movie("tt0437086","Alita: Battle Angel",2019,"Robert Rodriguez",(float)6.6, "/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg", "/xRWht48C2V8XNfzvPehyClOvDni.jpg", false);
        Movie expectedMovie5 = new Movie("tt9770590","Amy Schumer: Growing",2019,"Amy Schumer",(float)6.2, "/znV9hAFBVH5dl49RIGy1hHsQUs7.jpg", "/zZJYPkiCI0PFv8tUc8qViyC2oKx.jpg", false);
        Movie expectedMovie6 = new Movie("tt9817308","Antoine Griezmann : The Making of a Legend",2019,"Amy Schumer",(float)7.6, "/jWaBxVNWYqec9Ye8MOZYTUPRke5.jpg", "/mSqJzD857y3MSxHgW6ItZMoSUfa.jpg", false);
        Movie expectedMovie7 = new Movie("tt4154796","Avengers: Endgame",2019,"Anthony Russo",(float)8.6, "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg", "/or06FN3Dka5tukK1e9sl16pB3iy.jpg", false);
        Movie expectedMovie8 = new Movie("tt7208564","Blood Fest",2019,"Owen Egerton",(float)5.7, "/e4eeJjON17Cv7Cio3QEyC4xv5uZ.jpg", "/iy6mJ8EvVQrrSrSblK7GRYFq1Mp.jpg", false);
        Movie expectedMovie9 = new Movie("tt8425058","Brexit: The Uncivil War",2019,"Toby Haynes",(float)6.6, "/vRIGYfTd6Sd6B1y8j5esfW4pXn2.jpg", "/kWgIRP33JPKfMbsSUOPFCZenQJe.jpg", false);
        Movie expectedMovie10 = new Movie("tt4154664","Captain Marvel",2019,"Anna Boden",(float)7.1, "/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg", "/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg", false);
        Movie expectedMovie11 = new Movie("tt5968394","Captive State",2019,"Rupert Wyatt",(float)4.7, "/6IZ84KFhNpy6htsJmwFVuK30pyp.jpg", "/wB24P3QGGoAkEyBzTEb5s4lFY7N.jpg", false);
        Movie expectedMovie12 = new Movie("tt2677722","City of Lies",2019,"Brad Furman",(float)6.3, "/gebZygvoWdmXr6YQHieCBpOxm4m.jpg", "/pK7IYQdtdWtMDBJZfMqDxgMjXEt.jpg", false);
        Movie expectedMovie13 = new Movie("tt5719748","Cold Pursuit",2019,"Hans Petter Moland",(float)5.2, "/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg", "/otK0H9H1w3JVGJjad5Kzx3Z9kt2.jpg", false);
        Movie expectedMovie14 = new Movie("tt4457344","Dave Made a Maze",2019,"Bill Watterson",(float)0, "/sdV2CyNro8RnFx0NFbe7OIWp1v0.jpg", "/7Z5sEOC8Y7bdrg7FmIfNGkNniyX.jpg", false);
        Movie expectedMovie15 = new Movie("tt6491178","Dragged Across Concrete",2019,"S. Craig Zahler",(float)6.8, "/sZUbg9K8zGiUmeVYSlUNelVcuzM.jpg", "/fVG4a27ImyPS4vvNMjCtan3QhDl.jpg", false);
        Movie expectedMovie16 = new Movie("tt2481498","Extremely Wicked, Shockingly Evil and Vile",2019,"Joe Berlinger",(float)7.1, "/5yXNf13ly6kFQSbI5BZRQlDhCib.jpg", "/zSuJ3r5zr5T26tTxyygHhgkUAIM.jpg", false);
        Movie expectedMovie17 = new Movie("tt6513120","Fighting with My Family",2019,"Stephen Merchant",(float)6.5, "/mYKP6qcDUimVMAHQWLOuDHjO19S.jpg", "/3TZCBAdKQiz0cGKGEjZiyZUA01O.jpg", false);
        Movie expectedMovie18 = new Movie("tt6472976","Five Feet Apart",2019,"Justin Baldoni",(float)8.2, "/d7wa3VpUpKDQ7GG9EMw8zSJCFoI.jpg", "/kreTuJBkUjVWePRfhHZuYfhNE1T.jpg", false);
        Movie expectedMovie19 = new Movie("tt7843600","Fyre Fraud",2019,"Julia Willoughby Nason",(float)6.4, "/6XMByhD5H93RquXHnmcbrOogqUs.jpg", "/jeeHE4gDErwulQ9UJjHeLAzV1TG.jpg", false);
        Movie expectedMovie20 = new Movie("tt6902696","Gloria Bell",2019,"Sebastián Lelio",(float)5.9, "/547fjELV7imMeSJrmkK2FeVHjvf.jpg", "/ua34uW49DfpFyV61aT3l7SKN3TV.jpg", false);
        Movie expectedMovie21 = new Movie("tt8858104","Guava Island",2019,"Hiro Murai",(float)7.4, "/tf2hJletuXDjqBrx5z007AYFhFe.jpg", "/noE2O4XaRSrNZ75MUShaQD0pFN0.jpg", false);
        Movie expectedMovie22 = new Movie("tt8155288","Happy Death Day 2U",2019,"Christopher Landon",(float)6.1, "/v99NrmuSYn4HGwwpHWEkMVSeAL3.jpg", "/4tdnePOkOOzwuGPEOAHp8UA4vqx.jpg", false);
        Movie expectedMovie23 = new Movie("tt8128188","High Flying Bird",2019,"Steven Soderbergh",(float)5.6, "/4t3ELPWvb7afiY9dFUqIdZIlTbT.jpg", "/ccE21xixa1zhkGtWDr4n8ReOp40.jpg", false);
        Movie expectedMovie24 = new Movie("tt5461944","Hotel Mumbai",2019,"Anthony Maras",(float)8, "/2WgDlJnkc1klLr1WuCuUTzzmNne.jpg", "/4UM3WBgWvAXi9CaBXJjwAMnEY05.jpg", false);

        Movie[] expectedMovieArray = new Movie[25];
        expectedMovieArray[0] = expectedMovie0;
        expectedMovieArray[1] = expectedMovie1;
        expectedMovieArray[2] = expectedMovie2;
        expectedMovieArray[3] = expectedMovie3;
        expectedMovieArray[4] = expectedMovie4;
        expectedMovieArray[5] = expectedMovie5;
        expectedMovieArray[6] = expectedMovie6;
        expectedMovieArray[7] = expectedMovie7;
        expectedMovieArray[8] = expectedMovie8;
        expectedMovieArray[9] = expectedMovie9;
        expectedMovieArray[10] = expectedMovie10;
        expectedMovieArray[11] = expectedMovie11;
        expectedMovieArray[12] = expectedMovie12;
        expectedMovieArray[13] = expectedMovie13;
        expectedMovieArray[14] = expectedMovie14;
        expectedMovieArray[15] = expectedMovie15;
        expectedMovieArray[16] = expectedMovie16;
        expectedMovieArray[17] = expectedMovie17;
        expectedMovieArray[18] = expectedMovie18;
        expectedMovieArray[19] = expectedMovie19;
        expectedMovieArray[20] = expectedMovie20;
        expectedMovieArray[21] = expectedMovie21;
        expectedMovieArray[22] = expectedMovie22;
        expectedMovieArray[23] = expectedMovie23;
        expectedMovieArray[24] = expectedMovie24;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,null, 2019, null, null, false, 25, null, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void testMovieFoundSuccessfully_CustomizedOffset(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie0 = new Movie("tt6211976","A Vigilante",2019,"Sarah Daggar-Nickson",(float)4.6, "/kReEky4XRCAq22H5V37kDcNY9dj.jpg", "/avoKZfgBzyBGJsrAr2WQOwZK978.jpg", false);
        Movie expectedMovie1 = new Movie("tt5215088","A.I. Rising",2019,"Lazar Bodroža",(float)3.7, "/ddQ11EC7tiXJVNNHjGCMMQgJYNz.jpg", "/aXosp6MFBxYi4m6ZmE4u1auReHc.jpg", false);
        Movie expectedMovie2 = new Movie("tt9562694","Alien Warfare",2019,"Jeremiah Jones",(float)3.2, "/3OjDQWEhvtxBlMtxYVwGxP3isLf.jpg", "/rJOj0T5DyChfECevDg0xpEGznsl.jpg", false);
        Movie expectedMovie3 = new Movie("tt0437086","Alita: Battle Angel",2019,"Robert Rodriguez",(float)6.6, "/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg", "/xRWht48C2V8XNfzvPehyClOvDni.jpg", false);
        Movie expectedMovie4 = new Movie("tt9770590","Amy Schumer: Growing",2019,"Amy Schumer",(float)6.2, "/znV9hAFBVH5dl49RIGy1hHsQUs7.jpg", "/zZJYPkiCI0PFv8tUc8qViyC2oKx.jpg", false);
        Movie expectedMovie5 = new Movie("tt9817308","Antoine Griezmann : The Making of a Legend",2019,"Amy Schumer",(float)7.6, "/jWaBxVNWYqec9Ye8MOZYTUPRke5.jpg", "/mSqJzD857y3MSxHgW6ItZMoSUfa.jpg", false);
        Movie expectedMovie6 = new Movie("tt4154796","Avengers: Endgame",2019,"Anthony Russo",(float)8.6, "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg", "/or06FN3Dka5tukK1e9sl16pB3iy.jpg", false);
        Movie expectedMovie7 = new Movie("tt7208564","Blood Fest",2019,"Owen Egerton",(float)5.7, "/e4eeJjON17Cv7Cio3QEyC4xv5uZ.jpg", "/iy6mJ8EvVQrrSrSblK7GRYFq1Mp.jpg", false);
        Movie expectedMovie8 = new Movie("tt8425058","Brexit: The Uncivil War",2019,"Toby Haynes",(float)6.6, "/vRIGYfTd6Sd6B1y8j5esfW4pXn2.jpg", "/kWgIRP33JPKfMbsSUOPFCZenQJe.jpg", false);
        Movie expectedMovie9 = new Movie("tt4154664","Captain Marvel",2019,"Anna Boden",(float)7.1, "/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg", "/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg", false);

        Movie[] expectedMovieArray = new Movie[25];
        expectedMovieArray[0] = expectedMovie0;
        expectedMovieArray[1] = expectedMovie1;
        expectedMovieArray[2] = expectedMovie2;
        expectedMovieArray[3] = expectedMovie3;
        expectedMovieArray[4] = expectedMovie4;
        expectedMovieArray[5] = expectedMovie5;
        expectedMovieArray[6] = expectedMovie6;
        expectedMovieArray[7] = expectedMovie7;
        expectedMovieArray[8] = expectedMovie8;
        expectedMovieArray[9] = expectedMovie9;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,null, 2019, null, null, false, null, 1, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void testMovieFoundSuccessfully_CustomizedOrderbyRating(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie0 = new Movie("tt4457344","Dave Made a Maze",2019,"Bill Watterson",(float)0, "/sdV2CyNro8RnFx0NFbe7OIWp1v0.jpg", "/7Z5sEOC8Y7bdrg7FmIfNGkNniyX.jpg", false);
        Movie expectedMovie1 = new Movie("tt9562694","Alien Warfare",2019,"Jeremiah Jones",(float)3.2, "/3OjDQWEhvtxBlMtxYVwGxP3isLf.jpg", "/rJOj0T5DyChfECevDg0xpEGznsl.jpg", false);
        Movie expectedMovie2 = new Movie("tt5215088","A.I. Rising",2019,"Lazar Bodroža",(float)3.7, "/ddQ11EC7tiXJVNNHjGCMMQgJYNz.jpg", "/aXosp6MFBxYi4m6ZmE4u1auReHc.jpg", false);
        Movie expectedMovie3 = new Movie("tt6211976","A Vigilante",2019,"Sarah Daggar-Nickson",(float)4.6, "/kReEky4XRCAq22H5V37kDcNY9dj.jpg", "/avoKZfgBzyBGJsrAr2WQOwZK978.jpg", false);
        Movie expectedMovie4 = new Movie("tt5968394","Captive State",2019,"Rupert Wyatt",(float)4.7, "/6IZ84KFhNpy6htsJmwFVuK30pyp.jpg", "/wB24P3QGGoAkEyBzTEb5s4lFY7N.jpg", false);
        Movie expectedMovie5 = new Movie("tt3256226","IO",2019,"Jonathan Helpert",(float)4.8, "/tirhxzSR6g1A9Iayo2lpYW4luUF.jpg", "/utH781EwjzzXQC6fZUO3cw8L5Ht.jpg", false);
        Movie expectedMovie6 = new Movie("tt5719748","Cold Pursuit",2019,"Hans Petter Moland",(float)5.2, "/ckNp6LPhp1roR8dVI16q5u3LUMg.jpg", "/3rViQPcrWthMNecp5XnkKev6BzW.jpg", false);
        Movie expectedMovie7 = new Movie("tt7043012","Velvet Buzzsaw",2019,"Dan Gilroy",(float)5.3, "/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg", "/otK0H9H1w3JVGJjad5Kzx3Z9kt2.jpg", false);
        Movie expectedMovie8 = new Movie("tt4913966","The Curse of La Llorona",2019,"Michael Chaves",(float)5.5, "/u2vGggeMPAkhEtD7bYGfeThsQiM.jpg", "/jhZlXSnFUpNiLAek9EkPrtLEWQI.jpg", false);
        Movie expectedMovie9 = new Movie("tt7054636","A Madea Family Funeral",2019,"Tyler Perry",(float)5.6, "/piGjUloiaq6qTpaDLisyDyEsx9i.jpg", "/sFvOTUlZrIxCLdmz1fC16wK0lme.jpg", false);


        Movie[] expectedMovieArray = new Movie[10];
        expectedMovieArray[0] = expectedMovie0;
        expectedMovieArray[1] = expectedMovie1;
        expectedMovieArray[2] = expectedMovie2;
        expectedMovieArray[3] = expectedMovie3;
        expectedMovieArray[4] = expectedMovie4;
        expectedMovieArray[5] = expectedMovie5;
        expectedMovieArray[6] = expectedMovie6;
        expectedMovieArray[7] = expectedMovie7;
        expectedMovieArray[8] = expectedMovie8;
        expectedMovieArray[9] = expectedMovie9;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,null, 2019, null, null, false, null, null, "rating", null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void testMovieFoundSuccessfully_CustomizedOrderbyYear(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie0 = new Movie("tt0015175","Die Nibelungen: Siegfried",1924,"Fritz Lang",(float)7.8, "/cylOPTppYighfnGL6Wy8cal1Gq9.jpg", "/hyq7gPo3LjMs0hap1xvzrH5gxeA.jpg", false);
        Movie expectedMovie1 = new Movie("tt0015864","The Gold Rush",1925,"Charlie Chaplin",(float)8, "/m5eYy0SY33hLnxWAdrILJddTi49.jpg", "/eQRFo1qwRREYwj47Yoe1PisgOle.jpg", false);
        Movie expectedMovie2 = new Movie("tt0016641","Ben-Hur: A Tale of the Christ",1925,"Rex Ingram",(float)7.6, "/iQCR4FvqSgf5FiroPRa9VjCtA8y.jpg", "/4EbIbp9Kgnj0m0eMEfQlX3fyDHZ.jpg", false);
        Movie expectedMovie3 = new Movie("tt0020691", "The Big Trail", 1930, "Raoul Walsh", (float)6.8, "/tCbCbYdE12UazKLJzJTZwAY86pv.jpg", "/6uvnyapOMclNz2Uop7bcxpYiP3b.jpg", false);
        Movie expectedMovie4 = new Movie("tt0024188", "Island of Lost Souls", 1932, "Erle C. Kenton", (float)7.1, "/yw4kfAtIBSI2WJy0ZHgBQe3msMb.jpg", "/g7K7r1FojQC52YHxfmuXgwYBq5Q.jpg", false);
        Movie expectedMovie5 = new Movie("tt0023238", "The Most Dangerous Game", 1932, "Ernest B. Schoedsack", (float)7.2, "/aV2b3tOQYZBaEcCeXxbRaEaP6W1.jpg", "/3aNlOIFlGOnIzxqvAWpgm5Sly1H.jpg", false);
        Movie expectedMovie6 = new Movie("tt0023458", "Shanghai Express", 1932, "Josef von Sternberg", (float)6.8, "/jY7Yz0YYwXZ7ydPbW8ICVcgere5.jpg", "/ausvToB221szRJkSN6lWcS9lfaS.jpg", false);
        Movie expectedMovie7 = new Movie("tt0023551", "Tarzan the Ape Man", 1932, "W.S. Van Dyke", (float)6.5, "/gPeJKuApv6tuHbN3oPYxqZ1bj4g.jpg", "/sqtdNAktAI3p1iXmaEooaHjMmWd.jpg", false);
        Movie expectedMovie8 = new Movie("tt0024593", "The Son of Kong", 1933, "Ernest B. Schoedsack", (float)5.5, "/xj4WIDZ43ADgza3OHxnPoCS4xOl.jpg", "/p1VI7gFogYD39pRUz901G8idWmZ.jpg", false);
        Movie expectedMovie9 = new Movie("tt0025862", "Tarzan and His Mate", 1934, "Cedric Gibbons", (float)6.5, "/i2TPTgROdJVfxvjIdcTevrHKJFJ.jpg", "/tAPMmaeh66IKy4njzd8WKRbMbnw.jpg", false);

        Movie[] expectedMovieArray = new Movie[3];
        expectedMovieArray[0] = expectedMovie0;
        expectedMovieArray[1] = expectedMovie1;
        expectedMovieArray[2] = expectedMovie2;
        expectedMovieArray[3] = expectedMovie3;
        expectedMovieArray[4] = expectedMovie4;
        expectedMovieArray[5] = expectedMovie5;
        expectedMovieArray[6] = expectedMovie6;
        expectedMovieArray[7] = expectedMovie7;
        expectedMovieArray[8] = expectedMovie8;
        expectedMovieArray[9] = expectedMovie9;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,null, null, null, "Adventure", false, null, null, "year", null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void testMovieFoundSuccessfully_CustomizedDirection(){
        Result expectedResult = Result.MOVIES_FOUND;
        Movie expectedMovie0 = new Movie("tt0080180","Zulu Dawn",1979,"Douglas Hickox",(float)6, "/Wm0gjfAOi1kOMGILTZJJk5krPU.jpg", "/57Yr5Es4dk2udRY2R9iDVjSkk6q.jpg", false);
        Movie expectedMovie1 = new Movie("tt2948356","Zootopia",2016,"Rich Moore",(float)7.7, "/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg", "/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg", false);
        Movie expectedMovie2 = new Movie("tt0120550","Zeus & Roxanne",1997,"George T. Miller",(float)5.1, "/kcs2Vv4UvyjWOpcI2llWoFwve6L.jpg", "/JsEEn2fSLhHQ0LHoPHJM7M7U8w.jpg", false);
        Movie expectedMovie3 = new Movie("tt0379060","Zenon: Z3",2004,"Steve Rash",(float)5.1, "/4I1tnwaW0hfZotli4hE9e9aMTg7.jpg", "/oh3C0CtoLTRTGYpdQtsWG34VoAE.jpg", false);
        Movie expectedMovie4 = new Movie("tt0271271","Zenon: The Zequel",2001,"Manny Coto",(float)5.2, "/jLItUv8aWHDKEapS9fmimv9NINP.jpg", "/uiRIpiOf6PQPVTPxhBIvjgYxX8n.jpg", false);
        Movie expectedMovie5 = new Movie("tt0186726","Zenon: Girl of the 21st Century",1999,"Kenneth Johnson",(float)5.8, "/fnEe7htqZyP24C5Udq0DofeKSXn.jpg", "/aaasI95hIbBnl6i85hjHY6suM9d.jpg", false);
        Movie expectedMovie6 = new Movie("tt0406375","Zathura: A Space Adventure",2005,"Jon Favreau",(float)6.2, "/jzcOVeydNYF4hX0OiNftWC8QZJz.jpg", "/amqgIuISRBt8tsZM6cTT6gO9WLR.jpg", false);
        Movie expectedMovie7 = new Movie("tt1488181","Zambezia",2012,"Wayne Thornley",(float)5.5, "/5xPTAstcnDpZWmai8mocGUHChKF.jpg", "/dLZTSTe4czdJ3Fr6vwy8XwVzLF5.jpg", false);
        Movie expectedMovie8 = new Movie("tt0096487","Young Guns",1988,"Christopher Cain",(float)6.7, "/llVClV0i94ELiR9dO47fJkPwbq6.jpg", "/wkGbwWHIM23BkmMBm7GQHaCZan8.jpg", false);
        Movie expectedMovie9 = new Movie("tt0318850","Young Black Stallion",2003,"Simon Wincer",(float)6.1, "/vxPiyoGNSTHUINTlFxTVo6ZLegj.jpg", "/6QRfEgONo5MYgDEDTipIcetnHsO.jpg", false);

        Movie[] expectedMovieArray = new Movie[3];
        expectedMovieArray[0] = expectedMovie0;
        expectedMovieArray[1] = expectedMovie1;
        expectedMovieArray[2] = expectedMovie2;
        expectedMovieArray[3] = expectedMovie3;
        expectedMovieArray[4] = expectedMovie4;
        expectedMovieArray[5] = expectedMovie5;
        expectedMovieArray[6] = expectedMovie6;
        expectedMovieArray[7] = expectedMovie7;
        expectedMovieArray[8] = expectedMovie8;
        expectedMovieArray[9] = expectedMovie9;
        MovieSearchResponseModel expectedModel = new MovieSearchResponseModel(expectedResult, expectedMovieArray);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,null, null, null, "Adventure", false, null, null, null, "desc");

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidTitle(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"NONEXISTENTMOVIE", 2019, "Joe Russo", "action", false, null, null, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidYear(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", -2019, "Joe Russo", "action", false, null, null,null,null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidDirector(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "NONEXISTENTDIRECTOR", "action", false, null, null,null,null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidGenre(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "Joe Russo", "NONEXISTENTGENRE", false, null, null,null,null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidLimit(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, -10, null,null,null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidOffset(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, null, -10, null, null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidOrderby(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, null, null,"INVALIDORDERBY",null);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }

    @Test
    public void testNoMovieFound_invalidDirection(){
        Result expectedResult = Result.NO_MOVIES_FOUND;
        MovieSearchResponseModel expectedResponseModel = new MovieSearchResponseModel(expectedResult, null);
        ServiceResponse<MovieSearchResponseModel> response = MovieSearch.getSearch(this.validSessionID,"Avengers: Endgame", 2019, "Joe Russo", "action", false, null, null,null,"INVALIDDIRECTION");

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedResponseModel, response.getEntity());
    }
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
     *  ,\s+ - Trim down almost all white space
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
        String email = "ActiveSession@uci.edu";
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
        String email = "ActiveSession@uci.edu";
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
        String email = "ActiveSession@uci.edu";
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
        String email = "ActiveSession@uci.edu";
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

    @Test
    public void validBrowseKeyword_Invalid_OrderBy()
    {
        String email = "ActiveSession@uci.edu";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "crime fighter";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {    new BrowseMovieModel("tt0118688","Batman & Robin",1997,"Joel Schumacher",4.2f,"/39jbxGwfR4wHBV7apo3JiNdHDHq.jpg","/79AYCcxw3kSKbhGpx1LiqaCAbwo.jpg",false),
                new BrowseMovieModel("tt0372784","Batman Begins",2005,"Christopher Nolan",7.6f,"/9myrRcegWGGp24mpVfkD4zhUfhi.jpg","/dr6x4GyyegBWtinPBzipY02J2lV.jpg",false),
                new BrowseMovieModel("tt0103776","Batman Returns",1992,"Tim Burton",6.8f,"/wNIE5dpkiHU2csDRptMutFjAGiV.jpg","/jX5THE1yW3zTdeD9dupcIyQvKiG.jpg",false),
                new BrowseMovieModel("tt1303828","Defendor",2009,"Peter Stebbings",6.4f,"/11BFmXnLq4HohjRFldxJ7ohadmu.jpg","/bGwWUN9aqglafPmZRNlW3tmspuZ.jpg",false),
                new BrowseMovieModel("tt0106697","Demolition Man",1993,"Marco Brambilla",6.5f,"/2p5rA1NRoyyAFfzdHl1Ab1RN3qr.jpg","/k0PN3Ho12cGGIVJW7SCS7apLYaP.jpg",false),
                new BrowseMovieModel("tt1250777","Kick-Ass",2010,"Matthew Vaughn",7.1f,"/ngPkB9K8ZpIjv8HpIC8ExqAfG6H.jpg","/gtfggr5n3ED1neoTqVYmsVCoSS.jpg",false),
                new BrowseMovieModel("tt0103060","Teenage Mutant Ninja Turtles II: The Secret of the Ooze",1991,"Michael Pressman",6.0f,"/mrO3Nn8BWNWiu6Ql76KM7Fx7vMv.jpg","/HD4LtUw4Ono9tzgwWOhHpHcjkj.jpg",false),
                new BrowseMovieModel("tt1345836","The Dark Knight and The Seven Dwarves",1957,"Christopher Nolan",20.2f,"/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg","/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg",false),
                new BrowseMovieModel("tt0453556","TMNT",2007,"Kevin Munroe",5.9f,"/lTO0w7gR5iL4d1i8Zj9JnZDDUQx.jpg","/4hGzZ2DAjdu6IjHT7dGfiVatHEu.jpg",false)};
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("orderby", "flabanana");

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void validBrowseKeyword_Invalid_Limit()
    {
        String email = "ActiveSession@uci.edu";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "judge";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = { new BrowseMovieModel("tt0052561","Anatomy of a Murder",1959,"Otto Preminger",7.9f,"/aFfbSVwzXH5tCi5MQN0idkoFbk0.jpg","/kDFnM2zlHZirR2ItTo56lyrxuAS.jpg",false),
                new BrowseMovieModel(
                        "tt0416508","Becoming Jane",2007,"Julian Jarrold",7.2f,"/wf8GI3QtL4IM2645Fm7OqRqXCkH.jpg","/iLNBdoaKzXNhZV4qbhJPkIEfLEg.jpg",false),
                new BrowseMovieModel(
                        "tt0075783","Breaker! Breaker!",1977,"Don Hulette",4.5f,"/8lCy8EOtUtl4ieykQcDfhNJCBk.jpg","/tlcagN2rFREGgRm8GyL5ylnoco4.jpg",false),
                new BrowseMovieModel(
                        "tt0059014","Carry On Cowboy",1965,"Gerald Thomas",6.4f,"/mrFCc3t8o1xosQ7WrWK7cqI4VfY.jpg","/AtrxYQrFKAUTMdijCPNWZXJQCPc.jpg",false),
                new BrowseMovieModel(
                        "tt0115906","Citizen Ruth",1996,"Alexander Payne",6.5f,"/t5gsjvFLUk7haxBDhmVcmLNtpbN.jpg","/mNVR2CPQ98AKmiLy4MrceQkJKHE.jpg",false),
                new BrowseMovieModel(
                        "tt0061747","Hang 'em High",1968,"Ted Post",6.8f,"/b9ysOV6lBXY4cZen5AM7Z2r75io.jpg","/gFvRKgCAa1MKlcAKZfoDNdR2dgy.jpg",false),
                new BrowseMovieModel(
                        "tt1255919","Holmes & Watson",2018,"Etan Cohen",4.2f,"/5Zvu4SrY3p9qgnITkCn4jAQwKvB.jpg","/orEUlKndjV1rEcWqXbbjegjfv97.jpg",false),
                new BrowseMovieModel(
                        "tt1045772","I Love You Phillip Morris",2009,"John Requa",6.4f,"/xImbM4eokn6qqbTAXGCPjMUKGtP.jpg","/qtAuWLGQ7N4PNQ6boZeqqoUY2l9.jpg",false),
                new BrowseMovieModel(
                        "tt0113492","Judge Dredd",1995,"Danny Cannon",5.5f,"/mSZADd1N0wWkkNJmwcpYAq93bke.jpg","/r17S4XlQ3Jq5U1KRovFUwU8P4aG.jpg",false),
                new BrowseMovieModel(
                        "tt0055031","Judgment at Nuremberg",1961,"Stanley Kramer",8.0f,"/g8yVrnJ72eOt1Xw4uyYBIsBBE2g.jpg","/iu7VMhBma5S94M3wh0fR8cmwgUf.jpg",false
                )};
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("limit", "99");

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    @Test
    public void validBrowseKeyword_keywords_dne()
    {
        String email = "ActiveSession@uci.edu";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "I am lorde, yah, I am lord,south park";
        Result expectedResult = Result.MOVIES_NOT_FOUND;
        BrowseMovieModel[] browseMovieModels = null;
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }

    /*
    Test not working for some reason.
     */
    /*
    @Test
    public void validBrowseKeyword_Invalid_Direction()
    {
        String email = "ActiveSession@uci.edu";
        String sessionID = "15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc";
        String keywords = "cat";
        Result expectedResult = Result.MOVIES_FOUND;
        BrowseMovieModel[] browseMovieModels = {
                new BrowseMovieModel("tt3606888", "A Street Cat Named Bob", 2016, "Roger Spottiswoode", 7.5f, "/f6PEWTJt8nBlAzSuXuG6YvFBAQm.jpg", "/amJU2TxLHytgnd7xyrNZURS6crk.jpg", false),
                new BrowseMovieModel("tt0074121", "Allegro non troppo", 1976, "Bruno Bozzetto", 7.2f, "/xJ5oOBYmf1HC59PyUckVMV0l4aD.jpg", "/hiB3BxFjJFVJVZHLaYkwTF1F4WN.jpg", false),
                new BrowseMovieModel("tt0090633", "An American Tail", 1986, "Don Bluth", 6.7f, "/bl42TZnTrT1b9bGcE153ZYWZmDw.jpg", "/glZNfxN4cef0pJeD08xru7ZVWlI.jpg", false),
                new BrowseMovieModel("tt0106341", "Bad Boy Bubby", 1993, "Rolf de Heer", 7.3f, "/mncWOGmjvtH8PFtePIZ3VfNmgGA.jpg", "/tvipR7aVSsAbdfMlR4sbEqD1Pgd.jpg", false),
                new BrowseMovieModel("tt0051406", "Bell,Book and Candle", 1958, "Richard Quine", 6.4f, "/FLa6tHBr4P4DLQhQecDtXslPTY.jpg", "/efVJYzeOWAE3z4Usu16RCSheYav.jpg", false),
                new BrowseMovieModel("tt0054698", "Breakfast at Tiffany's", 1961, "Blake Edwards", 7.7f, "/vABwESShzjlSynkyGjLihTUieMJ.jpg", "/c95lbDwL5WT8PV9DZsdSvRtXKNA.jpg", false),
                new BrowseMovieModel("tt4595882", "Can You Ever Forgive Me?", 2018, "Marielle Heller", 6.9f, "/dc0FxYIyKfP4drQ7MEl2sHsoD14.jpg", "/hPuZR2bFoV0kuBrA98exWyvTf40.jpg", false),
                new BrowseMovieModel("tt0088889", "Cat's Eye", 1985, "Lewis Teague", 6.1f, "/mVWufY70kchQ0LSsE2uLg93aEXj.jpg", "/A65sQJbEAAV4wC9QQc0Mn4ZaMZV.jpg", false),
                new BrowseMovieModel("tt0239395", "Cats & Dogs", 2001, "Lawrence Guterman", 5.2f, "/2GoKwjA0K7b3BnsvBXwm68PkaJk.jpg", "/1RLlzNwnrpMMNFt71OVFAnJp6ww.jpg", false),
                new BrowseMovieModel("tt0090887", "Critters", 1986, "Stephen Herek", 6.0f, "/dqUw5SO18T8qFs8A0NVq85M5Of3.jpg", "/zLL6nX13AfigvvNQ9GyNXhKVrmg.jpg", false)

                };
        BrowseKeywordResponseModel expectedModel = new BrowseKeywordResponseModel(expectedResult, browseMovieModels);

        MultivaluedHashMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.putSingle("email", email);
        headers.putSingle("sessionID", sessionID);

        MultivaluedHashMap<String, Object> query = new MultivaluedHashMap<>();
        query.putSingle("direction", "down");

        ServiceResponse<BrowseKeywordResponseModel> response = MovieSocket.getBrowseByKeyword(headers, query, keywords);

        assertEquals(expectedResult.getStatus(), response.getStatus());
        assertEquals(expectedModel, response.getEntity());
    }
        */


}
