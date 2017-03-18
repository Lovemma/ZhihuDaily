package xyz.lovemma.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.Editors;
import xyz.lovemma.zhihudaily.utils.NetWorkUtils;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;
import xyz.lovemma.zhihudaily.widget.CircleTransform;

public class EditorListActivity extends AppCompatActivity {
    private final List<Editors> mEditorsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_list);
        initData();
        initView();
    }

    private void initData() {
        ArrayList<Editors> arrayList = getIntent().getParcelableArrayListExtra("editorList");
        mEditorsList.addAll(arrayList);
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.editor_list);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.setTitle("主编");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new CommonAdapter<Editors>(this, R.layout.editor_list_item, mEditorsList) {
            @Override
            protected void convert(ViewHolder holder, Editors editors, int position) {
                ((TextView) holder.getView(R.id.editor_name)).setText(editors.getName());
                ((TextView) holder.getView(R.id.editor_bio)).setText(editors.getBio());
                if ((boolean) SharedPreferencesUtils.get(App.getContext(), "NO_IMAGE_MODE", false)
                        && !NetWorkUtils.isWifiConnected(App.getContext())) {
                    Glide.with(EditorListActivity.this)
                            .load(R.drawable.editor_profile_avatar)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .transform(new CircleTransform(mContext))
                            .into((ImageView) holder.getView(R.id.editor_avatar));
                } else {
                    Glide.with(EditorListActivity.this)
                            .load(editors.getAvatar())
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .transform(new CircleTransform(mContext))
                            .into((ImageView) holder.getView(R.id.editor_avatar));
                }
                final int id = editors.getId();
                holder.getView(R.id.editor_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EditorListActivity.this, EditorInfoActivity.class);
                        intent.putExtra("editor_id", id);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
