package xyz.lovemma.zhihudaily.ui.adapter.other;

import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.ThemesContent;

/**
 * Created by OO on 2017/2/28.
 */

public class OtherStoriesSection implements BaseItem {
    private ThemesContent.Editors mEditors;

    public OtherStoriesSection(ThemesContent.Editors editors) {
        mEditors = editors;
    }

    public ThemesContent.Editors getEditors() {
        return mEditors;
    }
}
