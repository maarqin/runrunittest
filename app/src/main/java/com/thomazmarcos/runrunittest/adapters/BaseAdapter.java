package com.thomazmarcos.runrunittest.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by thomaz on 16/03/18.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> tList;
    protected int line;
    protected Context context;

    public BaseAdapter(@NonNull List<T> tList, @LayoutRes int line, Context context) {
        this.tList = tList;
        this.line = line;
        this.context = context;
    }

    public BaseAdapter(@NonNull List<T> tList, @LayoutRes int line) {
        this.tList = tList;
        this.line = line;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        // createOrUpdate a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(line, parent, false);

        return getViewHolder(v);
    }

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    @Override
    public int getItemCount() {
        return tList.size();
    }

    /**
     * @param v View
     * @return VH
     */
    protected abstract VH getViewHolder(View v);

    /**
     * @param items {@link List}
     */
    public void add(List<T> items) {
        // int previousDataSize = tList.size();
        tList.addAll(items);
        // notifyItemRangeInserted(previousDataSize, items.size());
        notifyDataSetChanged();
    }

}
