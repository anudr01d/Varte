package app.anudroid.com.varte.RAL;

import app.anudroid.com.varte.RAL.RALModels.Feeds;
import app.anudroid.com.varte.RAL.RALModels.QueryResult;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Anudeep on 27/12/15.
 */
public interface ApiInterface {
    @GET("/v1/public/yql/")
    Observable<Feeds> feedList(@Query("q") String feedUrl, @Query("format") String feedFormat);

    @GET("/v1/public/yql/psychemedia/feedautodetect")
    Observable<app.anudroid.com.varte.RAL.RALModels.Feeds> getFeedLink(@Query("url") String siteUrl, @Query("format") String feedFormat);

    @GET("/uds/GfindFeeds")
    Observable<QueryResult> searchFeed(@Query("context") String context, @Query("hl") String hl, @Query("q") String q, @Query("v") String v, @Query("nocache") String nocache);
}

//http://query.yahooapis.com/v1/public/yql/psychemedia/feedautodetect?url=www.2dopeboyz.com&format=json

//http://www.google.com/uds/GfindFeeds?context=0&hl=en&q=ycombinator&v=1.0&nocache=1455882913868