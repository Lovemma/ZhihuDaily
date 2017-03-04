package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.bean.StoryContentShortComment;

/**
 * Created by OO on 2017/3/4.
 */

public interface ICommentContentBiz {
    Observable<StoryContentLongComment> getStoryContentLongComments(int id);

    Observable<StoryContentShortComment> getStoryContentShortComments(int id);
}
