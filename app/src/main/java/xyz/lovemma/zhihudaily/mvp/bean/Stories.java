package xyz.lovemma.zhihudaily.mvp.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/10.
 */

public class Stories {

    /**
     * images : ["http://pic1.zhimg.com/c794daedda9087b658ec312340904ffc.jpg"]
     * type : 0
     * id : 9205443
     * ga_prefix : 021020
     * title : 现在的城市也许都是高楼，但刚开始的时候谁和谁都不一样
     * multipic : true
     */

    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multipic;
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

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
