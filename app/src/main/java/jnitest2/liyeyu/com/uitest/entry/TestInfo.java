package jnitest2.liyeyu.com.uitest.entry;

import cn.bmob.v3.BmobObject;

/**
 * Created by Liyeyu on 2016/7/9.
 */
public class TestInfo extends BmobObject {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
