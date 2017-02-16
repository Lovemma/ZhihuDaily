package xyz.lovemma.zhihudaily.widget.Banner;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.R;

/**
 * Created by OO on 2017/2/14.
 */

public class Banner extends RelativeLayout {
    private ViewPager mViewPager;
    private TextView mTextView;
    private LinearLayout indicator;

    private BannerAdapter mAdapter;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private List<String> imageUrls;
    private List<String> titles;
    private List<ImageView> mViewList = new ArrayList<>();
    private int lastPosition;
    private boolean isAutoPlay = true;
    Handler mHandler = new Handler();
    private boolean isLoad;

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.banner, this, true);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPage);
        indicator = (LinearLayout) view.findViewById(R.id.point_group);
        mTextView = (TextView) view.findViewById(R.id.title);
    }


    public Banner setImages(List<String> imageUrls) {
        this.imageUrls = imageUrls;
        return this;
    }

    public Banner setTitles(List<String> titles) {
        this.titles = titles;
        return this;
    }

    public Banner start() {
        if (isLoad == false) {
            initIndicator();
            initImageList();
            isLoad = true;
        }
        return this;
    }

    private void initIndicator() {
        indicator.removeAllViews();
        for (int i = 0; i < imageUrls.size(); i++) {
            ImageView point = new ImageView(getContext());
            LayoutParams params = new LayoutParams(20, 20);
            params.leftMargin = 5;
            params.rightMargin = 5;
            point.setImageResource(R.drawable.point_selector);
            if (i == 0) {
                point.setSelected(true);
            } else {
                point.setSelected(false);
            }
            point.setLayoutParams(params);
            indicator.addView(point);
        }
    }

    private void initImageList() {
        mViewList.clear();
        for (int i = 0; i < imageUrls.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mViewList.add(imageView);
            Glide.with(getContext())
                    .load(imageUrls.get(i))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView);
        }
        setData();
    }

    private void setData() {
        mTextView.setText(titles.get(0));
        if (mAdapter == null) {
            mAdapter = new BannerAdapter(mViewList);
        }
        mViewPager.setAdapter(mAdapter);
        mHandler.removeCallbacks(mRunnable);
        mHandler.postDelayed(mRunnable, 3000);
        if (mOnPageChangeListener == null) {
            mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    position = position % imageUrls.size();
                    indicator.getChildAt(position).setSelected(true);
                    indicator.getChildAt(lastPosition).setSelected(false);
                    lastPosition = position;
                    mTextView.setText(titles.get(position));
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    switch (state) {
                        //SCROLL_STATE_DRAGGING
                        case 1:
                            isAutoPlay = false;
                            break;
                        //SCROLL_STATE_SETTLING2
                        case 2:
                            isAutoPlay = true;
                            break;
                        default:
                            break;
                    }
                }
            };
        }
        mViewPager.removeOnPageChangeListener(mOnPageChangeListener);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
    }

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (isAutoPlay) {
                int currentPosition = mViewPager.getCurrentItem();
                if (currentPosition == mViewPager.getAdapter().getCount() - 1) {
                    mViewPager.setCurrentItem(0);
                } else {
                    mViewPager.setCurrentItem(currentPosition + 1);
                }
                mHandler.postDelayed(this, 3000);
            } else {
                mHandler.postDelayed(this, 3000);
            }
        }
    };
}
