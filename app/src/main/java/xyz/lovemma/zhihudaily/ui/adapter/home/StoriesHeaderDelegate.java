package xyz.lovemma.zhihudaily.ui.adapter.home;

import android.content.Context;
import android.content.Intent;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.ui.activity.StoryContentActivity;
import xyz.lovemma.zhihudaily.widget.Banner.Banner;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeaderDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

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
        mContext = holder.getConvertView().getContext();
        final StoriesHeader storiesHeader = (StoriesHeader) baseItem;
        Banner banner = holder.getView(R.id.banner);
        banner.setDataList(storiesHeader.getTopStories())
                .start();

        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(int id) {
                Intent intent = new Intent(mContext,StoryContentActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
            }
        });
    }
}
