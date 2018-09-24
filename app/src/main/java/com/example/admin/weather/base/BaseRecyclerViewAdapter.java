package com.example.admin.weather.base;

import com.example.admin.weather.base.BaseRecyclerViewHolder;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by randiwaranugraha on 1/14/17.
 */

public abstract class BaseRecyclerViewAdapter<VH extends BaseRecyclerViewHolder<T>, T> extends
    RecyclerView.Adapter<VH> {

    private List<T> items;

    private BaseRecyclerViewHolder.OnItemClickListener onItemClickListener;

    public BaseRecyclerViewHolder.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        if (items != null) {
            this.items = items;
            notifyDataSetChanged();
        }
    }

    public T getItem(int position) {
        if (position < getItemSize()) {
            return items.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return getItemSize();
    }

    private int getItemSize() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(getItem(position));
        holder.setOnItemClickListener(getOnItemClickListener());
    }
}