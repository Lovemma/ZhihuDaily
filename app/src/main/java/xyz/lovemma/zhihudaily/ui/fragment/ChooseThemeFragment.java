package xyz.lovemma.zhihudaily.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.MainActivity;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.BaseItem;
import xyz.lovemma.zhihudaily.ui.adapter.drawer.DrawerHeader;
import xyz.lovemma.zhihudaily.ui.adapter.drawer.DrawerHome;
import xyz.lovemma.zhihudaily.bean.Themes;
import xyz.lovemma.zhihudaily.bean.ThemesContent;
import xyz.lovemma.zhihudaily.bean.ThemesOther;
import xyz.lovemma.zhihudaily.mvp.presenter.ThemePresenter;
import xyz.lovemma.zhihudaily.mvp.view.IThemeView;
import xyz.lovemma.zhihudaily.ui.adapter.drawer.ThemesListAdapter;

public class ChooseThemeFragment extends Fragment implements IThemeView {

    private RecyclerView navView;

    private ThemePresenter mPresenter;
    private List<BaseItem> mList = new ArrayList<>();
    private ThemesListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_theme, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navView = (RecyclerView) view.findViewById(R.id.nav_view);
        mPresenter = new ThemePresenter(this);
        mAdapter = new ThemesListAdapter(getContext(), mList);
        mAdapter.setOnItemClickListener(new ThemesListAdapter.OnItemClickListener() {
            @Override
            public void onDrawerHeaderClick() {
                Toast.makeText(getContext(), "onDrawerHeaderClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemViewClick(View view, RecyclerView.ViewHolder holder, int position) {
                mAdapter.setSelection(position);
                mAdapter.notifyDataSetChanged();
                MainActivity activity = (MainActivity) getActivity();
                if (position != 1) {
//                    Toast.makeText(getContext(), "onItemViewClick:" + ((ThemesOther) mAdapter.getDatas().get(position)).getName(), Toast.LENGTH_SHORT).show();
                    int id = ((ThemesOther) mAdapter.getDatas().get(position)).getId();
                    activity.switchFragment(id, MainActivity.DRAWER_OTHER,position);
                } else {
                    activity.switchFragment();
                }
                getActivity().onBackPressed();
            }
        });
        init();
    }

    private void init() {
        navView.setLayoutManager(new LinearLayoutManager(getContext()));
        navView.setItemAnimator(new DefaultItemAnimator());
        navView.setAdapter(mAdapter);
        mPresenter.getThemesList();
    }

    @Override
    public void onDestroy() {
        mPresenter.unsubcrible();
        super.onDestroy();
    }

    @Override
    public void onRequestError(String msg) {

    }

    @Override
    public void loadThemeList(Themes themes) {
        mList.add(new DrawerHeader());
        mList.add(new DrawerHome());
        mList.addAll(themes.getOthers());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadThemeContent(ThemesContent content) {

    }
}
