package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.Themes;

/**
 * Created by OO on 2017/2/24.
 */

public interface IThemeBiz {
    Observable<Themes> getThemesList();
}
