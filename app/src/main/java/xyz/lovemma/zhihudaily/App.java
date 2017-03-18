package xyz.lovemma.zhihudaily;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

/**
 * Created by OO on 2017/3/17.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        boolean isNightMode = (boolean) SharedPreferencesUtils.get(mContext, "night_mode", false);
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }

    public static Context getContext() {
        return mContext;
    }

}
