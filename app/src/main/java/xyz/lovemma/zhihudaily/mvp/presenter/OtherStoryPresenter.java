package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.bean.ThemesContent;
import xyz.lovemma.zhihudaily.mvp.biz.OtherStoriesBiz;
import xyz.lovemma.zhihudaily.mvp.view.IOtherStoriesView;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoryPresenter extends IBasePresenter {
    private IOtherStoriesView mView;
    private OtherStoriesBiz mBiz;

    public OtherStoryPresenter(IOtherStoriesView view) {
        mView = view;
        mBiz = new OtherStoriesBiz();
    }

    public void getOtherStories(int id) {
        Subscription subscription = mBiz.getOtherStories(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemesContent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getOtherStories 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(ThemesContent themesContent) {
                        mView.loadStories(themesContent);
                    }
                });
        addSubscription(subscription);
    }
}
