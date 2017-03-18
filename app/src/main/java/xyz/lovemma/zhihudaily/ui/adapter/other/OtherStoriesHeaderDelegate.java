package xyz.lovemma.zhihudaily.ui.adapter.other;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.utils.NetWorkUtils;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

/**
 * Created by OO on 2017/2/27.
 */

class OtherStoriesHeaderDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_other_story_header;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        OtherStoriesHeader storiesHeader = (OtherStoriesHeader) baseItem;
        ImageView imageView = holder.getView(R.id.image);
        TextView textView = holder.getView(R.id.title);
        if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)
                && !NetWorkUtils.isWifiConnected(App.getContext())) {
            Glide.with(holder.getConvertView().getContext())
                    .load(R.drawable.image_top_default)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .centerCrop()
                    .into(imageView);
        } else {
            Glide.with(holder.getConvertView().getContext())
                    .load(storiesHeader.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .centerCrop()
                    .into(imageView);
        }
        textView.setText(storiesHeader.getDescription());
    }
}
