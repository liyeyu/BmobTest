package jnitest2.liyeyu.com.uitest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import jnitest2.liyeyu.com.uitest.Logg;

/**
 * Created by Liyeyu on 2016/7/7.
 */
public class TestButton extends Button {
    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Logg.i("TestButton","dispatchTouchEvent "+event.getAction()+"  TestButton");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logg.i("TestButton","onTouchEvent "+event.getAction()+"  TestButton");
        return super.onTouchEvent(event);
    }
}
