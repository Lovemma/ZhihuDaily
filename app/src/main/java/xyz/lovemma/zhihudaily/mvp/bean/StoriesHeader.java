package xyz.lovemma.zhihudaily.mvp.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeader implements BaseItem {
    private List<TopStories> mTopStories;
    private List<String> images= new ArrayList<>();
    private List<String> titles= new ArrayList<>();
    private List<Integer> ids= new ArrayList<>();

    public StoriesHeader(List<TopStories> topStories) {
        mTopStories = topStories;
        initData();
    }

    private void initData() {
        for (TopStories topStory : mTopStories) {
            images.add(topStory.getImage());
            titles.add(topStory.getTitle());
            ids.add(topStory.getId());
        }
    }

    public List<TopStories> getTopStories() {
        return mTopStories;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<Integer> getIds() {
        return ids;
    }
}
