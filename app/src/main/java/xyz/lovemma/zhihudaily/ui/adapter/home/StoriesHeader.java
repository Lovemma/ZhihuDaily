package xyz.lovemma.zhihudaily.ui.adapter.home;

import java.util.List;

import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.TopStories;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeader implements BaseItem {
    private final List<TopStories> mTopStories;

    public StoriesHeader(List<TopStories> topStories) {
        mTopStories = topStories;
    }


    public List<TopStories> getTopStories() {
        return mTopStories;
    }

}
