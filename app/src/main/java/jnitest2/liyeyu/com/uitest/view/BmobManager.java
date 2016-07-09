package jnitest2.liyeyu.com.uitest.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import jnitest2.liyeyu.com.uitest.entry.PersonUser;
import jnitest2.liyeyu.com.uitest.entry.TestInfo;

/**
 * Created by Liyeyu on 2016/7/9.
 */
public class BmobManager {

    public static final String APP_ID = "af9b257e26741bede6fae47957cf4992";
    private static Context  mContext;
    public static BmobManager mManager;
    public static boolean DOWNLOADING = false;

    private BmobManager() {

    }

    public static BmobManager get(){
        if(mManager==null){
            synchronized (BmobManager.class){
                if(mManager==null){
                    mManager = new BmobManager();
                }
            }
        }
        return mManager;
    }

    public void init(Context context){
        mContext = context;
//        Bmob.initialize(context, APP_ID);
        BmobConfig bmobConfig = new BmobConfig.Builder(mContext)
                .setApplicationId(APP_ID)
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(10)
                //文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024*1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();

        Bmob.initialize(bmobConfig);
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation().save();
        // 启动推送服务
        BmobPush.startWork(mContext);
    }

    public static void insert(final BmobObject object){
        object.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    object.setObjectId(s);
                    toast("success id:"+s);
                }else{
                    toast("fail Exception:"+e.getMessage());
                }
            }
        });
    }
    public static void delete(BmobObject object,final String id){
        object.delete(id,new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    toast("success id:"+id);
                }else{
                    toast("fail Exception:"+e.getMessage());
                }
            }
        });
    }
    public static void update(BmobObject object,final String id){
        object.update(id,new UpdateListener() {
                @Override
                    public void done(BmobException e) {
                        if (e == null) {
                                toast("success id:"+id);
                            }else{
                                toast("fail Exception:"+e.getMessage());
                            }
                    }
            });
    }
    public static void query() {
        BmobQuery<TestInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<TestInfo>() {
            @Override
            public void done(List<TestInfo> list, BmobException e) {
                if (e == null&&list!=null&&list.size()>0) {
                    for (TestInfo p:list) {
                        toast("success :"+p.toString());
                    }
                }else{
                    toast("fail Exception:"+e.getMessage());
                }
            }
        });
    }

    public static void register(final Activity activity,PersonUser user) {
        user.signUp(new SaveListener<PersonUser>() {
            @Override
            public void done(PersonUser person, BmobException e) {
                if (e == null) {
                    toast("success :"+person.toString());
                    activity.finish();
                }else{
                    toast("fail Exception:"+e.getMessage());
                }
            }
        });
    }
    public static void login(PersonUser user) {
        user.login(new SaveListener<PersonUser>() {
            @Override
            public void done(PersonUser person, BmobException e) {
                if (e == null) {
                    toast("login success :"+person.toString());
                }else{
                    toast("fail Exception:"+e.getMessage());
                }
            }
        });
    }


    public static void upload(final String path) {
        BmobFile bmobFile = new BmobFile(new File(path));
        bmobFile.upload(new UploadFileListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    toast("upload success :" + path);
                } else {
                    toast("fail Exception:" + e.getMessage());
                }
            }
        });
    }
    public static void download(final String url, final Context context,final ImageView view) {
        if(DOWNLOADING){
            return;
        }
        DOWNLOADING  = true;
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/bmob/");
        if(!file.exists()){
            file.mkdirs();
        }
        BmobFile bmobFile = new BmobFile();
        bmobFile.setUrl(url);
        bmobFile.download(new File(file,System.currentTimeMillis()+".jpg"), new DownloadFileListener() {
            @Override
            public void done(String s, BmobException e) {
                DOWNLOADING  = false;
                if (e == null) {
                    toast("download success :" + s);
                    if(view!=null){
                        BitmapFactory.Options op = new BitmapFactory.Options();
                        op.inJustDecodeBounds = true;
                        op.inSampleSize = 2;
                        op.inJustDecodeBounds = false;
                        view.setImageBitmap(BitmapFactory.decodeFile(s,op));
                    }
                } else {
                    toast("fail Exception:" + e.getMessage());
                    dialog.dismiss();
                }
            }

            @Override
            public void onProgress(Integer integer, long l) {
                if(integer==100){
                    dialog.dismiss();
                }else{
                    dialog.setProgress(integer);
                }

            }
        });
    }

    public static void download(final String url,final Context context){
        download(url,context,null);
    }

    public static void toast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }
}
