package com.yunfei.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yunfei on 16/7/10.
 */
public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {

    private final List<T> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateItemViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindItemViewHolder((VH) holder, mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T t, int position);
    }

    public void addAll(Collection<? extends T> collection) {
        mList.addAll(collection);
        notifyDataSetChanged();
    }

    public void clear() {
        mList.clear();
    }


    protected abstract void onBindItemViewHolder(VH holder, T t, int position);

    protected abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);
}
