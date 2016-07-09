package jnitest2.liyeyu.com.uitest.entry;

import cn.bmob.v3.BmobUser;

/**
 * Created by Liyeyu on 2016/7/9.
 */
public class PersonUser extends BmobUser {
    @Override
    public String toString() {
        return "Person{" +
                "username='" + getUsername() +
                '}';
    }
}
