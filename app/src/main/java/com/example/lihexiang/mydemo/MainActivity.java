package com.example.lihexiang.mydemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lihexiang.mydemo.clockview.ClockActivity;
import com.example.lihexiang.mydemo.ruler.RulerViewActivity;
import com.example.lihexiang.mydemo.verticalviewpager.sample.VerticalViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private Button webTest;
    private Button flowLayout;
    private Button math;
    private Button clock;
    private Button ruler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        webTest = (Button) findViewById(R.id.webTest);
        flowLayout = (Button) findViewById(R.id.flowLayout);
        math = (Button) findViewById(R.id.math);
        clock = (Button) findViewById(R.id.clock);
        ruler = (Button) findViewById(R.id.ruler);

        initEvent();
    }

    private void initEvent() {
        webTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        flowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowLayoutActivity.class);
                startActivity(intent);
            }
        });

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MathActivity.class);
                startActivity(intent);
            }
        });
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClockActivity.class);
                startActivity(intent);
            }
        });

        ruler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RulerViewActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.verticalViewPager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VerticalViewPagerActivity.class);
                startActivity(intent);
            }
        });
    }
}
