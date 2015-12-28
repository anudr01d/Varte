package app.anudroid.com.varte.RAL;

import com.squareup.okhttp.OkHttpClient;

import app.anudroid.com.varte.Models.Feed;
import app.anudroid.com.varte.Models.Feeds;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Anudeep on 26/12/15.
 */

public class ApiClient {
    public static <T> T createRetrofitService(final Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://query.yahooapis.com")
                    .client(new OkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
            T service = retrofit.create(clazz);

        return service;
    }
}
