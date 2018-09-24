package com.example.admin.weather.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by randiwaranugraha on 1/14/17.
 */

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {

    private final Context context;

    private final View view;

    public BaseRecyclerViewHolder(Context context, int resource, ViewGroup parent) {
        this(context,
            LayoutInflater.from(context).inflate(resource, parent, false));
    }

    public BaseRecyclerViewHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.view = itemView;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        if (view != null && onItemClickListener != null) {
            view.setOnClickListener(v -> onItemClickListener.onItemClick(getAdapterPosition()));
        }
    }

    public Context getContext() {
        return context;
    }

    public abstract void bindData(T data);

    public interface OnItemClickListener {

        void onItemClick(int position);
    }
}