package app.anudroid.com.varte.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.anudroid.com.varte.Application.Varte;
import app.anudroid.com.varte.Bus.RxBus;
import app.anudroid.com.varte.Business.FeedServiceImpl;
import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.RAL.RALModels.Query;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.ChannelsAdapter;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.NewsAdapter;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.ApiClient;
import app.anudroid.com.varte.RAL.ApiInterface;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Feeds extends AppCompatActivity {

    private ListView mListView;
    private TextView txtProgress;
    private ChannelsAdapter mAdapter;
    private NewsAdapter mNewsAdapter;
    List<String> urls = Arrays.asList(
            "http://news.ycombinator.com/rss",
            "http://feeds.feedburner.com/2dopeboyz",
            "http://feeds2.feedburner.com/NdtvNews-TopStories",
            "http://timesofindia.feedsportal.com/c/33039/f/533917/index.rss",
            "http://www.forbes.com/real-time/feed2/",
            "https://www.ovoforums.com/forums/-/index.rss",
            "http://rss.slashdot.org/Slashdot/slashdotMain");
    private FeedServiceImpl feedimpl;
    private List<app.anudroid.com.varte.RAL.RALModels.Feeds> lstfeed;
    private List<Channel> lstchannels;
    private RxBus _rxBus;
    private CompositeSubscription _subscriptions;

    public Feeds() {
        feedimpl = new FeedServiceImpl();
        _rxBus = Varte.getRxBusSingleton();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListView = (ListView) findViewById(R.id.feed_list);
        txtProgress = (TextView) findViewById(R.id.txtprogress);
        lstfeed = new ArrayList<app.anudroid.com.varte.RAL.RALModels.Feeds>();
        lstchannels = new ArrayList<Channel>();
        mAdapter = new ChannelsAdapter(this,lstchannels);
        mListView.setAdapter(mAdapter);

        ShowSearchOrFeeds();
    }

    private void ShowSearchOrFeeds() {
        List<String> lstfeeds = feedimpl.GetFeedFromPreference("prefkey");
        if(lstfeeds==null || lstfeeds.size()==0) {
            startActivity(new Intent(this, SearchFeed.class));
            finish();
        } else {
            lstchannels = feedimpl.getFeedList(false);
            mAdapter = new ChannelsAdapter(Feeds.this,lstchannels);
            mListView.setAdapter(mAdapter);
            txtProgress.setVisibility(View.GONE);
        }
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
                                    lstchannels = feedimpl.getFeedList(false);
                                    mAdapter = new ChannelsAdapter(Feeds.this,lstchannels);
                                    mListView.setAdapter(mAdapter);
                                    txtProgress.setVisibility(View.GONE);
                                } else {
                                    txtProgress.setVisibility(View.VISIBLE);
                                }
                            }
                        }));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feeds, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_search:
                startActivity(new Intent(this, SearchFeed.class));
                finish();
                return true;

            case R.id.action_refresh:
                feedimpl.getFeedList(true);
                return true;

            case R.id.action_edit:
                enableRemoveFeed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void enableRemoveFeed() {

    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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