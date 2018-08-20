package cn.wubin.study;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestKeyView extends View {
    public float RADIUS = 100f;// 圆的半径 = 100
    private String text = "key";
    private Paint mPaint, linePaint, textPaint;// 绘图画笔
    private float startX = 0, startY = 0, stopX = 0, stopY = 0;
    private Canvas mCanvas;

    public TestKeyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

        textPaint = new Paint(Paint.LINEAR_TEXT_FLAG);
        textPaint.setStrokeWidth((float) 100.0);
        textPaint.setTextSize(30f);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth((float) 10.0);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTestKeyView);
        stopX = typedArray.getFloat(R.styleable.MyTestKeyView_stopX, 0);
        stopY = typedArray.getFloat(R.styleable.MyTestKeyView_stopY, 0) - 50;

        startX = typedArray.getFloat(R.styleable.MyTestKeyView_startX, 0);
        startY = typedArray.getFloat(R.styleable.MyTestKeyView_startY, stopY);
        RADIUS = typedArray.getFloat(R.styleable.MyTestKeyView_circleSize, 50);
        text = typedArray.getString(R.styleable.MyTestKeyView_text);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        canvas.drawLine(startX, startY, stopX, stopY, linePaint);
//        canvas.drawCircle(stopX, stopY, RADIUS, mPaint);
        Rect rect = new Rect((int) (stopX - RADIUS), (int) (stopY - RADIUS), (int) (stopX + RADIUS), (int) (stopY + RADIUS));
        canvas.drawRect(rect, mPaint);
        float pointX = startX, pointY = startY;
        pointX = startX > stopX ? stopX : startX;
        pointY = startY > stopY ? stopY : startY;
        canvas.drawText(text, pointX, pointY, textPaint);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }

    public void doDraw() {
//        if(mCanvas == null) return;
        Canvas canvas = new Canvas();
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.GREEN);
        linePaint.setStrokeWidth((float) 10.0);
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(startX, startY, stopX, stopY, linePaint);
        canvas.drawCircle(stopX, stopY, RADIUS, mPaint);
        float pointX = startX, pointY = startY;
//        if(startX > stopX){
//            pointX = (startX + stopX)/2L;
//        }
//        if(startY > stopY){
//            pointY = (startY + stopY)/2L;
//        }
        pointX = startX > stopX ? stopX : startX;
        pointY = startY > stopY ? stopY : startY;
        canvas.drawText(text, pointX, pointY, textPaint);
        draw(canvas);
        invalidate();
    }
}
