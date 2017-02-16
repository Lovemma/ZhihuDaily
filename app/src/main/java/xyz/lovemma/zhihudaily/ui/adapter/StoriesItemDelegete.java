package xyz.lovemma.zhihudaily.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.mvp.bean.BaseItem;
import xyz.lovemma.zhihudaily.mvp.bean.Stories;

/**
 * Created by OO on 2017/2/13.
 */

public class StoriesItemDelegete implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_content;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof Stories;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

        Stories stories = (Stories) baseItem;
        holder.setText(R.id.title, stories.getTitle());
        if (stories.isMultipic()) {
            holder.getView(R.id.multiPic).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.multiPic).setVisibility(View.INVISIBLE);
        }
        Glide.with(holder.getConvertView().getContext())
                .load(stories.getImages().get(0))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) holder.getView(R.id.image));
    }

}
