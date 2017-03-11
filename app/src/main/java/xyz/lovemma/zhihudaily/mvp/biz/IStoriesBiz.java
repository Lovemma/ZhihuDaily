package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.BeforeStories;
import xyz.lovemma.zhihudaily.bean.LatestStories;

/**
 * Created by OO on 2017/2/11.
 */

interface IStoriesBiz {
    Observable<LatestStories> getLatestStories();

    Observable<BeforeStories> getBeforeStories(String date);
}
