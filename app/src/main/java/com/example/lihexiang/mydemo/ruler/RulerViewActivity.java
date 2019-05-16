package com.example.lihexiang.mydemo.ruler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lihexiang.mydemo.R;

public class RulerViewActivity extends AppCompatActivity {

    private TextView tvSelectHeight;
    private TextView tvSelectWeight;
    private TextView tvSelectHeadCir;

    private RulerView rulerHeight;
    private RulerView rulerWeight;
    private RulerView rulerHeadCir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler_view);

        rulerHeight = (RulerView) findViewById(R.id.rulerHeight);
        rulerWeight = (RulerView) findViewById(R.id.rulerWeight);
        rulerHeadCir = (RulerView) findViewById(R.id.rulerHeadCir);

        tvSelectHeight = (TextView) findViewById(R.id.tvSelectHeight);
        tvSelectWeight = (TextView) findViewById(R.id.tvSelectWeight);
        tvSelectHeadCir = (TextView) findViewById(R.id.tvSelectHeadCir);


        tvSelectHeight.setText("45.0");
        rulerHeight.setValue(40, 10, 120, 1);
        rulerHeight.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tvSelectHeight.setText(value + "");
            }
        });

        tvSelectWeight.setText("2.5");
        rulerWeight.setValue(2.5f, 0, 30, 0.1f);
        rulerWeight.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tvSelectWeight.setText(value + "");
            }
        });

        tvSelectHeadCir.setText("45.0");
        rulerHeadCir.setValue(40, 10, 120, 1);
        rulerHeadCir.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tvSelectHeadCir.setText(value + "");
            }
        });

    }
}
