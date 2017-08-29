package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private static final int RADIUS = 200;

    private Paint mPaint1, mPaint2, mPaint3;
    private List<DataModel> mDatas;

    private int sumValue;

    public Practice11PieChartView(Context context) {
        super(context);
        initData();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setColor(Color.WHITE);

        mPaint2 = new Paint(mPaint1);
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStrokeCap(Paint.Cap.ROUND);
        mPaint2.setStrokeWidth(5);

        mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint3.setColor(Color.YELLOW);
        mPaint3.setTextSize(36);
        mPaint3.setStrokeWidth(5);

        mDatas = new ArrayList<>();
        mDatas.add(new DataModel("aa", 100, Color.BLACK));
        mDatas.add(new DataModel("bb", 150, Color.DKGRAY));
        mDatas.add(new DataModel("cc", 50, Color.MAGENTA));
        mDatas.add(new DataModel("dd", 200, Color.GRAY));
        mDatas.add(new DataModel("ee", 30, Color.RED));
        mDatas.add(new DataModel("ff", 70, Color.LTGRAY));

        for (DataModel dataModel : mDatas) {
            sumValue += dataModel.value;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        canvas.translate(getWidth() / 2, getHeight() / 2);

        RectF rectF = new RectF(-RADIUS, -RADIUS, RADIUS, RADIUS);
        float startAngle = 0.0F;
        for (int i = 0, size = mDatas.size(); i < size; i++) {
            DataModel dataModel = mDatas.get(i);

            float sweepAngle = 360.0F * dataModel.value / sumValue;

            mPaint1.setColor(dataModel.color);
            if (i == size - 3) {

                canvas.save();
                canvas.translate(-20, -20);
                canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint1);
                canvas.restore();
            } else {
                canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint1);
            }
            double itemCenterAngle = startAngle + sweepAngle / 2;
            float pointX = (float) (Math.cos(itemCenterAngle * Math.PI / 180) * RADIUS);
            float pointY = (float) (Math.sin(itemCenterAngle * Math.PI / 180) * RADIUS);

            float lineY = (float) (Math.sin(itemCenterAngle * Math.PI / 180) * (RADIUS + 50));
            float lineX = (float) (Math.cos(itemCenterAngle * Math.PI / 180) * (RADIUS + 50));

            mPaint2.setColor(Color.YELLOW);
            float textWidth = mPaint3.measureText(dataModel.title);

            if (i == size - 3) {
                canvas.save();
                canvas.translate(-20, -20);
                canvas.drawPoint(pointX, pointY, mPaint2);
                canvas.drawLine(pointX, pointY, lineX, lineY, mPaint2);
                canvas.restore();
            } else {
                canvas.drawPoint(pointX, pointY, mPaint2);
                canvas.drawLine(pointX, pointY, lineX, lineY, mPaint2);
            }

            //画直线
            if (lineX < 0) {
                if (i == size - 3) {
                    canvas.save();
                    canvas.translate(-20, -20);
                    canvas.drawLine(lineX, lineY, -RADIUS - 50, lineY, mPaint2);
                    canvas.drawText(dataModel.title, -RADIUS - textWidth - 50, lineY, mPaint3);
                    canvas.restore();
                } else {
                    canvas.drawLine(lineX, lineY, -RADIUS - 50, lineY, mPaint2);
                    canvas.drawText(dataModel.title, -RADIUS - textWidth - 50, lineY, mPaint3);
                }
            } else {
                canvas.drawLine(lineX, lineY, RADIUS + 50, lineY, mPaint2);
                canvas.drawText(dataModel.title, RADIUS + 50, lineY, mPaint3);
            }

            startAngle += sweepAngle;
        }


        //x轴
        canvas.drawLine(-RADIUS - 100, 0, RADIUS + 100, 0, mPaint3);
        //y轴
        canvas.drawLine(0, -RADIUS - 100, 0, RADIUS + 100, mPaint3);
    }

    private class DataModel {
        public String title;
        public int value;
        public int color;

        public DataModel(String title, int value, int color) {
            this.title = title;
            this.value = value;
            this.color = color;
        }
    }
}

