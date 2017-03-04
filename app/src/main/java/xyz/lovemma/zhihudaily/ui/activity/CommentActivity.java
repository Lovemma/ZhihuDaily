package xyz.lovemma.zhihudaily.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.bean.StoryContentShortComment;
import xyz.lovemma.zhihudaily.mvp.presenter.CommentContentPresenter;
import xyz.lovemma.zhihudaily.mvp.view.ICommentContentView;
import xyz.lovemma.zhihudaily.ui.adapter.comment.CommentAdapter;
import xyz.lovemma.zhihudaily.ui.adapter.comment.CommentEmpty;
import xyz.lovemma.zhihudaily.ui.adapter.comment.CommentSection;

public class CommentActivity extends AppCompatActivity implements ICommentContentView {

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private CommentAdapter mAdapter;
    private List<BaseItem> mItemList = new ArrayList<>();

    private CommentContentPresenter mPresenter;

    private int id;
    private int commentNum;
    private int longCommentNum;
    private int shortCommentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unsubcrible();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_comment, menu);
        return true;
    }

    public void initView() {
        initToolBar();
        mPresenter = new CommentContentPresenter(this);
        mAdapter = new CommentAdapter(this, mItemList);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_comment);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        id = getIntent().getIntExtra("id", 0);
        commentNum = getIntent().getIntExtra("comment_num", 0);
        longCommentNum = getIntent().getIntExtra("long_comment_num", 0);
        shortCommentNum = getIntent().getIntExtra("short_comment_num", 0);
        if (id != 0) {
            mPresenter.getStoryContentLongComments(id);
//            mPresenter.getStoryContentShortComments(id);
        } else {
            Toast.makeText(this, "数据加载出错", Toast.LENGTH_SHORT).show();
        }
        getSupportActionBar().setTitle(commentNum + "条点评");
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadStoryContentLongComments(StoryContentLongComment longComment) {
        mItemList.add(new CommentSection(longCommentNum, CommentSection.LONG_COMMENT));
        if (longCommentNum != 0) {
            mItemList.addAll(longComment.getComments());
        } else {
            mItemList.add(new CommentEmpty());
        }
        mPresenter.getStoryContentShortComments(id);
    }

    @Override
    public void loadStoryContentShortComments(StoryContentShortComment shortComment) {
        mItemList.add(new CommentSection(shortCommentNum, CommentSection.SHORT_COMMENT));
        mItemList.addAll(shortComment.getComments());
        mAdapter.notifyDataSetChanged();
    }
}
