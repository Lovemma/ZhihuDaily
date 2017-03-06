package xyz.lovemma.zhihudaily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.StoryContent;
import xyz.lovemma.zhihudaily.bean.StoryContentExtra;
import xyz.lovemma.zhihudaily.mvp.presenter.StoryContentPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IStoryContentView;
import xyz.lovemma.zhihudaily.utils.CalculateUtil;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;
import xyz.lovemma.zhihudaily.utils.WebUtil;

public class StoryContentActivity extends AppCompatActivity implements IStoryContentView {
    private Toolbar mToolbar;
    private ImageView mImageView;
    private TextView title;
    private TextView imageSouce;
    private WebView mWebView;
    private Menu mMenu;
    private int id;
    private int commentNum;
    private int longCommentNum;
    private int shortCommentNum;
    private int likeNum;

    private View actionCommentView;
    private View actionLikeView;

    private ImageView commentImg;
    private TextView commentText;
    private TextView likeText;
    private ImageView likeImg;

    private StoryContentPresenter mPresenter;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_content);
        mContext = this;
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubcrible();
        if (mWebView != null) {
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    private void initData() {
        if (id != 0) {
            mPresenter.getStoryContent(id);
            mPresenter.getStoryContentExtra(id);
        } else {
            Toast.makeText(this, "数据加载出错", Toast.LENGTH_SHORT).show();
        }
    }

    private static final String TAG = "StoryContentActivity";

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        imageSouce = (TextView) findViewById(R.id.image_source);
        mImageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        mWebView = (WebView) findViewById(R.id.webView);
        id = getIntent().getIntExtra("id", 0);
        Log.d(TAG, "initView: id" + id);
        mPresenter = new StoryContentPresenter(this);
        initWebView();
        initToolBar();
    }

    private void initToolBar() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_story_content);

        mMenu = mToolbar.getMenu();

        mMenu.findItem(R.id.menu_comment).setActionView(R.layout.action_item);
        mMenu.findItem(R.id.menu_follow).setActionView(R.layout.action_item);

        actionCommentView = mMenu.findItem(R.id.menu_comment).getActionView();
        actionLikeView = mMenu.findItem(R.id.menu_follow).getActionView();

        commentImg = (ImageView) actionCommentView.findViewById(R.id.action_item_image);
        commentText = (TextView) actionCommentView.findViewById(R.id.action_item_text);
        likeImg = (ImageView) actionLikeView.findViewById(R.id.action_item_image);
        likeText = (TextView) actionLikeView.findViewById(R.id.action_item_text);

        actionCommentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryContentActivity.this, CommentActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("comment_num", commentNum);
                intent.putExtra("long_comment_num", longCommentNum);
                intent.putExtra("short_comment_num", shortCommentNum);
                startActivity(intent);
            }
        });
        actionLikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((boolean) SharedPreferencesUtils.get(mContext, Integer.toString(id), false)) {
                    likeImg.setImageResource(R.drawable.ic_thumb_up);
                    likeText.setText(CalculateUtil.CalculatePraise(--likeNum));
                    SharedPreferencesUtils.put(mContext, Integer.toString(id), false);
                    SharedPreferencesUtils.put(mContext, Integer.toString(id) + "isOnClick", false);
                } else {
                    likeImg.setImageResource(R.drawable.ic_thumb_up_orange);
                    likeText.setText(CalculateUtil.CalculatePraise(++likeNum));
                    SharedPreferencesUtils.put(mContext, Integer.toString(id), true);
                    SharedPreferencesUtils.put(mContext, Integer.toString(id) + "isOnClick", true);
                }
            }
        });
    }


    private void initWebView() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSupportZoom(false);
        settings.setAppCachePath(getCacheDir().getAbsolutePath() + "/webViewCache");
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadStoryContent(StoryContent storyContent) {
        title.setText(storyContent.getTitle());
        imageSouce.setText(storyContent.getImage_source());
        Glide.with(this)
                .load(storyContent.getImage())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
        String body = storyContent.getBody();
        List<String> css = storyContent.getCss();
        String data = WebUtil.buildHtmlWithCss(body, css, false);
        mWebView.loadData(data, WebUtil.MIME_TYPE, WebUtil.ENCODING);

    }

    @Override
    public void loadStoryContentExtra(StoryContentExtra storyContentExtra) {
        commentNum = storyContentExtra.getComments();
        longCommentNum = storyContentExtra.getLong_comments();
        shortCommentNum = storyContentExtra.getShort_comments();
        likeNum = storyContentExtra.getPopularity();

        commentImg.setImageResource(R.drawable.ic_comment);
        commentText.setText(CalculateUtil.CalculatePraise(storyContentExtra.getComments()));
        if ((boolean) SharedPreferencesUtils.get(mContext, Integer.toString(id) + "isOnClick", false)) {
            likeImg.setImageResource(R.drawable.ic_thumb_up_orange);
            likeText.setText(CalculateUtil.CalculatePraise(++likeNum));
        } else {
            likeImg.setImageResource(R.drawable.ic_thumb_up);
            likeText.setText(CalculateUtil.CalculatePraise(likeNum));
        }
    }

}
