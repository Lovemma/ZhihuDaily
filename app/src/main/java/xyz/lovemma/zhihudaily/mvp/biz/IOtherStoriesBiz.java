package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.BeforeThemeStories;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/27.
 */

interface IOtherStoriesBiz {
    Observable<ThemesContent> getOtherStories(int id);

    Observable<BeforeThemeStories> getMoreThemeStories(int id, int story_id);
}
