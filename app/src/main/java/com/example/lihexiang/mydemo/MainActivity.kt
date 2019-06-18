package com.example.lihexiang.mydemo

import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lihexiang.mydemo.clockview.ClockActivity
import com.example.lihexiang.mydemo.customviewdemo.CustomViewActivity
import com.example.lihexiang.mydemo.ruler.RulerViewActivity
import com.example.lihexiang.mydemo.util.CommonUtil
import com.example.lihexiang.mydemo.verticalviewpager.sample.VerticalViewPagerActivity
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.beta.upgrade.UpgradeListener

class MainActivity : AppCompatActivity() {

    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        initUpdate()
        initEvent()
    }

    private fun initUpdate() {
        //        Beta.upgradeDialogLayoutId = R.layout.dialog_update_upgrade;
//        Beta.tipsDialogLayoutId = R.layout.dialog_update_tips;

        /*在application中初始化时设置监听，监听策略的收取*/
        Beta.upgradeListener = UpgradeListener { ret, strategy, isManual, isSilence ->
            if (strategy != null) {
                val i = Intent()
                i.setClass(applicationContext, UpgradeActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(i)
            } else {
                Toast.makeText(context, "没有更新", Toast.LENGTH_LONG).show()
            }
        }

        //初始化bugly 不放在程序启动时 而是放在MainActivity处！
        Bugly.init(this, "900043002", false)
    }

    private fun initEvent() {
        tv_version.setText("versionCode==>" + CommonUtil.getVersionCode(context)
                + "versionName==>" + CommonUtil.getVersionName(context))

        bt_update.setOnClickListener { Beta.checkUpgrade() }

        webTest.setOnClickListener { }

        flowLayout.setOnClickListener {
            val intent = Intent(context, FlowLayoutActivity::class.java)
            startActivity(intent)
        }


        math.setOnClickListener {
            val intent = Intent(context, MathActivity::class.java)
            startActivity(intent)

        }
        clock.setOnClickListener {
            val intent = Intent(context, ClockActivity::class.java)
            startActivity(intent)

        }

        ruler.setOnClickListener {
            val intent = Intent(context, RulerViewActivity::class.java)
            startActivity(intent)
        }

        verticalViewPager.setOnClickListener {
            val intent = Intent(context, VerticalViewPagerActivity::class.java)
            startActivity(intent)
        }

        viewDemo.setOnClickListener {
            val intent = Intent(context, CustomViewActivity::class.java)
            startActivity(intent)
        }


    }
}