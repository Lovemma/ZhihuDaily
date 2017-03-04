package xyz.lovemma.zhihudaily.mvp.view;

import xyz.lovemma.zhihudaily.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.bean.StoryContentShortComment;

/**
 * Created by OO on 2017/3/4.
 */

public interface ICommentContentView {
    void onRequestError(String msg);

    void loadStoryContentLongComments(StoryContentLongComment longComment);

    void loadStoryContentShortComments(StoryContentShortComment shortComment);

}
