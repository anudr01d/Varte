package app.anudroid.com.varte.Models;

/**
 * Created by Anudeep on 22/12/15.
 */
public class Channel {
    private String _channelName;

    public Channel(String channelName){
        _channelName = channelName;
    }

    public String get_channelName() {
        return _channelName;
    }

    public void set_channelName(String _channelName) {
        this._channelName = _channelName;
    }
}