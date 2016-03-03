package app.anudroid.com.varte.Views.ViewUtils.Adapters;

/**
 * Created by Anudeep on 22/12/15.
 */

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.RAL.RALModels.Entry_;
import app.anudroid.com.varte.RAL.RALModels.Link;
import app.anudroid.com.varte.RAL.RALModels.Query;

public class FeedSearchResultsAdapter extends RecyclerView.Adapter<FeedSearchResultsAdapter.DataObjectHolder> {
    private List<Entry_> mDataset;
    private static MyClickListener myClickListener;

    public FeedSearchResultsAdapter(List<Entry_> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.txtTitle.setText(Html.fromHtml(mDataset.get(position).getTitle()));
        holder.txtDescription.setText(Html.fromHtml(mDataset.get(position).getContentSnippet()));
        holder.txtFeedUrl.setText(mDataset.get(position).getUrl());
        if(mDataset.get(position).isAdded()) {
            holder.txtAlreadyAdded.setVisibility(View.VISIBLE);
            holder.btnAddFeed.setVisibility(View.GONE);
        } else {
            holder.btnAddFeed.setVisibility(View.VISIBLE);
            holder.txtAlreadyAdded.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtTitle, txtFeedUrl;
        TextView txtDescription;
        Button btnAddFeed;
        TextView txtAlreadyAdded;

        public DataObjectHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtFeedUrl = (TextView) itemView.findViewById(R.id.txtFeedUrl);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtAlreadyAdded = (TextView) itemView.findViewById(R.id.txtAlreadyAdded);
            btnAddFeed = (Button) itemView.findViewById(R.id.btnAddFeed);
            btnAddFeed.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }
}

