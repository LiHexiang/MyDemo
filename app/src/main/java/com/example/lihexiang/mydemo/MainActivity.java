package com.example.lihexiang.mydemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lihexiang.mydemo.clockview.ClockActivity;
import com.example.lihexiang.mydemo.ruler.RulerViewActivity;
import com.example.lihexiang.mydemo.util.CommonUtil;
import com.example.lihexiang.mydemo.verticalviewpager.sample.VerticalViewPagerActivity;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.upgrade.UpgradeListener;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TextView tvVersion;

    private Button update;
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

        findView();

        initUpdate();

        initEvent();
    }

    private void findView() {
        tvVersion = findViewById(R.id.tv_version);
        update = findViewById(R.id.bt_update);
        webTest = findViewById(R.id.webTest);
        flowLayout = findViewById(R.id.flowLayout);
        math = findViewById(R.id.math);
        clock = findViewById(R.id.clock);
        ruler = findViewById(R.id.ruler);
    }

    private void initUpdate() {
//        Beta.upgradeDialogLayoutId = R.layout.dialog_update_upgrade;
//        Beta.tipsDialogLayoutId = R.layout.dialog_update_tips;

        /*在application中初始化时设置监听，监听策略的收取*/
        Beta.upgradeListener = new UpgradeListener() {
            @Override
            public void onUpgrade(int ret, UpgradeInfo strategy, boolean isManual, boolean isSilence) {
                if (strategy != null) {
                    Intent i = new Intent();
                    i.setClass(getApplicationContext(), UpgradeActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "没有更新", Toast.LENGTH_LONG).show();
                }
            }
        };

        //初始化bugly 不放在程序启动时 而是放在MainActivity处！
        Bugly.init(this, "900043002", false);
    }

    private void initEvent() {

        tvVersion.setText("versionCode==>" + CommonUtil.getVersionCode(this)
                + "versionName==>" + CommonUtil.getVersionName(this));
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Beta.checkUpgrade();
            }
        });

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
