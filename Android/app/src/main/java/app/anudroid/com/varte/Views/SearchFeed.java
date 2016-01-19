package app.anudroid.com.varte.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.ApiClient;
import app.anudroid.com.varte.RAL.ApiInterface;
import app.anudroid.com.varte.RAL.RALModels.Query;
import app.anudroid.com.varte.Store.StoreServiceImpl;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.FeedSearchResultsAdapter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchFeed extends AppCompatActivity {
    private TextView txtProgress;
    private EditText edtSearchFeed;
    private FeedSearchResultsAdapter mAdapter;
    private List<Query> lstfeed;
    private StoreServiceImpl storeService;

    public SearchFeed (){
        storeService = new StoreServiceImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_feeds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtProgress = (TextView) findViewById(R.id.txtprogress);
        edtSearchFeed = (EditText) findViewById(R.id.edtSearchFeed);
        searchFeedLink(edtSearchFeed.getText().toString().trim());
    }

    //temporary
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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}