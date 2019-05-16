package com.example.lihexiang.mydemo.verticalviewpager.sample;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lihexiang.mydemo.R;

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentView(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContentView content = (ContentView) holder;
        content.textView.setText("content" + position);
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ContentView extends RecyclerView.ViewHolder {

        private TextView textView;

        public ContentView(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.context_text);
        }
    }
}
