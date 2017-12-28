package com.example.macbookpro.mvp.untils;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Macbookpro on 2017/11/30.
 */

public class App extends Application {
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    public void onCreate() {
        super.onCreate();
        //友盟让你使用了
        UMShareAPI.get(this);
        //把错误信息给你提示出来
        Config.DEBUG = true;
    }
}
