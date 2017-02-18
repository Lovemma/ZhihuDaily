package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;

/**
 * Created by OO on 2017/2/16.
 */

public interface IStoryContentView {
    void onRequestError(String msg);

    void loadStoryContent(StoryContent storyContent);
}
