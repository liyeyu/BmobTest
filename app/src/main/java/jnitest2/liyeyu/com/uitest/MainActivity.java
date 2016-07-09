package jnitest2.liyeyu.com.uitest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import jnitest2.liyeyu.com.uitest.entry.TestInfo;
import jnitest2.liyeyu.com.uitest.view.BmobManager;
import jnitest2.liyeyu.com.uitest.view.TestButton;
import jnitest2.liyeyu.com.uitest.view.TestRelativeLayout;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {

    private Button btn_add, btn_update, btn_delete, btn_query;
    private TestInfo mPerson;
    private Button btn_login;
    private Button btn_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestButton button = (TestButton) findViewById(R.id.btn_send);
        TestRelativeLayout parent = (TestRelativeLayout) findViewById(R.id.rl_main);
        button.setOnClickListener(this);
        button.setOnTouchListener(this);
        parent.setOnClickListener(this);
        parent.setOnTouchListener(this);
        parent.setEnabled(false);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_query.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(this);
        mPerson = new TestInfo();
        mPerson.setUsername("liyeyu");
        mPerson.setPassword("123456");
    }

    @Override
    public void onClick(View v) {
        Logg.i(v.getClass().getSimpleName(), "onClick " + v.getClass().getSimpleName());
        switch (v.getId()) {
            //添加数据
            case R.id.btn_add:
                BmobManager.insert(mPerson);
                break;
            //更新数据
            case R.id.btn_update:
                mPerson.setUsername("liyeyu12");
                BmobManager.update(mPerson,mPerson.getObjectId());
                break;
            //删除数据
            case R.id.btn_delete:
                BmobManager.delete(mPerson,mPerson.getObjectId());
                break;
            //查询数据
            case R.id.btn_query:
                BmobManager.query();
                break;
            //登陆
            case R.id.btn_login:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
            //上传
            case R.id.btn_upload:
                startActivity(new Intent(MainActivity.this,FileActivity.class));
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Logg.i(v.getClass().getSimpleName(), "onTouch " + event.getAction());
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logg.i("MainActivity", "--dispatchTouchEvent--action=" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onUserInteraction() {
        Logg.i("MainActivity", "--onUserInteraction");
        super.onUserInteraction();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logg.i("MainActivity", "--onTouchEvent--action=" + event.getAction());
        return super.onTouchEvent(event);
    }
}
