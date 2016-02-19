package app.anudroid.com.varte.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import org.parceler.Parcels;

import app.anudroid.com.varte.Entry;
import app.anudroid.com.varte.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NewsDetail extends AppCompatActivity {
    TextView content;
    //WebView webcontent;
    Toolbar toolbar;
    TextView txtTitle;
    TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_view);
        content = (TextView) findViewById(R.id.txtContent);
        //webcontent = (WebView) findViewById(R.id.webContent);
        txtTitle= (TextView) findViewById(R.id.txtTitle);
        txtDate = (TextView) findViewById(R.id.txtDate);
        displayData();
    }

    private void displayData(){
        try {
            Bundle bun = getIntent().getBundleExtra("NewsBundle");
            Entry entry = Parcels.unwrap(bun.getParcelable("News"));
            txtTitle.setText(entry.Title);
            txtDate.setText(entry.TimeStamp);
            content.setText(stripHtml(entry.Content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CharSequence stripHtml(String s) {
        return Html.fromHtml(s).toString().replace('\n', (char) 32)
                .replace((char) 160, (char) 32).replace((char) 65532, (char) 32).trim();
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