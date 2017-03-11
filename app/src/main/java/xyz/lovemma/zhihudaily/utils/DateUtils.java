package xyz.lovemma.zhihudaily.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by OO on 2017/2/13.
 */

public class DateUtils {

    private static Date str2date(String fromDate) {
        if (fromDate == null) {
            return null;
        }
        Date date = null;
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            date = dateFormat.parse(fromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static String date2str(Date date) {
        DateFormat format = new SimpleDateFormat("MM月dd日  EEEE", Locale.CHINA);
        return format.format(date);
    }

    public static String transform(String date) {
        return date2str(str2date(date));
    }

    public static String timestamp2Date(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        return sdf.format(new Date(time * 1000));
    }
}
