package cn.wubin.study;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {
    private Context mContext;

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (MotionEvent.ACTION_DOWN == ev.getAction()) {
            Log.i("wb", "linearlayout touch down");
        } else if (MotionEvent.ACTION_UP == ev.getAction()) {
            Log.i("wb", "linearlayout touch up");
            return true;
        } else {
            Log.i("wb", "linearlayout touch action" + ev.getAction());
        }


        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("wb", "onTouchEvent");
        return false;
    }

    //    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return super.dispatchTouchEvent(ev);
//    }
}
