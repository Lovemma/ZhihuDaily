package xyz.lovemma.zhihudaily.ui.adapter.comment;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.StoryContentComment;
import xyz.lovemma.zhihudaily.widget.CircleTransform;

/**
 * Created by OO on 2017/3/4.
 */

class CommentItemDelegate implements ItemViewDelegate<BaseItem> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.comment_item;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof StoryContentComment;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        Context context = holder.getConvertView().getContext();
        StoryContentComment comment = (StoryContentComment) baseItem;
        Glide.with(context)
                .load(comment.getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new CircleTransform(context))
                .into((ImageView) holder.getView(R.id.avatar));
        holder.setText(R.id.author, comment.getAuthor());
        holder.setText(R.id.content, comment.getContent());
        holder.setText(R.id.likes, Integer.toString(comment.getLikes()));
        holder.setText(R.id.time, comment.getTime());
    }
}
