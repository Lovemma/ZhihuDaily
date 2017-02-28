package xyz.lovemma.zhihudaily;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import xyz.lovemma.zhihudaily.ui.fragment.DailyStoriesFragment;
import xyz.lovemma.zhihudaily.ui.fragment.OtherStoriesFragment;

public class MainActivity extends AppCompatActivity {
    public static final int DRAWER_HOME = 1;
    public static final int DRAWER_OTHER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        switchFragment();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    private int mPosition = 0;

    public void switchFragment(int id, int type,int position) {
        if (mPosition == position) {
            return;
        }
        if (type == DRAWER_HOME) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new DailyStoriesFragment()).commit();
        } else if (type == DRAWER_OTHER) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, OtherStoriesFragment.newInstance(id)).commit();
        }
        mPosition = position;
    }

    public void switchFragment() {
        switchFragment(0, DRAWER_HOME, 1);
        mPosition = 1;
    }
}
