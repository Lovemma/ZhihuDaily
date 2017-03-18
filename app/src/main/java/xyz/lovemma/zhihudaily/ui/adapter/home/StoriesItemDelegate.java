package xyz.lovemma.zhihudaily.ui.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.Stories;
import xyz.lovemma.zhihudaily.ui.activity.StoryContentActivity;
import xyz.lovemma.zhihudaily.utils.NetWorkUtils;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

/**
 * Created by OO on 2017/2/13.
 */

class StoriesItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof Stories;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

        final Stories stories = (Stories) baseItem;
        holder.setText(R.id.title, stories.getTitle());
        mContext = holder.getConvertView().getContext();
        if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)
                && !NetWorkUtils.isWifiConnected(App.getContext())) {
            Glide.with(mContext)
                    .load(R.drawable.image_small_default)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.image));
        } else {
            Glide.with(mContext)
                    .load(stories.getImages().get(0))
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.image));
        }
        if (!stories.isMultiPic()) {
            holder.getView(R.id.multiPic).setVisibility(View.INVISIBLE);
        }
        holder.setOnClickListener(R.id.cardView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, StoryContentActivity.class);
                intent.putExtra("id", stories.getId());
                mContext.startActivity(intent);
            }
        });
    }

}
