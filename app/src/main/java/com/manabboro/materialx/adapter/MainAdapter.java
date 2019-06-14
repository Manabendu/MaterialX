package com.manabboro.materialx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manabboro.materialx.R;

import java.util.List;

/**
 * Created by Manab Boro on 14,June,2019
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {
    private LayoutInflater inflater;
    private List<Item> mItemList;
    private OnItemClickListener listener;

    public MainAdapter(Context mContext, List<Item> mainItems) {
        inflater = LayoutInflater.from(mContext);
        mItemList = mainItems;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(inflater.inflate(R.layout.main_single_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int position) {
        itemViewHolder.bind(mItemList.get(position));
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public void setItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    //View holder
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.mTitle);
        }

        public void bind(Item item) {
            mTitle.setText(item.title);

        }
    }


    //Data model
    public static class Item {
        String title;

        public Item(String title) {
            this.title = title;
        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
