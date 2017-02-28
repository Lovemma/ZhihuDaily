package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.bean.Themes;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/24.
 */

public class ThemeBiz implements IThemeBiz {
    @Override
    public Observable<Themes> getThemesList() {
        return ApiManage.getInstance().getCommonApi().getThemesList();
    }

    @Override
    public Observable<ThemesContent> getThemesContent(int id) {
        return ApiManage.getInstance().getCommonApi().getThemesContent(id);
    }
}
