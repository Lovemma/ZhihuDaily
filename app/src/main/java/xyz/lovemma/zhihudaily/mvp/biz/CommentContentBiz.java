package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.bean.StoryContentShortComment;

/**
 * Created by OO on 2017/3/4.
 */

public class CommentContentBiz implements ICommentContentBiz {

    @Override
    public Observable<StoryContentLongComment> getStoryContentLongComments(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContentLongComments(id);
    }

    @Override
    public Observable<StoryContentShortComment> getStoryContentShortComments(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContentShortComments(id);
    }
}
