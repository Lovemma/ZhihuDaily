package xyz.lovemma.zhihudaily.entity;

/**
 * Created by OO on 2017/2/10.
 */

public class TopStries {

    /**
     * image : http://pic4.zhimg.com/dfe0ebab9729822458ea6aba75c2cb63.jpg
     * type : 0
     * id : 9211461
     * ga_prefix : 021018
     * title : 那些屡次遭受家暴的受害者，为什么不选择分手离开？
     */

    private String image;
    private int type;
    private int id;
    private String ga_prefix;
    private String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
}
