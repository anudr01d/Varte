package app.anudroid.com.varte.RAL;

import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.RAL.RALModels.Query;

/**
 * Created by anudeep on 1/19/2016.
 */
public interface ApiService {
    public void downloadFeeds(List<Channel> feedUrls);
    public void searchFeedLink(String url);
}
