package jnitest2.liyeyu.com.uitest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jnitest2.liyeyu.com.uitest.entry.PersonUser;
import jnitest2.liyeyu.com.uitest.view.BmobManager;

public class LoginActivity extends BaseActivity {

    private EditText et_name;
    private EditText et_pass;
    private Button btn_login;
    private TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);
        tv_register = (TextView) findViewById(R.id.tv_register);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
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
                BmobManager.login(person);
            }
        });
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
