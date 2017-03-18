package xyz.lovemma.zhihudaily.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.StoryContent;
import xyz.lovemma.zhihudaily.utils.NetWorkUtils;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

public class StoryContentActivity extends BaseActivity {

    private ImageView mImageView;
    private TextView title;
    private TextView imageSource;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_story_content;
    }

    @Override
    protected void setHeaderImg() {
        imageSource = (TextView) findViewById(R.id.image_source);
        mImageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
    }

    @Override
    protected void loadHeaderImg(StoryContent storyContent) {
        title.setText(storyContent.getTitle());
        imageSource.setText(storyContent.getImage_source());
        if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)
                && !NetWorkUtils.isWifiConnected(App.getContext())) {
            Glide.with(this)
                    .load(R.drawable.image_top_default)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mImageView);
        } else {
            Glide.with(this)
                    .load(storyContent.getImage())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mImageView);
        }
    }

}
