package app.anudroid.com.varte.Adapters;

/**
 * Created by Anudeep on 22/12/15.
 */
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.anudroid.com.varte.Models.Channel;
import app.anudroid.com.varte.Models.Feed;
import app.anudroid.com.varte.Models.News;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.Utils.DividerItemDecoration;

public class ChannelsAdapter extends BaseAdapter {
    private static LayoutInflater inflater=null;
    int i=0;
    private List<Feed> mDataset;
    private NewsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    RecyclerView.ItemDecoration itemDecoration;

    public ChannelsAdapter(Context activity, List<Feed> d) {
        mDataset = d;
        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public int getCount() {
        return mDataset.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
        RecyclerView channel;
        TextView channelName;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){
            vi = inflater.inflate(R.layout.channel_item, null);

            holder = new ViewHolder();
            holder.channel = (RecyclerView) vi.findViewById(R.id.channel);
            holder.channelName = (TextView) vi.findViewById(R.id.txtChannelName);

            vi.setTag( holder );
        }
        else {
            holder = (ViewHolder) vi.getTag();
            if(mDataset!=null) {
                Feed feed = (Feed) mDataset.get(position);
                if (feed != null) {
                    mAdapter = new NewsAdapter(feed.getEntry());
                    mLayoutManager = new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    itemDecoration = new DividerItemDecoration(parent.getContext(), LinearLayoutManager.HORIZONTAL);
                    holder.channel.setLayoutManager(mLayoutManager);
                    holder.channel.setAdapter(mAdapter);
                    holder.channelName.setText(feed.getTitle() != null ? feed.getTitle() : "Null");
                    holder.channel.setHasFixedSize(true);
                    holder.channel.addItemDecoration(itemDecoration);
                }
            }
        }
        return vi;
    }
}