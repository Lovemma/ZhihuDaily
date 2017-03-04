package xyz.lovemma.zhihudaily.ui.adapter.other;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.utils.CircleTransform;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesSectionDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_other_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        OtherStoriesSection section = (OtherStoriesSection) baseItem;
        ImageView imageView = holder.getView(R.id.editor_avatar);
        Glide.with(mContext)
                .load(section.getEditors().getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new CircleTransform(mContext))
                .into(imageView);
    }
}
