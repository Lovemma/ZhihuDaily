package xyz.lovemma.zhihudaily.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/10.
 */

public class Stories implements BaseItem {

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multiPic;
    private List<String> images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMultiPic() {
        return multiPic;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
