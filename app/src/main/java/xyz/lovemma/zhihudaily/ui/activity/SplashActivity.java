package xyz.lovemma.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import xyz.lovemma.zhihudaily.R;
import xyz.lovemma.zhihudaily.bean.LaunchImage;
import xyz.lovemma.zhihudaily.mvp.presenter.SplashPresenter;
import xyz.lovemma.zhihudaily.mvp.view.ISplashView;
import xyz.lovemma.zhihudaily.utils.SharedPreferencesUtils;

public class SplashActivity extends AppCompatActivity implements ISplashView {
    private ImageView launchImage;
    private String imgUrl;
    private SplashPresenter mPresenter;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 10086) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        launchImage = (ImageView) findViewById(R.id.launch_image);
        mPresenter = new SplashPresenter(this);
        mPresenter.getLaunchImage();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unSubcrible();
        super.onDestroy();
    }

    @Override
    public void onRequestError() {
        imgUrl = (String) SharedPreferencesUtils.get(this, "launch_image", "");
        if (TextUtils.isEmpty(imgUrl)) {
            Glide.with(this)
                    .load(imgUrl)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(launchImage);
        }
    }

    @Override
    public void getLaunchImage(LaunchImage image) {
        imgUrl = image.getCreatives().get(0).getUrl();
        Glide.with(this)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(launchImage);
        SharedPreferencesUtils.put(this, "launch_image", imgUrl);
    }

    @Override
    public void onRequestEnd() {
        Message message = new Message();
        message.what = 10086;
        mHandler.sendMessageDelayed(message, 3000);
    }
}
