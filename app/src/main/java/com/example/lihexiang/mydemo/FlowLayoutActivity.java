package com.example.lihexiang.mydemo;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lihexiang.mydemo.adapter.FlowlayotuAdapter;

/**
 * Created by LiHexiang on 2017/11/23.
 */

public class FlowLayoutActivity extends Activity {


    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        initView();
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));

        FlowlayotuAdapter adapter = new FlowlayotuAdapter();
        mRecyclerView.setAdapter(adapter);
    }
}
