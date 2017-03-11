package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.bean.LaunchImage;
import xyz.lovemma.zhihudaily.mvp.biz.SplashBiz;
import xyz.lovemma.zhihudaily.mvp.view.ISplashView;

/**
 * Created by OO on 2017/3/11.
 */

public class SplashPresenter extends IBasePresenter {
    private SplashBiz mBiz;
    private ISplashView mView;

    public SplashPresenter(ISplashView view) {
        mView = view;
        mBiz = new SplashBiz();
    }

    public void getLaunchImage() {
        Subscription subscription = mBiz.getLaunchImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LaunchImage>() {
                    @Override
                    public void onCompleted() {
                        mView.onRequestEnd();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError();
                        mView.onRequestEnd();
                    }

                    @Override
                    public void onNext(LaunchImage launchImage) {
                        mView.getLaunchImage(launchImage);
                    }
                });
        addSubscription(subscription);
    }
}
