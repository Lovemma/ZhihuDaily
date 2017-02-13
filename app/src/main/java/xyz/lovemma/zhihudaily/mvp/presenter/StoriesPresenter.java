package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;
import xyz.lovemma.zhihudaily.mvp.biz.StoriesBiz;
import xyz.lovemma.zhihudaily.mvp.view.IStoriesView;

/**
 * Created by OO on 2017/2/11.
 */

public class StoriesPresenter extends IBasePresenter {
    private IStoriesView mView;
    private StoriesBiz mBiz;

    public StoriesPresenter(IStoriesView view) {
        mView = view;
    }

    void getLatestStories() {
        Subscription subscription = mBiz.getLatestStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LatestStories>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(LatestStories latestStories) {
                        mView.loadLatestStories(latestStories);
                    }
                });
        addSubscription(subscription);
    }

    void getBeforeDaily(String date) {
     Subscription subscription = mBiz.getBeforeStories(date)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<BeforeStories>() {
                 @Override
                 public void onCompleted() {

                 }

                 @Override
                 public void onError(Throwable e) {
                     mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                 }

                 @Override
                 public void onNext(BeforeStories beforeStories) {
                     mView.loadBeforeStories(beforeStories);
                 }
             });
        addSubscription(subscription);
    }

}
