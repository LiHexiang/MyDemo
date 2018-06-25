package com.example.lihexiang.mydemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lihexiang.mydemo.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

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
        holder.flowLayout.setAdapter(new TagAdapter<String>(strs) {
            @Override
            public View getView(FlowLayout parent, int position, String str) {
                TextView tv = new TextView(holder.itemView.getContext());
                tv.setText(str);
                return tv;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "点击了item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TagFlowLayout flowLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            flowLayout = (TagFlowLayout) itemView.findViewById(R.id.flowLayout);
        }
    }
}
