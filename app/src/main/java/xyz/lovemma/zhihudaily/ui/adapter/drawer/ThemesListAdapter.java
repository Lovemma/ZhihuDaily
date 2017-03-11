package xyz.lovemma.zhihudaily.ui.adapter.drawer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

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

    public ThemesListAdapter(Context context, List<BaseItem> itemList) {
        super(context, itemList);
        addItemViewDelegate(new DrawerHeaderDelegate());
        addItemViewDelegate(new DrawerHomeDelegate());
        addItemViewDelegate(new ThemeItemDelegate());
    }

    @Override
    protected void setListener(ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        switch (viewType) {
            case 0:
                LinearLayout login = viewHolder.getView(R.id.login);
                Button collect = viewHolder.getView(R.id.collect);
                Button download = viewHolder.getView(R.id.download);

                login.setOnClickListener(mListener);
                collect.setOnClickListener(mListener);
                download.setOnClickListener(mListener);
                break;
            case 2:
                viewHolder.getView(R.id.add_follow).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onFollowClick();
                        }
                    }
                });
            case 1:
                viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            int position = viewHolder.getAdapterPosition();
                            mOnItemClickListener.onItemViewClick(position);
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
        void onDrawerHeaderClick(View view);

        void onItemViewClick(int position);

        void onFollowClick();
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onDrawerHeaderClick(v);
            }
        }
    };
}
