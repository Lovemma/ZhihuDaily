package xyz.lovemma.zhihudaily.ui.adapter.home;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/2/14.
 */

class StoriesSectionDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof StoriesSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        if (position == 1) {
            holder.setText(R.id.story_section, "今日热闻");
        } else {
            holder.setText(R.id.story_section, ((StoriesSection) baseItem).getDate());
        }
    }
}
