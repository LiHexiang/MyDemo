package com.example.lihexiang.mydemo.clockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.PI;

/*
 * 项目名:   AndroidHeros
 * 包名:     com.zsy.androidheros.view
 * 文件名:   TimeClock
 * 创建者:   李鹤翔
 * 创建时间: 2018年3月29日17:22:06
 * 描述:     绘制时钟
 */
public class TimeClockView extends View {

    //表盘上所要显示的时间-小时
    private int hour;
    //表盘上所要显示的时间-分钟
    private int minute;


    //表盘画笔
    private Paint paintBackgrund;
    //刻度文字画笔
    private Paint paintNum;
    //刻度点画笔
    private Paint paintPoint;
    //圆心画笔
    private Paint paintCenter;
    //时钟画笔
    private Paint paintHour;
    //分钟画笔
    private Paint paintMinute;
    //外圆圆心
    private float x, y;
    //外圆半径
    private int r;

    //手指落下的坐标
    private int fingerX = 0;
    private int fingerY = 0;

    //记录的最后一次改变的坐标
    private int oldX;
    private int oldY;

    //时针所在的角度
    private int hourDegree;
    //分针所在的角度
    private int minuteDegree;

    //手指所在位置的角度
    private int fingerDegree;


    public TimeClockView(Context context) {
        super(context);
        initPaint();
    }

    public TimeClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public TimeClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    private void initPaint() {

        paintBackgrund = new Paint();
        paintBackgrund.setColor(Color.WHITE);
        paintBackgrund.setAntiAlias(true);
        paintBackgrund.setStyle(Paint.Style.FILL);

        paintNum = new Paint();
        paintNum.setColor(Color.parseColor("#A2A2A2"));
        paintNum.setAntiAlias(true);
        paintNum.setTextSize(35);
        paintNum.setStrokeWidth(4);
        paintNum.setStyle(Paint.Style.FILL);
        paintNum.setTextAlign(Paint.Align.CENTER);

        paintPoint = new Paint();
        paintPoint.setColor(Color.parseColor("#CFCFCF"));
        paintPoint.setAntiAlias(true);
        paintPoint.setStyle(Paint.Style.FILL);

        paintCenter = new Paint();
        paintCenter.setColor(Color.parseColor("#FEBD7E"));
        paintCenter.setAntiAlias(true);
        paintCenter.setStrokeWidth(5);
        paintCenter.setStyle(Paint.Style.FILL);

        paintMinute = new Paint();
        paintMinute.setColor(Color.parseColor("#FEBD7E"));
        paintMinute.setAntiAlias(true);
        paintMinute.setStrokeWidth(10);
        paintMinute.setStyle(Paint.Style.FILL);

        paintHour = new Paint();
        paintHour.setColor(Color.parseColor("#FEBD7E"));
        paintHour.setAntiAlias(true);
        paintHour.setStrokeWidth(12);
        paintHour.setStyle(Paint.Style.FILL);

        getCurrentTime();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        x = width / 2;
        y = height / 2;
        r = (int) x - 5;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制白色背景
        canvas.drawCircle(x, y, r, paintBackgrund);
        //绘制整点
        drawText(canvas);
        //绘制圆心
        canvas.drawCircle(x, y, 20, paintCenter);
        //绘制时针和分针
        drawTime(canvas);
    }


    /**
     * 绘制整点数字
     *
     * @param canvas 画布
     */
    private void drawText(Canvas canvas) {
        // 获取文字高度用于设置文本垂直居中
        float textSize = (paintNum.getFontMetrics().bottom - paintNum.getFontMetrics().top);
        // 数字离圆心的距离,40为刻度的长度,20文字大小
        int distance = r - 20;
        // 数字的坐标(a,b)
        float a, b;
        // 每30°写一个数字
        for (int i = 0; i < 12; i++) {
            a = (float) (distance * Math.sin(i * 30 * PI / 180) + x);
            b = (float) (y - distance * Math.cos(i * 30 * PI / 180));
            if (i == 0) {
                canvas.drawText("12", a, b + textSize / 3, paintNum);
            } else if (i == 3) {
                canvas.drawText("3", a, b + textSize / 3, paintNum);
            } else if (i == 6) {
                canvas.drawText("6", a, b + textSize / 3, paintNum);
            } else if (i == 9) {
                canvas.drawText("9", a, b + textSize / 3, paintNum);
            } else {
                canvas.drawCircle(a, b, 5, paintPoint);
            }
        }
    }

