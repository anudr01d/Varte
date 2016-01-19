package app.anudroid.com.varte.RAL;

import android.util.Log;
import android.view.View;

import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.RAL.RALModels.Feeds;
import app.anudroid.com.varte.RAL.RALModels.Query;
import app.anudroid.com.varte.Store.StoreService;
import app.anudroid.com.varte.Store.StoreServiceImpl;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by anudeep on 1/18/2016.
 */
public class ApiServiceImpl implements ApiService {
    private StoreServiceImpl storeService;
    private ApiServiceProcessor processor;

    public ApiServiceImpl() {
        storeService = new StoreServiceImpl();
        processor = new ApiServiceProcessor();
    }

    public void downloadFeeds(List<Channel> feedUrls) {
        for (final Channel ch : feedUrls) {
            ApiInterface service = ApiClient.createRetrofitService(ApiInterface.class);
            service.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", ch.url), "json")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Feeds>() {
                        @Override
                        public final void onCompleted() {
                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("Varte", e.getMessage());
                        }

                        @Override
                        public final void onNext(app.anudroid.com.varte.RAL.RALModels.Feeds response) {
                            //save the channels within the db.
                            ch.entries = processor.ProcessChannels(response);
                            storeService.AddOrUpdateFeed(ch);
                        }
                    });
        }
    }

    public void searchFeedLink(String url) {
        ApiInterface service = ApiClient.createRetrofitService(ApiInterface.class);
        service.getFeedLink(url, "json")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Query>() {
                    @Override
                    public final void onCompleted() {

                    }

                    @Override
                    public final void onError(Throwable e) {
                        Log.e("Varte", e.getMessage());
                    }

                    @Override
                    public final void onNext(Query response) {
                        //notify someone that there is new data. preferably ui

                    }
                });
    }
}
