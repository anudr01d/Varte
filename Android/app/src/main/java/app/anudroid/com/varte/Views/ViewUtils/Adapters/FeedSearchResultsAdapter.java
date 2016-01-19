package app.anudroid.com.varte.Views.ViewUtils.Adapters;

/**
 * Created by Anudeep on 22/12/15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import app.anudroid.com.varte.R;
import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.RAL.RALModels.Query;

public class FeedSearchResultsAdapter extends RecyclerView.Adapter<FeedSearchResultsAdapter.DataObjectHolder> {
    private List<Query> mDataset;
    private static MyClickListener myClickListener;

    public FeedSearchResultsAdapter(List<Query> myDataset) {
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
        holder.txtTitle.setText(mDataset.get(position).getResults().getLink().getTitle());
        holder.txtDescription.setText(mDataset.get(position).getResults().getLink().getTitle());
        holder.btnAddFeed.setVisibility(View.VISIBLE);
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
        TextView txtTitle;
        TextView txtDescription;
        Button btnAddFeed;
        TextView txtAlreadyAdded;

        public DataObjectHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            txtAlreadyAdded = (TextView) itemView.findViewById(R.id.txtAlreadyAdded);
            btnAddFeed = (Button) itemView.findViewById(R.id.btnAddFeed);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }
}

