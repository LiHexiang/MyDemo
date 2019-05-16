package com.example.lihexiang.mydemo.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.lihexiang.mydemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiHexiang on 2017/11/23.
 */

public class FlowlayotuAdapter extends RecyclerView.Adapter<FlowlayotuAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item_flowlayout, null);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        List<String> strs = new ArrayList<>();
        strs.add("标签1");
        strs.add("标签2");
        strs.add("标签3");

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
