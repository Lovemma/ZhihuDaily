package xyz.lovemma.zhihudaily.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.StoryContent;
import xyz.lovemma.zhihudaily.bean.StoryContentExtra;
import xyz.lovemma.zhihudaily.mvp.presenter.StoryContentPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IStoryContentView;
import xyz.lovemma.zhihudaily.utils.WebUtil;
import xyz.lovemma.zhihudaily.widget.ActionProvider.StoryContentActionProvider;

public class OtherStoryContentActivity extends AppCompatActivity implements IStoryContentView, MenuItem.OnMenuItemClickListener{
    private Toolbar mToolbar;
    private WebView mWebView;
    private Menu mMenu;
    private StoryContentActionProvider mCommentProvider;
    private StoryContentActionProvider mFollowProvider;
    private int id;

    private StoryContentPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_story_content);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubcrible();
        super.onDestroy();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.webView);

        mPresenter = new StoryContentPresenter(this);
        initWebView();
        initToolBar();
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

    private void initToolBar() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mToolbar.inflateMenu(R.menu.menu_story_content);
        mMenu = mToolbar.getMenu();
        mCommentProvider = (StoryContentActionProvider) MenuItemCompat.getActionProvider(mMenu.findItem(R.id.menu_comment));
        mFollowProvider = (StoryContentActionProvider) MenuItemCompat.getActionProvider(mMenu.findItem(R.id.menu_follow));
        mFollowProvider.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_thumb_up));
        mCommentProvider.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_comment));
        mMenu.findItem(R.id.menu_share).setOnMenuItemClickListener(this);
        mMenu.findItem(R.id.menu_collect).setOnMenuItemClickListener(this);
        mMenu.findItem(R.id.menu_comment).setOnMenuItemClickListener(this);
        mMenu.findItem(R.id.menu_follow).setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_share:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_collect:

                break;
            case R.id.menu_comment:
                break;
            case R.id.menu_follow:
                break;
        }
        return false;
    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void loadStoryContent(StoryContent storyContent) {
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
