package xyz.lovemma.zhihudaily.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.StoryContent;

public class StoryContentActivity extends BaseActivity{

    private ImageView mImageView;
    private TextView title;
    private TextView imageSouce;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_story_content;
    }

    @Override
    protected void setHeaderImg() {
        imageSouce = (TextView) findViewById(R.id.image_source);
        mImageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
    }

    @Override
    protected void loadHeaderImg(StoryContent storyContent) {
        title.setText(storyContent.getTitle());
        imageSouce.setText(storyContent.getImage_source());
        Glide.with(this)
                .load(storyContent.getImage())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

}
