package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.bean.BeforeThemeStories;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesBiz implements IOtherStoriesBiz {
    @Override
    public Observable<ThemesContent> getOtherStories(int id) {
        return ApiManage.getInstance().getCommonApi().getThemesContent(id);
    }

    @Override
    public Observable<BeforeThemeStories> getMoreThemeStories(int id, int story_id) {
        return ApiManage.getInstance().getCommonApi().getBeforeThemesContent(id, story_id);
    }
}
