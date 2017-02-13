package xyz.lovemma.zhihudaily.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;

/**
 * Created by OO on 2017/2/11.
 */

public interface CommonApi {
    @GET("news/latest")
    Observable<LatestStories> getLatestStories();

    @GET("news/before/{date}")
    Observable<BeforeStories> getBeforeStories(@Path("date") String date);
}
