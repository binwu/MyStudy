package cn.wubin.study;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
    private static Context Instance;
    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
    }

    public static Context getMyApplicationContext(){
        return Instance;
    }
}
