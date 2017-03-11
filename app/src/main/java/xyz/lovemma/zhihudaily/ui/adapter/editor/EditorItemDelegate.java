package xyz.lovemma.zhihudaily.ui.adapter.editor;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.Editors;
import xyz.lovemma.zhihudaily.widget.CircleTransform;

/**
 * Created by OO on 2017/3/8.
 */

class EditorItemDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.editor_list_item;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof Editors;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        Context context = holder.getConvertView().getContext();
        Editors editors = (Editors) baseItem;
        ((TextView)holder.getView(R.id.editor_name)).setText(editors.getName());
        ((TextView)holder.getView(R.id.editor_bio)).setText(editors.getBio());
        Glide.with(context)
                .load(editors.getAvatar())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .transform(new CircleTransform(context))
                .into((ImageView) holder.getView(R.id.editor_avatar));
    }
}
