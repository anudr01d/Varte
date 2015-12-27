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


/*
public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.DataObjectHolder> {
    private List<Feed> mDataset;
    private static MyClickListener myClickListener;
    private LinearLayoutManager mLayoutManager;
    private NewsAdapter mAdapter;
    RecyclerView.ItemDecoration itemDecoration;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        RecyclerView channel;
        TextView channelName;

        public DataObjectHolder(View itemView) {
            super(itemView);
            channel = (RecyclerView) itemView.findViewById(R.id.channel);
            channelName = (TextView) itemView.findViewById(R.id.txtChannelName);
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public ChannelsAdapter(List<Feed> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channel_item, parent, false);

        mLayoutManager = new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL, false);
        itemDecoration = new DividerItemDecoration(parent.getContext(), LinearLayoutManager.HORIZONTAL);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        if(mDataset.get(position)!=null) {
            mAdapter = new NewsAdapter(mDataset.get(position).getEntry());
            if (holder.channel.getLayoutManager() == null) {
                holder.channel.setLayoutManager(mLayoutManager);
            }
            holder.channel.setAdapter(mAdapter);
            holder.channelName.setText(mDataset.get(position).getTitle() == null ? mDataset.get(position).getTitle() : "Null");
            holder.channel.setHasFixedSize(true);
            holder.channel.addItemDecoration(itemDecoration);
        }
    }

    public void addItem(Feed dataObj) {
        mDataset.add(dataObj);
        notifyDataSetChanged();
        //notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    public void clearData() {
        this.mDataset.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
 */