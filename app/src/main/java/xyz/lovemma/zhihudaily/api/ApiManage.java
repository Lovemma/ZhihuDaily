package xyz.lovemma.zhihudaily.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by OO on 2017/2/11.
 */

public class ApiManage {
    private static ApiManage mApiManage;
    private CommonApi mCommonApi;

    private static final int DEFAULT_TIMEOUT = 5;

    private ApiManage() {

    }

    public static ApiManage getInstance() {
        if (mApiManage == null) {
            synchronized (ApiManage.class) {
                if (mApiManage == null) {
                    mApiManage = new ApiManage();
                }
            }
        }
        return mApiManage;
    }

    private final Object Monitor = new Object();

    public CommonApi getCommonApi() {
        if (mCommonApi == null) {
            synchronized (Monitor) {
                if (mCommonApi == null) {
                    mCommonApi = configRetrofit(CommonApi.class);
                }
            }
        }
        return mCommonApi;
    }

    private <T> T configRetrofit(Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build();
}
