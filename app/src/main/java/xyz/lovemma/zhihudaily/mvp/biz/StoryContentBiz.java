package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.api.ApiManage;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;

/**
 * Created by OO on 2017/2/16.
 */

public class StoryContentBiz implements IStoryContentBiz {
    @Override
    public Observable<StoryContent> getStoryContent(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContent(id);
    }
}
