package app.anudroid.com.varte.Store;

import com.orhanobut.hawk.Hawk;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Channel_Table;
import app.anudroid.com.varte.Entry;
import app.anudroid.com.varte.Entry_Table;
import app.anudroid.com.varte.RAL.ApiServiceImpl;

/**
 * Created by anudeep on 1/18/2016.
 */
public class StoreServiceImpl implements StoreService{
    ApiServiceImpl apimpl;
    public StoreServiceImpl(){
        apimpl = new ApiServiceImpl();
    }

    public void AddOrUpdateFeed(Channel channel) {
        if(channel.ChannelId!=0) {
            channel.update();
        } else {
            channel.insert();
        }
    }

    public void clearEntries(Channel channel) {
        SQLite.delete(Entry.class)
                .where(Entry_Table.channelForeignKeyContainer_ChannelId.is(channel.ChannelId))
                .query();
    }

    public void DeleteFeed(int channelId) {
        SQLite.delete(Channel.class)
                .where(Channel_Table.ChannelId.is(channelId))
                .query();
    }
    public List<Channel> getFeedList(boolean refresh){
        List<Channel> lstChan = SQLite.select().from(Channel.class).queryList();
        for(Channel ch : lstChan) {
            if(ch.getAllEntries()==null || ch.getAllEntries().size()==0 || refresh) {
                apimpl.downloadFeed(ch);//needs to be asynchronous
            }
        }

        return lstChan;
    }
    public List<Entry> getEntries(Channel ch){
        return ch.getAllEntries();
    }
    public void UpdateRefreshTimestamp(String timeStamp){
    }
    public String RefreshTimeStamp(String timestampKey) {
        String timestamp = Hawk.get(timestampKey);
        Date d = new Date();
        return d.toString();
    }

    public void searchFeedLink(String keyword) {
        apimpl.searchFeedLink(keyword);
    }

    public boolean AddFeedToPreference(String key, List<String> lstprefs) {
        return Hawk.put(key, lstprefs);
    }

    public List<String> GetFeedFromPreference(String key) {
        return Hawk.get(key);
    }
}
