package xyz.lovemma.zhihudaily;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import xyz.lovemma.zhihudaily.ui.activity.LoginActivity;
import xyz.lovemma.zhihudaily.ui.fragment.ChooseThemeFragment;
import xyz.lovemma.zhihudaily.ui.fragment.DailyStoriesFragment;

public class MainActivity extends AppCompatActivity  {
    private DailyStoriesFragment mStoriesFragment;
    private Fragment currentFragment = new Fragment();
    private DrawerLayout mDrawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(mToolbar);
        initFragment();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar,
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

                break;
            case R.id.action_setting:

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
            if (currentFragment != mStoriesFragment) {
                switchFragment(mStoriesFragment, "首页");
                ((ChooseThemeFragment) getSupportFragmentManager().findFragmentById(R.id.choose_theme)).getAdapter().setSelection(1);
                ((ChooseThemeFragment) getSupportFragmentManager().findFragmentById(R.id.choose_theme)).getAdapter().notifyDataSetChanged();
            } else {
                super.onBackPressed();
            }
        }
    }

    public void switchFragment(Fragment fragment, CharSequence title) {
        if (currentFragment == fragment) {
            return;
        }
        if (fragment.isAdded()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .hide(currentFragment)
                    .show(fragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .hide(currentFragment)
                    .add(R.id.container, fragment)
                    .show(fragment)
                    .commit();
        }
        currentFragment = fragment;
        setTitle(title);
    }

}
