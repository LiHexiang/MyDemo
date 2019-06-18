package com.example.lihexiang.mydemo

import kotlinx.android.synthetic.main.activity_math.*
import android.app.Activity
import android.os.Bundle
import android.text.TextUtils

class MathActivity : Activity() {

    internal var a: Int = 0
    internal var b: Int = 0
    internal var c: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)
        initEvent()
    }

    private fun initEvent() {
        btOne.setOnClickListener {
            val one = etOne.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(one)) {
                a = Integer.parseInt(one)
            }
        }

        btTwo.setOnClickListener {
            val two = etTwo.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(two)) {
                b = Integer.parseInt(two)
            }
        }


        btThree.setOnClickListener {
            val three = etThree.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(three)) {
                val i = Integer.parseInt(three)
                c = i * b / a
                tvResult.text = c.toString() + ""
            }
        }
    }
}
