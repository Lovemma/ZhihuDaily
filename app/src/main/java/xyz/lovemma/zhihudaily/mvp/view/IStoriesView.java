package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.BeforeStories;
import xyz.lovemma.zhihudaily.bean.LatestStories;

/**
 * Created by OO on 2017/2/11.
 */

public interface IStoriesView {
    void onRequestError(String msg);

    void loadLatestStories(LatestStories latestStories);

    void loadBeforeStories(BeforeStories beforeStories);
}
