package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.Themes;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/24.
 */

public interface IThemeView {
    void onRequestError(String msg);

    void loadThemeList(Themes themes);

    void loadThemeContent(ThemesContent content);
}
