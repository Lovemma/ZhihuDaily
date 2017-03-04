package xyz.lovemma.zhihudaily.ui.adapter.comment;

import android.content.Context;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/3/4.
 */

public class CommentAdapter extends MultiItemTypeAdapter<BaseItem> {
    public CommentAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new CommentSectionDelegate());
        addItemViewDelegate(new CommentEmptyDelegate());
        addItemViewDelegate(new CommentItemDelegate());
    }
}
