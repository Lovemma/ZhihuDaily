package xyz.lovemma.zhihudaily.ui.adapter.drawer;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/2/25.
 */

class DrawerHeaderDelegate implements ItemViewDelegate<BaseItem> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.drawer_head;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof DrawerHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

    }
}
