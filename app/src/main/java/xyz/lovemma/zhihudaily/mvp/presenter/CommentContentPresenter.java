package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.lovemma.zhihudaily.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.bean.StoryContentShortComment;
import xyz.lovemma.zhihudaily.mvp.biz.CommentContentBiz;
import xyz.lovemma.zhihudaily.mvp.view.ICommentContentView;

/**
 * Created by OO on 2017/3/4.
 */

public class CommentContentPresenter extends IBasePresenter {
    private CommentContentBiz mBiz;
    private ICommentContentView mView;

    public CommentContentPresenter(ICommentContentView view) {
        mView = view;
        mBiz = new CommentContentBiz();
    }

    public void getStoryContentLongComments(int id) {
        Subscription subscription = mBiz.getStoryContentLongComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryContentLongComment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(StoryContentLongComment longComment) {
                        mView.loadStoryContentLongComments(longComment);
                    }
                });
        addSubscription(subscription);
    }

    public void getStoryContentShortComments(int id) {
        Subscription subscription = mBiz.getStoryContentShortComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryContentShortComment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(StoryContentShortComment shortComment) {
                        mView.loadStoryContentShortComments(shortComment);
                    }
                });
        addSubscription(subscription);
    }
}
