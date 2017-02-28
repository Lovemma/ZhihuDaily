package xyz.lovemma.zhihudaily.ui.adapter.drawer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;

/**
 * Created by OO on 2017/2/24.
 */

public class ThemesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    private OnItemClickListener mOnItemClickListener;

    public ThemesListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new DrawerHeaderDelegate());
        addItemViewDelegate(new DrawerHomeDelegate());
        addItemViewDelegate(new ThemeItemDelegete());
    }

    @Override
    protected void setListener(ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        switch (viewType) {
            case 0:

                break;
            case 1:
            case 2:
                viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            int position = viewHolder.getAdapterPosition();
                            mOnItemClickListener.onItemViewClick(v, viewHolder, position);
                        }
                    }
                });
                break;
        }
    }

    private int mSelection = 1;

    public void setSelection(int selection) {
        mSelection = selection;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (mSelection == position) {
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.drawer_select));
        } else if (position > 0) {
            holder.getConvertView().setBackgroundColor(ContextCompat.getColor(mContext, R.color.drawer_normal));
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onDrawerHeaderClick();

        void onItemViewClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onDrawerHeaderClick();
            }
        }
    };
}
