package jnitest2.liyeyu.com.uitest;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jnitest2.liyeyu.com.uitest.entry.PersonUser;
import jnitest2.liyeyu.com.uitest.view.BmobManager;

public class RegisterActivity extends BaseActivity {

    private Button btn_register;
    private EditText et_name;
    private EditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_register = (Button) findViewById(R.id.btn_register);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userName = et_name.getText().toString();
                String password = et_pass.getText().toString();

                if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(password)){
                    return;
                }
                PersonUser person = new PersonUser();
                person.setUsername(userName);
                person.setPassword(password);
                person.setEmail("649268256@qq.com");
                BmobManager.register(RegisterActivity.this,person);
            }
        });
    }
}
