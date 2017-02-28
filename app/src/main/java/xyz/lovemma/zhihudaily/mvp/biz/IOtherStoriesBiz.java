package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/27.
 */

public interface IOtherStoriesBiz {
    Observable<ThemesContent> getOtherStories(int id);
}
