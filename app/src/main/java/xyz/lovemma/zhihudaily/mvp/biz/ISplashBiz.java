package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.LaunchImage;

/**
 * Created by OO on 2017/3/11.
 */

public interface ISplashBiz {
    Observable<LaunchImage> getLaunchImage();
}