    /**
     * 获取系统当前时间
     */
    private void getCurrentTime() {
        try {
            //获取系统当前时间
            SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
            String time = format.format(new Date(System.currentTimeMillis()));
            String[] split = time.split("-");
            hour = Integer.parseInt(split[0]);
            minute = Integer.parseInt(split[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制时针和分针
     *
     * @param canvas 画布
     */
    private void drawTime(Canvas canvas) {

        //时针走过的角度
        hourDegree = hour * 30 + minute / 2;
        //分针走过的角度
        minuteDegree = minute * 6;

        //绘制时钟,以12整点为0°参照点
        canvas.rotate(hourDegree, x, y);
//        canvas.drawLine(x, y, x, y - r + 120, paintHour);
        RectF recHour = new RectF();
        recHour.left = x - 6;
        recHour.top = 120;
        recHour.right = x + 6;
        recHour.bottom = r;
//        canvas.drawRoundRect(x - 3, 120, 6, r - 120, 3, 3, paintHour);
        canvas.drawRoundRect(recHour, 6, 6, paintHour);

        canvas.save();
        canvas.restore();
        //这里画好了时钟，我们需要再将画布转回来,继续以12整点为0°参照点
        canvas.rotate(-hourDegree, x, y);

        //绘制分钟
        canvas.rotate(minuteDegree, x, y);
//        canvas.drawLine(x, y, x, y - r + 60, paintMinute);
        RectF rectMinute = new RectF();
        rectMinute.left = x - 6;
        rectMinute.top = 60;
        rectMinute.right = x + 6;
        rectMinute.bottom = r;
//        canvas.drawRoundRect(x - 3, 120, 6, r - 120, 3, 3, paintHour);
        canvas.drawRoundRect(rectMinute, 6, 6, paintHour);
        canvas.save();
        canvas.restore();
        //这里同上
        canvas.rotate(-minuteDegree, x, y);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldX = (int) event.getX();
                oldY = (int) event.getY();
                calculateClickDegree();
                break;
            case MotionEvent.ACTION_MOVE:
                fingerX = (int) event.getX();
                fingerY = (int) event.getY();
                calculateMoveDegree();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;
    }


    /**
     * 计算手指按下的位置和当前分针位置是否一致
     * 一致则不处理，不一致，就切换分针到手指按下位置
     */
    public void calculateClickDegree() {
        int r = (int) Math.sqrt(Math.pow(Math.abs(oldX - x), 2) + Math.pow(Math.abs(oldY - y), 2));
        if (r < 50) {
            //如果点击位置距离圆心太近，忽略
//            Toast.makeText(getContext(), "无效点击范围", Toast.LENGTH_SHORT).show();
            return;
        }
        int rx = oldX - (int) x;
        int ry = -(oldY - (int) y);

        Point point = new Point(rx, ry);

        int degree = DegreeUtil.GetRadianByPos(point);
        //排除小于6度的滑动
        if (354 < Math.abs(degree - minuteDegree) || Math.abs(degree - minuteDegree) < 6) {
            return;
        }
        if (minuteDegree <= 180) {
            if (degree < minuteDegree) {
                minute = minute - (minuteDegree - degree) / 6;
            } else {
                if ((degree - minuteDegree) <= 180) {
                    minute = minute + (degree - minuteDegree) / 6;
                } else {
                    minute = minute + (degree - minuteDegree) / 6;
                    hour = hour - 1;
                }
            }
        } else {
            if (degree > minuteDegree) {
                minute = minute + (degree - minuteDegree) / 6;
            } else {
                if ((minuteDegree - degree) <= 180) {

                    minute = minute - (minuteDegree - degree) / 6;
                } else {
                    minute = minute - (minuteDegree - degree) / 6;
                    hour = hour + 1;
                }
            }
        }
        if (hour == 24) {
            hour = 0;
        }
        if (hour == -1) {
            hour = 23;
        }

        invalidate();
        if (onTouchChangeListener != null) {
            onTouchChangeListener.onTimeChange(hour, minute);
        }

    }

    /**
     * 计算手指滑动到的位置和当前分针位置是否一致
     * 一致则不处理，不一致，就切换分针到手指按下位置
     */
    public void calculateMoveDegree() {
//        int r = (int) Math.sqrt(Math.pow(Math.abs(oldX - x), 2) + Math.pow(Math.abs(oldY - y), 2));
//        if (r < 50) {
//            //如果点击位置距离圆心太近，忽略
////            Toast.makeText(getContext(), "无效点击范围", Toast.LENGTH_SHORT).show();
//            return;
//        }
        int rx = fingerX - (int) x;
        int ry = -(fingerY - (int) y);

        Point point = new Point(rx, ry);

        int degree = DegreeUtil.GetRadianByPos(point);
        //排除小于6度的滑动
        if (354 < Math.abs(degree - minuteDegree) || Math.abs(degree - minuteDegree) < 6) {
            return;
        }
        if (minuteDegree <= 180) {
            if (degree < minuteDegree) {
                minute = minute - (minuteDegree - degree) / 6;
            } else {
                if ((degree - minuteDegree) <= 180) {
                    minute = minute + (degree - minuteDegree) / 6;
                } else {
                    minute = minute + (degree - minuteDegree) / 6;
                    hour = hour - 1;
                }
            }
        } else {
            if (degree > minuteDegree) {
                minute = minute + (degree - minuteDegree) / 6;
            } else {
                if ((minuteDegree - degree) <= 180) {

                    minute = minute - (minuteDegree - degree) / 6;
                } else {
                    minute = minute - (minuteDegree - degree) / 6;
                    hour = hour + 1;
                }
            }
        }
        if (hour == 24) {
            hour = 0;
        }
        if (hour == -1) {
            hour = 23;
        }

        invalidate();
        if (onTouchChangeListener != null) {
            onTouchChangeListener.onTimeChange(hour, minute);
        }

        //更新最后一次改变的分针位置
        oldX = fingerX;
        oldY = fingerY;

    }


    //设置监听相关代码
    public interface OnTouchChangeListener {
        void onTimeChange(int hour, int minute);
    }

    OnTouchChangeListener onTouchChangeListener;

    public void setOnTouchChangeListener(OnTouchChangeListener onTouchChangeListener) {
        this.onTouchChangeListener = onTouchChangeListener;
    }
}
