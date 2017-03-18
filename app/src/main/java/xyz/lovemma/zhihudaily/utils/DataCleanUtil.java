package xyz.lovemma.zhihudaily.utils;

import android.os.Environment;

import com.bumptech.glide.Glide;

import java.io.File;

import xyz.lovemma.zhihudaily.App;

/**
 * Created by OO on 2017/3/17.
 */

public class DataCleanUtil {
    public static void cleanInternalCache() {
        Glide.getPhotoCacheDir(App.getContext()).delete();
        deleteDir(App.getContext().getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(App.getContext().getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File cacheDir) {
        if (cacheDir != null && cacheDir.isDirectory()) {
            String[] children = cacheDir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(cacheDir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        return cacheDir != null && cacheDir.delete();
    }
}
