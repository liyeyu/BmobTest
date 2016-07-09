package jnitest2.liyeyu.com.uitest;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import jnitest2.liyeyu.com.uitest.view.BmobManager;

public class FileActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_upload;
    private Button btn_download;
    private ImageView iv_display;
    String imagePath = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1468060074250&di=343ff188adbda53f3ab7dacfbcd1b292&imgtype=jpg&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F908fa0ec08fa513d17b6a2ea386d55fbb2fbd9e2.jpg";
    String filePath = "http://www.bmob.cn/static/Bmob_android_quickstart.zip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        iv_display = (ImageView) findViewById(R.id.iv_display);
        btn_upload = (Button) findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(this);
        btn_download = (Button) findViewById(R.id.btn_download);
        btn_download.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        //上传
        case R.id.btn_upload:
        BmobManager.upload(Environment.getExternalStorageDirectory()+"/bmob/1468050667790.jpg");
        break;
        //下载
        case R.id.btn_download:
        BmobManager.download(imagePath,FileActivity.this,iv_display);
        break;
    }
    }
}
