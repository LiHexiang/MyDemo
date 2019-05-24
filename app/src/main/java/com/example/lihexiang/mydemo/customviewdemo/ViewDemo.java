package com.example.lihexiang.mydemo.customviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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

        paint.setStrokeWidth(8);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawRect(100,300,500,350,paint);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawRect(100,400,500,450,paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawRect(100,500,500,550,paint);

        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(android.R.mipmap.sym_def_app_icon);
        canvas.drawBitmap(drawable.getBitmap(),
                400,600,paint);


        Path path = new Path();
        paint.setStyle(Paint.Style.FILL);
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);

        canvas.drawPath(path,paint);
    }
}
