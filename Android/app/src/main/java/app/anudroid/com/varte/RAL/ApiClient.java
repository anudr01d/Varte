package app.anudroid.com.varte.RAL;

import com.squareup.okhttp.OkHttpClient;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

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
