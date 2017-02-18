package xyz.lovemma.zhihudaily.mvp.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeader implements BaseItem {
    private List<TopStories> mTopStories;

    public StoriesHeader(List<TopStories> topStories) {
        mTopStories = topStories;
    }


    public List<TopStories> getTopStories() {
        return mTopStories;
    }

}
