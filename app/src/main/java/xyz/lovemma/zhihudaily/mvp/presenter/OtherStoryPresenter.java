package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.bean.BeforeThemeStories;
import xyz.lovemma.zhihudaily.bean.ThemesContent;
import xyz.lovemma.zhihudaily.mvp.biz.OtherStoriesBiz;
import xyz.lovemma.zhihudaily.mvp.view.IOtherStoriesView;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoryPresenter extends IBasePresenter {
    private final IOtherStoriesView mView;
    private final OtherStoriesBiz mBiz;

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
                        mView.setStoryId(themesContent.getStories().get(themesContent.getStories().size() - 1).getId());
                        mView.loadStories(themesContent);
                    }
                });
        addSubscription(subscription);
    }

    public void getMoreThemeStories(int id, int story_id) {
        Subscription subscription = mBiz.getMoreThemeStories(id, story_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeforeThemeStories>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getThemesList 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(BeforeThemeStories beforeThemeStories) {
                        mView.setStoryId(beforeThemeStories.getStories().get(beforeThemeStories.getStories().size() - 1).getId());
                        mView.loadMoreStories(beforeThemeStories);
                    }
                });
        addSubscription(subscription);
    }
}
