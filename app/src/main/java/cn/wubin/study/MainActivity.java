package cn.wubin.study;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TestKeyView key_volume_up, key_volume_down, key_left_scan, key_function, key_menu, key_back, key_right_scan;

    private int[] keyPressd = new int[7];

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        initView();
        for (int i = 0; i < 7; i++) {
            keyPressd[i] = -1;
        }

    }

    private void initView() {
        key_volume_up = findViewById(R.id.key_volume_up);
        key_volume_down = findViewById(R.id.key_volume_down);
        key_left_scan = findViewById(R.id.key_left_scan);
        key_function = findViewById(R.id.key_function);
        key_menu = findViewById(R.id.key_menu);
        key_back = findViewById(R.id.key_back);
        key_right_scan = findViewById(R.id.key_right_scan);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (count == 8) {
            finish();
        }
        if (count == 7) {
            Toast.makeText(this, "按任意键退出", Toast.LENGTH_LONG).show();
            count++;
        }


        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                key_volume_up.doDraw();
                countKey(0);
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                key_volume_down.doDraw();
                countKey(1);
                return true;
            case 102:
                key_left_scan.doDraw();
                countKey(2);
                return true;
            case 110:
                key_function.doDraw();
                countKey(3);
                return true;
            case KeyEvent.KEYCODE_MENU:
                key_menu.doDraw();
                countKey(4);
                return true;
            case KeyEvent.KEYCODE_BACK:
                key_back.doDraw();
                countKey(5);
                return true;
            case 103:
                key_right_scan.doDraw();
                countKey(6);
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void countKey(int key) {
        if (keyPressd[key] == -1) {
            keyPressd[key] = 1;
            count++;
        }
    }
}
