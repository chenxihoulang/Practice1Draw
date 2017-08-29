package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint mPaint1;

    public Practice9DrawPathView(Context context) {
        super(context);
        initData();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint1.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawPath() 方法画心形

        Path path = new Path();
        RectF rectF = new RectF(100, 100, 200, 200);
        path.addArc(rectF, -225, 225);

        rectF = new RectF(200, 100, 300, 200);
        path.arcTo(rectF, -180, 225, false);

        path.lineTo(200, 250);

        canvas.drawPath(path, mPaint1);
    }
}
