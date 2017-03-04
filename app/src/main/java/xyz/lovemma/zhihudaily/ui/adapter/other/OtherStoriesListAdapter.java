package xyz.lovemma.zhihudaily.ui.adapter.other;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public OtherStoriesListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new OtherStoriesHeaderDelegate());
        addItemViewDelegate(new OtherStoriesSectionDelegate());
        addItemViewDelegate(new OtherStoriesItemDelegate());
    }
}
