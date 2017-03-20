package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.bean.LaunchImage;

/**
 * Created by OO on 2017/3/11.
 */

public class SplashBiz {
    public Observable<LaunchImage> getLaunchImage() {
        return ApiManage.getInstance().getCommonApi().getLaunchImage();
    }
}
