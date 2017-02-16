package xyz.lovemma.zhihudaily.ui.adapter;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.mvp.bean.BaseItem;
import xyz.lovemma.zhihudaily.mvp.bean.StoriesHeader;
import xyz.lovemma.zhihudaily.widget.Banner.Banner;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeaderDelegete implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_header;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof StoriesHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        StoriesHeader storiesHeader = (StoriesHeader) baseItem;
        Banner banner = holder.getView(R.id.banner);
        banner.setImages(storiesHeader.getImages())
                .setTitles(storiesHeader.getTitles())
                .start();
    }
}
