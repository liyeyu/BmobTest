package jnitest2.liyeyu.com.uitest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import jnitest2.liyeyu.com.uitest.Logg;

/**
 * Created by Liyeyu on 2016/7/7.
 */
public class TestRelativeLayout extends RelativeLayout {
    public TestRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logg.i("TestRelativeLayout", "onInterceptTouchEvent-- action=" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Logg.i("TestRelativeLayout","dispatchTouchEvent-- action=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logg.i("TestRelativeLayout", "onTouchEvent-- action=" + event.getAction());
        return super.onTouchEvent(event);
    }

}
