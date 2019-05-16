package com.example.lihexiang.mydemo.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ViewDemo extends View {
    public ViewDemo(Context context) {
        super(context);
    }

    public ViewDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(30);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100,100,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(200,100,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(300,100,paint);

        paint.setStrokeWidth(8);
        paint.setTextSize(40);

        canvas.drawText("这是画出来的文字哦n(*≧▽≦*)n",350,100,paint);


        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100,200,60,paint);
        canvas.drawCircle(200,200,60,paint);
        canvas.drawCircle(300,200,60,paint);
        canvas.drawCircle(400,200,60,paint);
    }
}
