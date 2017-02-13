package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;

/**
 * Created by OO on 2017/2/11.
 */

public class StoriesBiz implements IStoriesBiz{
    @Override
    public Observable<LatestStories> getLatestStories() {
        return ApiManage.getInstance().getCommonApi().getLatestStories();
    }

    @Override
    public Observable<BeforeStories> getBeforeStories(String date) {
        return ApiManage.getInstance().getCommonApi().getBeforeStories(date);
    }
}
