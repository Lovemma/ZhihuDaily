package xyz.lovemma.zhihudaily.ui.adapter.drawer;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.ThemesOther;

/**
 * Created by OO on 2017/2/24.
 */

public class ThemeItemDelegate implements ItemViewDelegate<BaseItem> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.drawer_list_item;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof ThemesOther;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        ThemesOther themesItem = (ThemesOther) baseItem;
        holder.setText(R.id.theme_title, themesItem.getName());
    }
}
