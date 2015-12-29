package app.anudroid.com.varte.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.anudroid.com.varte.Adapters.ChannelsAdapter;
import app.anudroid.com.varte.Adapters.NewsAdapter;
import app.anudroid.com.varte.Models.Entry;
import app.anudroid.com.varte.Models.Feed;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.ApiClient;
import app.anudroid.com.varte.RAL.ApiInterface;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsDetail extends AppCompatActivity {
    TextView content;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_view);
        content = (TextView) findViewById(R.id.txtContent);
        title = (TextView) findViewById(R.id.txtTitle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        displayData();
    }

    private void displayData(){
        Bundle bun = getIntent().getBundleExtra("NewsBundle");
        Entry entry = Parcels.unwrap(bun.getParcelable("News"));
        title.setText(entry.getTitle());
        content.setText(entry.getSummary().getContent());
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