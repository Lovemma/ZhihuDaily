package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;

/**
 * Created by OO on 2017/2/11.
 */

public interface IStoriesBiz {
    Observable<LatestStories> getLatestStories();

    Observable<BeforeStories> getBeforeStories(String date);
}
