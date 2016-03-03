package app.anudroid.com.varte.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import app.anudroid.com.varte.Application.Varte;
import app.anudroid.com.varte.Bus.RxBus;
import app.anudroid.com.varte.Business.FeedServiceImpl;
import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.RAL.RALModels.Entry_;
import app.anudroid.com.varte.RAL.RALModels.Link;
import app.anudroid.com.varte.RAL.RALModels.Query;
import app.anudroid.com.varte.RAL.RALModels.QueryResult;
import app.anudroid.com.varte.RAL.RALModels.ResponseData;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.FeedSearchResultsAdapter;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class SearchFeed extends AppCompatActivity {
    private TextView txtProgress;
    private EditText edtSearchFeed;
    private FeedSearchResultsAdapter mAdapter;
    private FeedServiceImpl feedService;
    private RxBus _rxBus;
    private CompositeSubscription _subscriptions;
    private List<Entry_> lstquery;
    private RecyclerView mRecyclerView;

    public SearchFeed (){
        feedService = new FeedServiceImpl();
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
        edtSearchFeed.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    txtProgress.setVisibility(View.VISIBLE);
                    feedService.searchFeedLink(edtSearchFeed.getText().toString().trim());
                    return true;
                }
                return false;
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.search_results);


        lstquery = new ArrayList<Entry_>();
        mAdapter = new FeedSearchResultsAdapter(lstquery);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        mAdapter.setOnItemClickListener(new FeedSearchResultsAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                List<String> lstfeeds = feedService.GetFeedFromPreference("prefkey");
                if(lstfeeds==null) {
                    lstfeeds = new ArrayList<String>();
                }
                //show dialog to edit the title
                    lstfeeds.add(lstquery.get(position).getUrl());
                    Channel ch = new Channel();
                    ch.Title = lstquery.get(position).getTitle();
                    ch.url = lstquery.get(position).getUrl();
                    feedService.AddOrUpdateFeed(ch);
                    feedService.AddFeedToPreference("prefkey", lstfeeds);
                startActivity(new Intent(SearchFeed.this, Feeds.class));
                finish();
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
                                    Object obj = ((RxBus.RxEvent) event).getObj();
                                    if(obj instanceof ResponseData) {
                                        ResponseData q = (ResponseData)obj;
                                        if (q != null) {
                                            try {
                                                txtProgress.setVisibility(View.GONE);
                                                List<String> lstfeeds = feedService.GetFeedFromPreference("prefkey");
//                                                String strlnk = q. getResults().getLink();
//                                                ObjectMapper mapper = new ObjectMapper()
//                                                        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//                                                List<Link> lstlnk = mapper.readValue(strlnk, new TypeReference<List<Link>>() {
//                                                });
                                                lstquery.clear();
                                                List<Entry_> lstlnk = q.getEntries();
                                                for (Entry_ lnk : lstlnk) {
                                                    if (lstfeeds != null && lstfeeds.contains(lnk.getUrl())) {
                                                        lnk.setAdded(true);
                                                    } else {
                                                        lnk.setAdded(false);
                                                    }
                                                    lstquery.add(lnk);
                                                }
                                            }catch (Exception e) {e.printStackTrace();}

                                        }
                                        mAdapter.notifyDataSetChanged();
                                    }
                                    } else {
                                        txtProgress.setText("There was no feed found for the given url");
                                        txtProgress.setVisibility(View.VISIBLE);
                                    }
                                }
                            }));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SearchFeed.this,Feeds.class));
        finish();
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