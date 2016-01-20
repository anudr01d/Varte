package app.anudroid.com.varte.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import app.anudroid.com.varte.Application.Varte;
import app.anudroid.com.varte.Bus.RxBus;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.ApiClient;
import app.anudroid.com.varte.RAL.ApiInterface;
import app.anudroid.com.varte.RAL.ApiServiceImpl;
import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.RAL.RALModels.Query;
import app.anudroid.com.varte.Store.StoreServiceImpl;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.FeedSearchResultsAdapter;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.NewsAdapter;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class SearchFeed extends AppCompatActivity {
    private TextView txtProgress;
    private EditText edtSearchFeed;
    private FeedSearchResultsAdapter mAdapter;
    private List<Query> lstfeed;
    private StoreServiceImpl storeService;
    private ApiServiceImpl apiService;
    private RxBus _rxBus;
    private CompositeSubscription _subscriptions;
    private List<Query> lstquery;
    private RecyclerView mRecyclerView;
    private Button btngo;

    public SearchFeed (){
        storeService = new StoreServiceImpl();
        apiService = new ApiServiceImpl();
        _rxBus = Varte.getRxBusSingleton();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_feeds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtProgress = (TextView) findViewById(R.id.txtprogress);
        edtSearchFeed = (EditText) findViewById(R.id.edtSearchFeed);
        mRecyclerView = (RecyclerView) findViewById(R.id.search_results);
        btngo = (Button) findViewById(R.id.btngo);

        lstquery = new ArrayList<Query>();
        mAdapter = new FeedSearchResultsAdapter(lstquery);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtProgress.setVisibility(View.VISIBLE);
                apiService.searchFeedLink(edtSearchFeed.getText().toString().trim());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        _subscriptions = new CompositeSubscription();

        _subscriptions
                .add(_rxBus.toObserverable()
                        .subscribe(new Action1<Object>() {
                            @Override
                            public void call(Object event) {
                                if (event instanceof RxBus.RxEvent) {
                                    Query q = (Query)((RxBus.RxEvent) event).getObj();
                                    if(q!=null) {
                                        txtProgress.setVisibility(View.GONE);
                                        lstquery.add(q);
                                        mAdapter.notifyDataSetChanged();
                                    } else {
                                        txtProgress.setText("There was no feed found for the given url");
                                        txtProgress.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        }));
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