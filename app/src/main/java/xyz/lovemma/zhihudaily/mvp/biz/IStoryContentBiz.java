package xyz.lovemma.zhihudaily.mvp.biz;

import rx.Observable;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;

/**
 * Created by OO on 2017/2/16.
 */

public interface IStoryContentBiz {
    Observable<StoryContent> getStoryContent(int id);
}
