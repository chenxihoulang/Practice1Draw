package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private static final int RECT_SPACE = 50;
    private static final int RECT_WIDTH = 100;
    private static final int MAX_Y = 550;
    private static final int TEXT_MARGIN_TOP = 20;

    private Paint mPaint1, mPaint2, mPaint3;
    private List<DataModel> mDatas;

    public Practice10HistogramView(Context context) {
        super(context);
        initData();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setColor(Color.WHITE);

        mPaint2 = new Paint(mPaint1);
        mPaint2.setColor(Color.GREEN);
        mPaint2.setTextSize(22);

        mDatas = new ArrayList<>();
        mDatas.add(new DataModel("aa", 100));
        mDatas.add(new DataModel("bb", 150));
        mDatas.add(new DataModel("cc", 50));
        mDatas.add(new DataModel("dd", 400));
        mDatas.add(new DataModel("ee", 189));
        mDatas.add(new DataModel("ff", 489));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图


        int startX = 100;

        //y轴
        canvas.drawLine(startX, 50, startX, 550, mPaint1);
        //x轴
        canvas.drawLine(startX, 550, 1200, 550, mPaint1);


        for (DataModel dataModel : mDatas) {
            int left = startX + RECT_SPACE;
            int top = MAX_Y - dataModel.value;
            int right = left + RECT_WIDTH;
            int bottom = MAX_Y;

            canvas.drawRect(left, top, right, bottom, mPaint2);

            int textWidth = (int) mPaint2.measureText(dataModel.title);

            int textStartX = left + (RECT_WIDTH - textWidth) / 2;

            canvas.drawText(dataModel.title, textStartX, MAX_Y + TEXT_MARGIN_TOP, mPaint2);

            startX = right;
        }
    }

    private class DataModel {
        public String title;
        public int value;

        public DataModel(String title, int value) {
            this.title = title;
            this.value = value;
        }
    }
}
