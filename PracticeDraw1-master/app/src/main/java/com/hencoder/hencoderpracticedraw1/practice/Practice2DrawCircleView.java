package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint mPaint1, mPaint2, mPaint3, mPaint4;

    public Practice2DrawCircleView(Context context) {
        super(context);
        initData();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint1.setColor(Color.BLACK);


        mPaint2 = new Paint(mPaint1);
        mPaint2.setStyle(Paint.Style.STROKE);

        mPaint3 = new Paint(mPaint1);
        mPaint3.setColor(Color.BLUE);

        mPaint4 = new Paint(mPaint1);
        mPaint4.setStyle(Paint.Style.STROKE);
        mPaint4.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        canvas.drawCircle(100, 100, 50, mPaint1);

        canvas.drawCircle(200, 100, 50, mPaint2);

        canvas.drawCircle(100, 200, 50, mPaint3);

        canvas.drawCircle(200, 200, 50, mPaint4);
    }
}
