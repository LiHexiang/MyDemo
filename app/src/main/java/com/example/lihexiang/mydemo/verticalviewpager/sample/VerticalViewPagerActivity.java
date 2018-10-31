package com.example.lihexiang.mydemo.verticalviewpager.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lihexiang.mydemo.R;
import com.example.lihexiang.mydemo.verticalviewpager.VerticalViewPager;
import com.example.lihexiang.mydemo.verticalviewpager.transforms.StackTransformer;
import com.example.lihexiang.mydemo.verticalviewpager.transforms.ZoomOutTransformer;


public class VerticalViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_viewpager);
        setTitle("");
        initViewPager();
    }

    private void initViewPager() {
        VerticalViewPager viewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        viewPager.setPageTransformer(false, new ZoomOutTransformer());
//        viewPager.setPageTransformer(true, new StackTransformer());
        String title = "ContentFragment";
        viewPager.setAdapter(new ContentFragmentAdapter.Holder(getSupportFragmentManager())
                .add(ContentFragment.newInstance(title, 1))
                .add(ContentFragment.newInstance(title, 2))
                .add(ContentFragment.newInstance(title, 3))
                .add(ContentFragment.newInstance(title, 4))
                .add(ContentFragment.newInstance(title, 5))
                .set());
        //If you setting other scroll mode, the scrolled fade is shown from either side of display.
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }
}
