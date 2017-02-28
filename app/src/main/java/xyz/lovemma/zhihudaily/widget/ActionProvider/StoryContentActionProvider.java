package xyz.lovemma.zhihudaily.widget.ActionProvider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

import xyz.lovemma.zhihudaily.R;

/**
 * Created by OO on 2017/2/20.
 */

public class StoryContentActionProvider extends ActionProvider {
    /**
     * Creates a new instance. ActionProvider classes should always implement a
     * constructor that takes a single Context parameter for inflating from menu XML.
     *
     * @param context Context for accessing resources.
     */
    public StoryContentActionProvider(Context context) {
        super(context);
    }

    private ImageView mImageView;
    private TextView mTextView;

    @Override
    public View onCreateActionView() {
        int size = getContext().getResources().getDimensionPixelSize(
                android.support.design.R.dimen.abc_action_bar_default_height_material);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.menu_action_provider, null, false);
        view.setLayoutParams(params);

        mImageView = (ImageView) view.findViewById(R.id.icon);
        mTextView = (TextView) view.findViewById(R.id.num);

        return view;
    }

    public void setIcon(Drawable icon) {
        mImageView.setImageDrawable(icon);
    }

    public void setNum(int num) {
        mTextView.setText(CalculateNum(num));
    }

    private String CalculateNum(int num) {
        if (num > 1000) {
            mTextView.setTextSize(12);
            double d = (double) num / 1000;
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            return decimalFormat.format(d) + "K";
        }
        return Integer.toString(num);
    }
}
