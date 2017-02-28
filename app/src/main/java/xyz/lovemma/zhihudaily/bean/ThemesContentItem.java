package xyz.lovemma.zhihudaily.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/24.
 */

public class ThemesContentItem implements BaseItem{

    /**
     * images : ["http://pic1.zhimg.com/c7cd4c64f429b79e6d269723bd7b10f0_t.jpg"]
     * type : 0
     * id : 4827436
     * title : 从日俄战争到神经科学的二次革命（多图）
     */

    private int type;
    private int id;
    private String title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
