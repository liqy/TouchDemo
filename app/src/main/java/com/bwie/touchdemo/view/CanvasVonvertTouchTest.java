package com.bwie.touchdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.gcssloop.view.CustomView;
import com.gcssloop.view.utils.CanvasAidUtils;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/10 20:49
 */

public class CanvasVonvertTouchTest extends CustomView {
    float down_x = -1;
    float down_y = -1;

    public CanvasVonvertTouchTest(Context context) {
        this(context, null);
    }

    public CanvasVonvertTouchTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                down_x = event.getX();
                down_y = event.getY();
                invalidate();
                break;

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                down_x = down_y = -1;
                invalidate();
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float x = down_x;
        float y = down_y;

        drawTouchCoordinateSpace(canvas);       // 绘制触摸坐标系 灰色

        // ▼注意画布平移
        canvas.translate(mViewWidth / 2, mViewHeight / 2);

        drawTranslateCoordinateSpace(canvas);    // 绘制平移后的坐标系，红色

        if (x == -1 && y == -1) return;          // 如果没有就返回

        canvas.drawCircle(x, y, 20, mDeafultPaint); // 在触摸位置绘制一个小圆
    }

    /**
     * 绘制触摸坐标系，灰色，为了能够显示出坐标系，将坐标系位置稍微偏移了一点
     */
    private void drawTouchCoordinateSpace(Canvas canvas) {
        canvas.save();
        canvas.translate(10, 10);
        CanvasAidUtils.set2DAxisLength(1000, 0, 1400, 0);
        CanvasAidUtils.setLineColor(Color.GRAY);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
        canvas.restore();
    }

    /**
     * 绘制平移后的坐标系，红色
     */
    private void drawTranslateCoordinateSpace(Canvas canvas) {
        CanvasAidUtils.set2DAxisLength(500, 500, 700, 700);
        CanvasAidUtils.setLineColor(Color.RED);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
        CanvasAidUtils.draw2DCoordinateSpace(canvas);
    }
}
