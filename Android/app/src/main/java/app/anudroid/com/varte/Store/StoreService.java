package app.anudroid.com.varte.Store;

import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Entry;

/**
 * Created by anudeep on 1/18/2016.
 */
public interface StoreService {
    public void AddOrUpdateFeed(Channel channel);
    public void DeleteFeed(int channelId);
    public List<Channel> getFeedList(boolean refresh);
    public List<Entry> getEntries(Channel ch);
    public void UpdateRefreshTimestamp(String timeStamp);
    public String RefreshTimeStamp(String timestampKey);
    public boolean AddFeedToPreference(String key, List<String> lstprefs);
    public List<String> GetFeedFromPreference(String key);
    public void searchFeedLink(String keyword);
    public void clearEntries(Channel channel);
}
