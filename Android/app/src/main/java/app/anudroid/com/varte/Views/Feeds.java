package app.anudroid.com.varte.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.anudroid.com.varte.Views.ViewUtils.Adapters.ChannelsAdapter;
import app.anudroid.com.varte.Views.ViewUtils.Adapters.NewsAdapter;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.ApiClient;
import app.anudroid.com.varte.RAL.ApiInterface;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
    private List<app.anudroid.com.varte.RAL.RALModels.Feeds> lstfeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.feed_list);
        txtProgress = (TextView) findViewById(R.id.txtprogress);
        lstfeed = new ArrayList<app.anudroid.com.varte.RAL.RALModels.Feeds>();
        mAdapter = new ChannelsAdapter(this,lstfeed);
        mListView.setAdapter(mAdapter);
        downloadData();
    }

    private void downloadData(){
        lstfeed.clear();
        for(String url : urls) {
            ApiInterface service = ApiClient.createRetrofitService(ApiInterface.class);
            service.feedList(String.format("select * from feednormalizer where url='%1$s' and output='atom_1.0'", url), "json")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<app.anudroid.com.varte.RAL.RALModels.Feeds>() {
                        @Override
                        public final void onCompleted() {

                        }

                        @Override
                        public final void onError(Throwable e) {
                            Log.e("Varte", e.getMessage());
                        }

                        @Override
                        public final void onNext(app.anudroid.com.varte.RAL.RALModels.Feeds response) {
                            lstfeed.add(response);
                            if(lstfeed.size()==7) {
                                txtProgress.setVisibility(View.GONE);
                                sortFeed();
                                mAdapter.notifyDataSetChanged();
                            } else {
                                txtProgress.setText(lstfeed.size() + " Feed(s) loaded..");
                            }
                        }
                    });
        }
    }

    private void sortFeed() {
        Collections.sort(lstfeed, new Comparator<app.anudroid.com.varte.RAL.RALModels.Feeds>() {
            public int compare(app.anudroid.com.varte.RAL.RALModels.Feeds left, app.anudroid.com.varte.RAL.RALModels.Feeds right) {
                return Integer.compare(urls.indexOf(left.getQuery().getMeta().getUrl().getId()), urls.indexOf(right.getQuery().getMeta().getUrl().getId()));
            }
        });
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