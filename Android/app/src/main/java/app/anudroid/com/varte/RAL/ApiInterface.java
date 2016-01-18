package app.anudroid.com.varte.RAL;

import app.anudroid.com.varte.RAL.RALModels.Feeds;
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
    Observable<app.anudroid.com.varte.RAL.RALModels.Query> getFeedLink(@Query("url") String siteUrl, @Query("format") String feedFormat);
}

//http://query.yahooapis.com/v1/public/yql/psychemedia/feedautodetect?url=www.2dopeboyz.com&format=json