package cn.wubin.study;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestKeyView extends View {
    public float RADIUS = 100f;// 圆的半径 = 100
    private Paint mPaint, linePaint, textPaint;// 绘图画笔
    private float startX = 0, startY = 0, stopX = 0, stopY = 0;

    public TestKeyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

        textPaint = new Paint(Paint.LINEAR_TEXT_FLAG);
        textPaint.setStrokeWidth((float) 100.0);
        textPaint.setTextSize(100f);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth((float) 10.0);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTestKeyView);
        stopX = typedArray.getFloat(R.styleable.MyTestKeyView_stopX, 0);
        stopY = typedArray.getFloat(R.styleable.MyTestKeyView_stopY, 0);

        startX = typedArray.getFloat(R.styleable.MyTestKeyView_startX, 0);
        startY = typedArray.getFloat(R.styleable.MyTestKeyView_startY, stopY);
        RADIUS = typedArray.getFloat(R.styleable.MyTestKeyView_circleSize, 50);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawLine(startX, startY, stopX, stopY, linePaint);
//        canvas.drawCircle(stopX, stopY, RADIUS, mPaint);
//        canvas.drawText("test", startX, startY, textPaint);
    }

    public void doDraw(){
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.BLUE);
        linePaint.setStrokeWidth((float) 10.0);
        Canvas canvas = new Canvas();
        canvas.drawLine(startX, startY, stopX, stopY, linePaint);
        canvas.drawCircle(stopX, stopY, RADIUS, mPaint);
        canvas.drawText("test", startX, startY, textPaint);
        draw(canvas);
    }
}
