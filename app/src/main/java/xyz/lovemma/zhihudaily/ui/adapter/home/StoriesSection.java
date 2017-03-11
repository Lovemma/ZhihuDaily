package xyz.lovemma.zhihudaily.ui.adapter.home;

import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.utils.DateUtils;

/**
 * Created by OO on 2017/2/14.
 */

public class StoriesSection implements BaseItem {
    private final String date;

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
