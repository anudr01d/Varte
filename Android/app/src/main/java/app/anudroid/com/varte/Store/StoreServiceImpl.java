package app.anudroid.com.varte.Store;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.anudroid.com.varte.Channel;
import app.anudroid.com.varte.Channel_Table;
import app.anudroid.com.varte.Entry;
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
    public void DeleteFeed(int channelId) {
        SQLite.delete(Channel.class)
                .where(Channel_Table.ChannelId.is(channelId))
                .query();
    }
    public List<Channel> getFeedList(){
        List<Channel> lstChan = SQLite.select().from(Channel.class).queryList();
        if(RefreshTimeStamp().equals("1"))
            apimpl.downloadFeeds(lstChan);//needs to be asynchronous
        return lstChan;
    }
    public List<Entry> getEntries(Channel ch){
        return ch.getAllEntries();
    }
    public void UpdateRefreshTimestamp(String timeStamp){
    }
    public String RefreshTimeStamp() {
        //fetch timestamp from shared preferences.
        Date d = new Date();
        return d.toString();
    }
}
