package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/27.
 */

public interface IOtherStoriesView {
    void onRequestError(String msg);

    void loadStories(ThemesContent themesContent);
}
