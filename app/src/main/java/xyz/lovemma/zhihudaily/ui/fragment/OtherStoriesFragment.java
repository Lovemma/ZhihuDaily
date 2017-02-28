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

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.bean.ThemesContent;
import xyz.lovemma.zhihudaily.mvp.presenter.OtherStoryPresenter;
import xyz.lovemma.zhihudaily.mvp.view.IOtherStoriesView;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesHeader;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesListAdapter;
import xyz.lovemma.zhihudaily.ui.adapter.other.OtherStoriesSection;

public class OtherStoriesFragment extends Fragment implements IOtherStoriesView{

    private static final String LIST_ID = "list_id";
    private int id;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<BaseItem> mItemList = new ArrayList<>();

    private OtherStoryPresenter mPresenter;
    private OtherStoriesListAdapter mAdapter;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other_stories, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipRefreshlayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new OtherStoryPresenter(this);
        mAdapter = new OtherStoriesListAdapter(getContext(), mItemList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getOtherStories(id);

    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void loadStories(ThemesContent themesContent) {
        mItemList.add(new OtherStoriesHeader(themesContent.getBackground(), themesContent.getDescription()));
        mItemList.add(new OtherStoriesSection(themesContent.getEditors().get(0)));
        mItemList.addAll(themesContent.getStories());
        mAdapter.notifyDataSetChanged();

    }
}
