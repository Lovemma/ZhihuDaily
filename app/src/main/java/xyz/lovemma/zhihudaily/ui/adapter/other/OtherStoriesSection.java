package xyz.lovemma.zhihudaily.ui.adapter.other;

import java.util.ArrayList;

import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.Editors;

/**
 * Created by OO on 2017/2/28.
 */

public class OtherStoriesSection implements BaseItem {
    private ArrayList<Editors> mEditors;

    public OtherStoriesSection(ArrayList<Editors> editors) {
        mEditors = editors;
    }

    public ArrayList<Editors> getEditors() {
        return mEditors;
    }
}
