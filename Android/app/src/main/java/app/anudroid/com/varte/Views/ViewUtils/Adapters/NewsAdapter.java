package app.anudroid.com.varte.Views.ViewUtils.Adapters;

/**
 * Created by Anudeep on 22/12/15.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.anudroid.com.varte.RAL.RALModels.Entry;
import app.anudroid.com.varte.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.DataObjectHolder> {
    private List<Entry> mDataset;
    private static MyClickListener myClickListener;

    public NewsAdapter(List<Entry> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.headLine.setText(mDataset.get(position).getTitle());
        holder.en = mDataset.get(position);
    }

    public void addItem(Entry dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v, Entry en);
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView headLine;
        Entry en;

        public DataObjectHolder(View itemView) {
            super(itemView);
            headLine = (TextView) itemView.findViewById(R.id.txtHeadLine);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v, en);
        }
    }
}

