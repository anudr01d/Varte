package app.anudroid.com.varte.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import org.parceler.Parcels;

import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.R;

public class NewsDetail extends AppCompatActivity {
    TextView content;
    Toolbar toolbar;
    TextView txtTitle;
    TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_view);
        content = (TextView) findViewById(R.id.txtContent);
        txtTitle= (TextView) findViewById(R.id.txtTitle);
        txtDate = (TextView) findViewById(R.id.txtDate);
        displayData();
    }

    private void displayData(){
        try {
            Bundle bun = getIntent().getBundleExtra("NewsBundle");
            Entry entry = Parcels.unwrap(bun.getParcelable("News"));
            txtTitle.setText(entry.getTitle());
            txtDate.setText(entry.getDate());
            content.setText(Html.fromHtml(entry.getSummary().getContent(),null,null));
//            content.setText(Html.fromHtml(entry.getSummary().getContent(), new Html.ImageGetter() {
//                @Override
//                public Drawable getDrawable(String source) {
//                    Drawable drawFromPath;
//                    int path = getResources().getIdentifier(source, "drawable", getPackageName());
//                    try {
//                        drawFromPath = (Drawable) getResources().getDrawable(path);
//                    } catch (Exception e) {
//                        return null;
//                    }
//                    drawFromPath.setBounds(0, 0, drawFromPath.getIntrinsicWidth(), drawFromPath.getIntrinsicHeight());
//                    return drawFromPath;
//                }
//            }, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
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