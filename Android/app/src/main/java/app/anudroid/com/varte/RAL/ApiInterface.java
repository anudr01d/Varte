package app.anudroid.com.varte.RAL;

import app.anudroid.com.varte.Models.Feeds;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Anudeep on 27/12/15.
 */
public interface ApiInterface {
    @GET("/v1/public/yql/")
    Observable<Feeds> feedList(@Query("q") String feedUrl, @Query("format") String feedFormat);
}
