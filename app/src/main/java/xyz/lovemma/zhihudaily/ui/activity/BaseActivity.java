package xyz.lovemma.zhihudaily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.StoryContent;
import xyz.lovemma.zhihudaily.bean.StoryContentExtra;
import xyz.lovemma.zhihudaily.mvp.presenter.StoryContentPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IStoryContentView;
import xyz.lovemma.zhihudaily.utils.CalculateUtil;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;
import xyz.lovemma.zhihudaily.utils.WebUtil;

/**
 * Created by OO on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity implements IStoryContentView, View.OnClickListener {
    private Context mContext = this;

    private Toolbar mToolbar;
    private WebView mWebView;
    private Menu mMenu;

    private View actionCommentView;
    private View actionLikeView;
    private ImageView commentImg;
    private TextView commentText;
    private TextView likeText;
    private ImageView likeImg;

    private StoryContentPresenter mPresenter;

    private StoryContent mStoryContent;

    protected int id;
    protected int commentNum;
    protected int longCommentNum;
    protected int shortCommentNum;
    protected int likeNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
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

    protected abstract int getLayoutId();

    private void initView() {
        setHeaderImg();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.webView);
        id = getIntent().getIntExtra("id", 0);
        mPresenter = new StoryContentPresenter(this);
        initToolBar();
        initWebView();
    }

    private void initData() {
        if (id != 0) {
            mPresenter.getStoryContent(id);
            mPresenter.getStoryContentExtra(id);
        } else {
            Toast.makeText(this, "数据加载出错", Toast.LENGTH_SHORT).show();
        }
    }

    protected abstract void setHeaderImg();

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
        mMenu.findItem(R.id.menu_like).setActionView(R.layout.action_item);

        actionCommentView = mMenu.findItem(R.id.menu_comment).getActionView();
        commentImg = (ImageView) actionCommentView.findViewById(R.id.action_item_image);
        commentText = (TextView) actionCommentView.findViewById(R.id.action_item_text);
        actionCommentView.setOnClickListener(this);

        actionLikeView = mMenu.findItem(R.id.menu_like).getActionView();
        likeImg = (ImageView) actionLikeView.findViewById(R.id.action_item_image);
        likeText = (TextView) actionLikeView.findViewById(R.id.action_item_text);
        actionLikeView.setOnClickListener(this);

        mMenu.findItem(R.id.menu_share).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                shareToOther();
                return false;
            }
        });
    }

    private void shareToOther() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, mStoryContent.getShare_url());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "分享到..."));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_comment:
                Intent intent = new Intent(this, CommentActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("comment_num", commentNum);
                intent.putExtra("long_comment_num", longCommentNum);
                intent.putExtra("short_comment_num", shortCommentNum);
                startActivity(intent);
                break;
            case R.id.menu_like:
                if ((boolean) SharedPreferencesUtils.get(mContext, Integer.toString(id), false)) {
                    likeImg.setImageResource(R.drawable.ic_thumb_up);
                    likeText.setText(CalculateUtil.CalculatePraise(--likeNum));
                    SharedPreferencesUtils.put(mContext, Integer.toString(id), false);
                } else {
                    likeImg.setImageResource(R.drawable.ic_thumb_up_orange);
                    likeText.setText(CalculateUtil.CalculatePraise(++likeNum));
                    SharedPreferencesUtils.put(mContext, Integer.toString(id), true);
                }
                break;
        }
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
        mStoryContent = storyContent;
        loadHeaderImg(storyContent);
        String body = storyContent.getBody();
        List<String> css = storyContent.getCss();
        String data = WebUtil.buildHtmlWithCss(body, css, false);
        mWebView.loadData(data, WebUtil.MIME_TYPE, WebUtil.ENCODING);
    }

    protected abstract void loadHeaderImg(StoryContent storyContent);

    @Override
    public void loadStoryContentExtra(StoryContentExtra storyContentExtra) {
        commentNum = storyContentExtra.getComments();
        longCommentNum = storyContentExtra.getLong_comments();
        shortCommentNum = storyContentExtra.getShort_comments();
        likeNum = storyContentExtra.getPopularity();

        commentImg.setImageResource(R.drawable.ic_comment);
        commentText.setText(CalculateUtil.CalculatePraise(storyContentExtra.getComments()));
        if (SharedPreferencesUtils.contains(mContext, Integer.toString(id))
                && (boolean) SharedPreferencesUtils.get(mContext, Integer.toString(id), false)) {
            likeImg.setImageResource(R.drawable.ic_thumb_up_orange);
            likeText.setText(CalculateUtil.CalculatePraise(++likeNum));
        } else {
            likeImg.setImageResource(R.drawable.ic_thumb_up);
            likeText.setText(CalculateUtil.CalculatePraise(likeNum));
        }
    }
}
