package xyz.lovemma.zhihudaily.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;

/**
 * Created by OO on 2017/2/11.
 */

public interface CommonApi {
    @GET("/api/4/news/latest")
    Observable<LatestStories> getLatestStories();

    @GET("/api/4/news/before/{date}")
    Observable<BeforeStories> getBeforeStories(@Path("date") String date);

    @GET("/api/4/news/{id}")
    Observable<StoryContent> getStoryContent(@Path("id") int id);


}
