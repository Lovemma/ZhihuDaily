package xyz.lovemma.zhihudaily.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
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
import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContentExtra;
import xyz.lovemma.zhihudaily.mvp.presenter.StoryContentPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IStoryContentView;
import xyz.lovemma.zhihudaily.utils.WebUtil;
import xyz.lovemma.zhihudaily.widget.ActionProvider.StoryContentActionProvider;

public class StoryContentActivity extends AppCompatActivity implements IStoryContentView {
    private Toolbar mToolbar;
    private ImageView mImageView;
    private TextView title;
    private TextView imageSouce;
    private WebView mWebView;
    private Menu mMenu;
    private StoryContentActionProvider mCommentProvider;
    private StoryContentActionProvider mFollowProvider;
    private int id;

    private StoryContentPresenter mPresenter;
    private static final String TAG = "StoryContentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_content);

        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubcrible();
        super.onDestroy();
    }

    private void initData() {
        id = getIntent().getIntExtra("id", 0);
        if (id != 0) {
            mPresenter.getStoryContent(id);
            mPresenter.getStoryContentExtra(id);
        } else {
            Toast.makeText(this, "数据加载出错", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        imageSouce = (TextView) findViewById(R.id.image_source);
        mImageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        mWebView = (WebView) findViewById(R.id.webView);

        mPresenter = new StoryContentPresenter(this);
        initWebView();
        initToolBar();
    }

    private void initToolBar() {
        mToolbar.inflateMenu(R.menu.menu_story_content);
        mMenu = mToolbar.getMenu();
        mCommentProvider = (StoryContentActionProvider) MenuItemCompat.getActionProvider(mMenu.findItem(R.id.menu_comment));
        mFollowProvider = (StoryContentActionProvider) MenuItemCompat.getActionProvider(mMenu.findItem(R.id.menu_follow));
        mFollowProvider.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_thumb_up));
        mCommentProvider.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_comment));
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
        Log.d(TAG, "onRequestError: " + msg);
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

        mCommentProvider.setNum(storyContentExtra.getComments());

        mFollowProvider.setNum(storyContentExtra.getPopularity());
    }
}
