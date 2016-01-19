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
    public List<Channel> getFeedList();
    public List<Entry> getEntries(Channel ch);
    public void UpdateRefreshTimestamp(String timeStamp);
}
