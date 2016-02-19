package app.anudroid.com.varte.Business;

import com.orhanobut.hawk.Hawk;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Entry;
import app.anudroid.com.varte.RAL.ApiServiceImpl;
import app.anudroid.com.varte.Store.StoreServiceImpl;

/**
 * Created by anudeep on 1/18/2016.
 */
public class FeedServiceImpl implements FeedService {
    StoreServiceImpl storeimpl;

    public FeedServiceImpl() {
        storeimpl = new StoreServiceImpl();
    }

    public void AddOrUpdateFeed(Channel channel) {
        storeimpl.AddOrUpdateFeed(channel);
    }
    public void DeleteFeed(int channelId) {
        storeimpl.DeleteFeed(channelId);
    }
    public List<Channel> getFeedList(boolean refresh){
        return storeimpl.getFeedList(refresh);
    }
    public List<Entry> getEntries(Channel ch){
        return storeimpl.getEntries(ch);
    }
    public void UpdateRefreshTimestamp(String timeStamp){
    }
    public String RefreshTimeStamp(String timestampkey) {
        return storeimpl.RefreshTimeStamp(timestampkey);
    }

    public boolean AddFeedToPreference(String key, List<String> lstprefs) {
        return storeimpl.AddFeedToPreference(key, lstprefs);
    }

    public List<String> GetFeedFromPreference(String key) {
        return storeimpl.GetFeedFromPreference(key);
    }

    public void searchFeedLink(String keyword) {
        storeimpl.searchFeedLink(keyword);
    }

}
