package xyz.lovemma.zhihudaily.ui.adapter.comment;

import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/3/4.
 */

public class CommentEmptyDelegate implements ItemViewDelegate<BaseItem> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.empty_long_comment;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof CommentEmpty;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

    }
}
