package xyz.lovemma.zhihudaily.utils;

import java.text.DecimalFormat;

/**
 * Created by OO on 2017/3/4.
 */

public class CalculateUtil {
    public static String CalculatePraise(int num) {
        if (num > 1000) {
            double d = (double) num / 1000;
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            return decimalFormat.format(d) + "K";
        }
        return Integer.toString(num);
    }
}
