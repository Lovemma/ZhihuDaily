package xyz.lovemma.zhihudaily.widget.Banner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by OO on 2017/2/14.
 */

public class BannerAdapter extends PagerAdapter {
    private List<ImageView> mList;

    public BannerAdapter(List<ImageView> list) {
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mList.size();
        container.addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
