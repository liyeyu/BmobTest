package jnitest2.liyeyu.com.uitest;

import android.app.Application;

import jnitest2.liyeyu.com.uitest.view.BmobManager;

/**
 * Created by Liyeyu on 2016/7/9.
 */
public class UIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BmobManager.get().init(this);
    }
}
