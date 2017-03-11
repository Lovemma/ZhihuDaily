package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.LaunchImage;

/**
 * Created by OO on 2017/3/11.
 */

public interface ISplashView {
    void onRequestError();

    void getLaunchImage(LaunchImage launchImage);

    void onRequestEnd();
}
