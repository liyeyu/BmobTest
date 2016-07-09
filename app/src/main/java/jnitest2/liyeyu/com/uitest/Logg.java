package jnitest2.liyeyu.com.uitest;

import android.util.Log;

/**
 * Created by Liyeyu on 2016/7/9.
 */
public class Logg {
    public static final boolean DEBUG = false;
    public static void i(String tag,String msg){
        if(DEBUG)
            Log.i(tag, msg);
    }
}
