package app.anudroid.com.varte.Business;

import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Entry;

/**
 * Created by Anudeep on 21/01/16.
 */
public interface FeedService {
    public void AddOrUpdateFeed(Channel channel);
    public void DeleteFeed(int channelId);
    public List<Channel> getFeedList(boolean refresh);
    public List<Entry> getEntries(Channel ch);
    public void UpdateRefreshTimestamp(String timeStamp);
    public boolean AddFeedToPreference(String key, List<String> lstprefs);
    public List<String> GetFeedFromPreference(String key);
    public void searchFeedLink(String keyword);
}
