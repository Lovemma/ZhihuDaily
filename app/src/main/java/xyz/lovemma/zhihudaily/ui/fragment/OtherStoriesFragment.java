package xyz.lovemma.zhihudaily.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.BeforeThemeStories;
import xyz.lovemma.zhihudaily.bean.ThemesContent;
import xyz.lovemma.zhihudaily.mvp.presenter.OtherStoryPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IOtherStoriesView;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesHeader;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesListAdapter;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesSection;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

public class OtherStoriesFragment extends Fragment implements IOtherStoriesView {

    private static final String LIST_ID = "list_id";
    private int id;
    private int story_id;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private final List<BaseItem> mItemList = new ArrayList<>();

    private OtherStoryPresenter mPresenter;
    private LoadMoreWrapper mLoadMoreWrapper;
    private boolean isRefresh;

    public OtherStoriesFragment() {
    }

    public static OtherStoriesFragment newInstance(int param1) {
        OtherStoriesFragment fragment = new OtherStoriesFragment();
        Bundle args = new Bundle();
        args.putInt(LIST_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(LIST_ID);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other_stories, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onDestroyView() {
        mItemList.clear();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mPresenter.unSubcrible();
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new OtherStoryPresenter(this);
        OtherStoriesListAdapter adapter = new OtherStoriesListAdapter(getContext(), mItemList);
        mLoadMoreWrapper = new LoadMoreWrapper(adapter);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (story_id != 0) {
                    mPresenter.getMoreThemeStories(id, story_id);
                }
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mLoadMoreWrapper);
        mPresenter.getOtherStories(id);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPresenter.getOtherStories(id);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_other_story, menu);
        if (SharedPreferencesUtils.contains(App.getContext(), Integer.toString(id))
                && (boolean) SharedPreferencesUtils.get(App.getContext(), Integer.toString(id), false)) {
            menu.findItem(R.id.action_follow).setIcon(R.drawable.ic_remove_follow);
        } else {
            menu.findItem(R.id.action_follow).setIcon(R.drawable.ic_add_follow);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_follow:
                if ((boolean) SharedPreferencesUtils.get(App.getContext(), Integer.toString(id), false)) {
                    SharedPreferencesUtils.put(App.getContext(), Integer.toString(id), false);
                    Toast.makeText(getContext(), "已取消关注", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_add_follow);
                } else {
                    SharedPreferencesUtils.put(App.getContext(), Integer.toString(id), true);
                    Toast.makeText(getContext(), "已关注", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_remove_follow);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setStoryId(int storyId) {
        this.story_id = storyId;
    }

    @Override
    public void loadStories(ThemesContent themesContent) {
        if (isRefresh) {
            mItemList.clear();
            mLoadMoreWrapper.notifyDataSetChanged();
        }
        mItemList.add(new OtherStoriesHeader(themesContent.getBackground(), themesContent.getDescription()));
        mItemList.add(new OtherStoriesSection(themesContent.getEditors()));
        mItemList.addAll(themesContent.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
        isRefresh = true;
    }

    @Override
    public void loadMoreStories(BeforeThemeStories item) {
        mItemList.addAll(item.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
    }
}
