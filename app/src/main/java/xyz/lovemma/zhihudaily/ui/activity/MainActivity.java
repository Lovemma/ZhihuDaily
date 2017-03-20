package xyz.lovemma.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

import xyz.lovemma.zhihudaily.App;
import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.ui.fragment.ChooseThemeFragment;
import xyz.lovemma.zhihudaily.ui.fragment.DailyStoriesFragment;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {
    private DailyStoriesFragment mStoriesFragment;
    private DrawerLayout mDrawer;
    private String DRAWER_TYPE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        initFragment();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notification:
                goToLogin();
                break;
            case R.id.action_night:
                if ((boolean) SharedPreferencesUtils.get(App.getContext(), "night_mode", false)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferencesUtils.put(App.getContext(), "night_mode", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferencesUtils.put(App.getContext(), "night_mode", true);
                }
                recreate();
                break;
            case R.id.action_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void initFragment() {
        mStoriesFragment = new DailyStoriesFragment();
        switchFragment(mStoriesFragment, "首页");
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            if (!DRAWER_TYPE.equals("首页")) {
                switchFragment(mStoriesFragment, "首页");
                ((ChooseThemeFragment) getSupportFragmentManager().findFragmentById(R.id.choose_theme)).getAdapter().setSelection(1);
                ((ChooseThemeFragment) getSupportFragmentManager().findFragmentById(R.id.choose_theme)).getAdapter().notifyDataSetChanged();
            } else {
                super.onBackPressed();
            }
        }
    }

    public void switchFragment(Fragment fragment, String title) {
        if (!Objects.equals(DRAWER_TYPE, "")
                && DRAWER_TYPE.equals(title)) {
            return;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .commit();
        DRAWER_TYPE = title;
        setTitle(title);
    }

}
