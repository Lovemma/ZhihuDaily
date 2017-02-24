package xyz.lovemma.zhihudaily.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.lovemma.zhihudaily.mvp.bean.BeforeStories;
import xyz.lovemma.zhihudaily.mvp.bean.LatestStories;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContent;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContentExtra;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContentLongComment;
import xyz.lovemma.zhihudaily.mvp.bean.StoryContentShortComment;
import xyz.lovemma.zhihudaily.mvp.bean.Themes;
import xyz.lovemma.zhihudaily.mvp.bean.ThemesContent;

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

    @GET("/api/4/story-extra/{id}")
    Observable<StoryContentExtra> getStoryContentExtra(@Path("id") int id);

    @GET("/api/4/story/{id}/long-comments")
    Observable<StoryContentLongComment> getStoryContentLongComments(@Path("id") int id);

    @GET("/api/4/story/{id}/short-comments")
    Observable<StoryContentShortComment> getStoryContentShortComments(@Path("id") int id);

    @GET("/api/4/themes")
    Observable<Themes> getThemesList();

    @GET("/api/4/theme/{id}")
    Observable<ThemesContent> getThemesContent(@Path("id") int id);
}
