package xyz.lovemma.zhihudaily.mvp.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/24.
 */

public class StoryContentShortComment {
    private List<StoryContentComment> comments;

    public List<StoryContentComment> getComments() {
        return comments;
    }

    public void setComments(List<StoryContentComment> comments) {
        this.comments = comments;
    }
}
