package cn.wubin.study;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private MyLinearLayout ll;
    private Button bt;
    private TestKeyView num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);
        bt = findViewById(R.id.bt);
        num1 = findViewById(R.id.num1);
        ObjectAnimator animator = ObjectAnimator.ofFloat(bt, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_1){
            num1.doDraw();
            Toast.makeText(this,"1123",Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
