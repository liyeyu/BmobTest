package jnitest2.liyeyu.com.uitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BmobPushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("cn.bmob.push.action.MESSAGE")) {
            Toast.makeText(context,
                    "客户端收到推送内容：" + intent.getStringExtra("msg"),
                    Toast.LENGTH_LONG).show();
        }
    }
}