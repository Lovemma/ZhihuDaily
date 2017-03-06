package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.bean.Themes;
import xyz.lovemma.zhihudaily.mvp.biz.ThemeBiz;
import xyz.lovemma.zhihudaily.mvp.view.IThemeView;

/**
 * Created by OO on 2017/2/24.
 */

public class ThemePresenter extends IBasePresenter {
    private IThemeView mView;
    private ThemeBiz mBiz;

    public ThemePresenter(IThemeView view) {
        mView = view;
        mBiz = new ThemeBiz();
    }

    public void getThemesList() {
        Subscription subscription = mBiz.getThemesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Themes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getThemesList 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(Themes themes) {
                        mView.loadThemeList(themes);
                    }
                });
        addSubscription(subscription);
    }

}
