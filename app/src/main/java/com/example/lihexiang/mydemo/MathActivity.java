package com.example.lihexiang.mydemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MathActivity extends Activity {

    EditText etOne;
    EditText etTwo;
    EditText etThree;

    Button btONe;
    Button btTwo;
    Button btThree;

    TextView tvResult;

    int a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        etOne = (EditText) findViewById(R.id.etOne);
        etTwo = (EditText) findViewById(R.id.etTwo);
        etThree = (EditText) findViewById(R.id.etThree);

        btONe = (Button) findViewById(R.id.btOne);
        btTwo = (Button) findViewById(R.id.btTwo);
        btThree = (Button) findViewById(R.id.btThree);

        tvResult = (TextView) findViewById(R.id.tvResult);

        initEvent();
    }

    private void initEvent() {
        btONe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = etOne.getText().toString().trim();
                if (!TextUtils.isEmpty(one)) {
                    a = Integer.parseInt(one);
                }
            }
        });

        btTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String two = etTwo.getText().toString().trim();
                if (!TextUtils.isEmpty(two)) {
                    b = Integer.parseInt(two);
                }
            }
        });


        btThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String three = etThree.getText().toString().trim();
                if (!TextUtils.isEmpty(three)) {
                    int i = Integer.parseInt(three);
                    c = i * b / a;
                    tvResult.setText(c + "");
                }
            }
        });
    }
}
