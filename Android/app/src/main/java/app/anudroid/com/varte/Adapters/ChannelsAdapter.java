package app.anudroid.com.varte.Adapters;

/**
 * Created by Anudeep on 22/12/15.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.parceler.Parcels;
import java.util.List;
import app.anudroid.com.varte.Models.Entry;
import app.anudroid.com.varte.Models.Feeds;
import app.anudroid.com.varte.R;
import app.anudroid.com.varte.Views.NewsDetail;

public class ChannelsAdapter extends BaseAdapter {
    private static LayoutInflater inflater=null;
    int i=0;
    private List<Feeds> mDataset;
    private NewsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    RecyclerView.ItemDecoration itemDecoration;
    Feeds feed;
    int parent_position;

    public ChannelsAdapter(Context activity, List<Feeds> d) {
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
        Feeds lstFeed;
        int vh_pos;
    }
    public View getView(int position, View convertView, final ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;
        int i=0;

        if(convertView==null){
            vi = inflater.inflate(R.layout.channel_item, null);

            holder = new ViewHolder();
            holder.channel = (RecyclerView) vi.findViewById(R.id.channel);
            holder.channelName = (TextView) vi.findViewById(R.id.txtChannelName);
            vi.setTag( holder );
        }
        else {
            holder = (ViewHolder) vi.getTag();
        }
        if(mDataset!=null) {
            feed = (Feeds) mDataset.get(position);
            if (feed != null) {
                if(holder.lstFeed==null) {
                    holder.lstFeed = feed;
                }
                    mAdapter = new NewsAdapter(feed.getQuery().getResults().getFeed().getEntry());
                    mLayoutManager = new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false);
                    holder.channel.setLayoutManager(mLayoutManager);
                    holder.channel.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListener(new NewsAdapter.MyClickListener() {
                        @Override
                        public void onItemClick(int pos, View v, Entry en) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("News", Parcels.wrap(en));
                            v.getContext().startActivity(new Intent(v.getContext(), NewsDetail.class).putExtra("NewsBundle", bundle));
                        }
                    });
                    holder.channelName.setText(feed.getQuery().getResults().getFeed().getTitle() != null ? feed.getQuery().getResults().getFeed().getTitle() : "Null");
                    holder.channel.setHasFixedSize(true);
                }
        }
        return vi;
    }
}