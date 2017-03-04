package xyz.lovemma.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.BeforeStories;
import xyz.lovemma.zhihudaily.bean.LatestStories;
import xyz.lovemma.zhihudaily.mvp.presenter.StoriesPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IStoriesView;
import xyz.lovemma.zhihudaily.ui.adapter.home.StoriesHeader;
import xyz.lovemma.zhihudaily.ui.adapter.home.StoriesListAdapter;
import xyz.lovemma.zhihudaily.ui.adapter.home.StoriesSection;

public class DailyStoriesFragment extends Fragment implements IStoriesView {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private StoriesPresenter mPresenter;
    private StoriesListAdapter mAdapter;
    private List<BaseItem> mItemList = new ArrayList<>();
    private LoadMoreWrapper mLoadMoreWrapper;
    private String date;
    private boolean isRefresh;

    public DailyStoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_stories, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipRefreshlayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initData() {
        mPresenter = new StoriesPresenter(this);
        mAdapter = new StoriesListAdapter(getContext(), mItemList);
        mLoadMoreWrapper = new LoadMoreWrapper(mAdapter);
    }

    private void initView() {
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getBeforeDaily(date);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mLoadMoreWrapper);
        mPresenter.getLatestStories();
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPresenter.getLatestStories();
            }
        });
    }

    @Override
    public void onDestroy() {
        mPresenter.unsubcrible();
        super.onDestroy();
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadLatestStories(LatestStories latestStories) {
        if (isRefresh) {
            mItemList.clear();
            mLoadMoreWrapper.notifyDataSetChanged();
        }
        date = latestStories.getDate();
        mItemList.add(new StoriesHeader(latestStories.getTop_stories()));
        mItemList.add(new StoriesSection(latestStories.getDate()));
        mItemList.addAll(latestStories.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
        isRefresh = true;
    }

    @Override
    public void loadBeforeStories(BeforeStories beforeStories) {
        date = beforeStories.getDate();
        mItemList.add(new StoriesSection(beforeStories.getDate()));
        mItemList.addAll(beforeStories.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
    }
}
