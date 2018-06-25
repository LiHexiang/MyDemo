package com.example.lihexiang.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lihexiang.mydemo.clockview.TimeClockView;

public class ClockActivity extends Activity {

    private TimeClockView clockView;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        clockView = (TimeClockView) findViewById(R.id.clockView);
        tvTime = (TextView) findViewById(R.id.tvTime);
        clockView.setOnTouchChangeListener(new TimeClockView.OnTouchChangeListener() {
            @Override
            public void onTimeChange(int hour, int minute) {
//                Toast.makeText(ClockActivity.this, "点击时间为：" + hour + "时" + minute + "分", Toast.LENGTH_SHORT).show();
                tvTime.setText(hour + ":" + minute);
            }
        });
    }
}
