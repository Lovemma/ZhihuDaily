package xyz.lovemma.zhihudaily.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/24.
 */

public class StoryContentShortComment implements BaseItem{
    private List<StoryContentComment> comments;

    public List<StoryContentComment> getComments() {
        return comments;
    }

    public void setComments(List<StoryContentComment> comments) {
        this.comments = comments;
    }
}
