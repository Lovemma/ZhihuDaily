package xyz.lovemma.zhihudaily.ui.adapter.comment;

import android.view.View;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/3/4.
 */

class CommentSectionDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.comment_item_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof CommentSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        CommentSection commentSection = (CommentSection) baseItem;
        holder.setText(R.id.comment_num, commentSection.getTitle());
        if (commentSection.getType() == CommentSection.LONG_COMMENT) {
            holder.getView(R.id.comment_item_img).setVisibility(View.GONE);
        }
    }
}
