package xyz.lovemma.zhihudaily.mvp.bean;

import xyz.lovemma.zhihudaily.utils.DateUtils;

/**
 * Created by OO on 2017/2/14.
 */

public class StoriesSection implements BaseItem {
    private String date;

    public StoriesSection(String date) {
        this.date = date;
    }

    public String getDate() {
        if (date == null) {
            return null;
        }
        return DateUtils.transform(date);
    }
}
