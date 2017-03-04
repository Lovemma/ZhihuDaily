package xyz.lovemma.zhihudaily.ui.adapter.home;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/2/13.
 */

public class StoriesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public StoriesListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new StoriesHeaderDelegate());
        addItemViewDelegate(new StoriesSectionDelegate());
        addItemViewDelegate(new StoriesItemDelegate());
    }
}
