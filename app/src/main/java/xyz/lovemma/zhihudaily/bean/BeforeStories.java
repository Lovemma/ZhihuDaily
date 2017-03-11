package xyz.lovemma.zhihudaily.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/10.
 */

public class BeforeStories implements BaseItem{

    private String date;
    private List<Stories> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Stories> getStories() {
        return stories;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }
}
