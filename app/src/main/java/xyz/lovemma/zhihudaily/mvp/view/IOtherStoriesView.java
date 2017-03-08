package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.BeforeThemeStories;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/27.
 */

public interface IOtherStoriesView {
    void onRequestError(String msg);

    void setStoryId(int storyId);

    void loadStories(ThemesContent themesContent);

    void loadMoreStories(BeforeThemeStories beforeThemeStories);
}
