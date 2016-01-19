package app.anudroid.com.varte.RAL;

import java.util.ArrayList;
import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Entry;
import app.anudroid.com.varte.RAL.RALModels.Feeds;

/**
 * Created by anudeep on 1/19/2016.
 */
public class ApiServiceProcessor {
    public List<Entry> ProcessChannels(Feeds feeds) {
        List<Entry> en = new ArrayList<Entry>();
        for(app.anudroid.com.varte.RAL.RALModels.Entry entr : feeds.getQuery().getResults().getFeed().getEntry()) {
            Entry entry = new Entry();
            entry.Content = entr.getSummary().getContent();
            entry.TimeStamp = entr.getDate();
            entry.Title = entr.getTitle();
            en.add(entry);
        }
        return en;

    }
}
