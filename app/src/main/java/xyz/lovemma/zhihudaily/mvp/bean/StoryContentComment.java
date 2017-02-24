package xyz.lovemma.zhihudaily.mvp.bean;

/**
 * Created by OO on 2017/2/24.
 */

public class StoryContentComment {

    /**
     * author : 少先大队委员长
     * content : “中国三四线城市现在拥有苹果手机的人数量不在少数”作者这句话的前提是一二线城市现在拥有苹果手机的人非常多。你可能是听多了国内各大厂商对自家手机的宣传所以才会产生苹果越来越差，国产机完全秒杀的错觉。另外就硬件来讲安卓在屏幕，像素，cpu,ram等方面上多年来一直是强过苹果的，但是体验上却很少能有与苹果比肩的，系统的流畅度不是单纯的硬件堆砌能实现的。至于安卓超越ios这个就太夸张了，只能说各有优劣，适合自己的才是最好的，另外安卓与ios多年来也是互相借鉴，谈不上抄袭，毕竟用户需求摆在那里，大家共同进步更好，再考虑到国内对谷歌的阉割所以就国内的体验来讲我觉得安卓还是远远落后于ios的，至于各家的UI也是双刃剑的，符合了国人的使用习惯但是广告太多之类的小问题也是不少。“独创性，改革意义”这种事不是短短几年内就会多次出现的就像汽车发明这么多年了不还是依然四个轱辘么，也没见它上天也没见它下海，要有耐心。以上是我的个人意见
     * avatar : http://pic1.zhimg.com/01c635a7439ff86ff7138f93d5a281dc_im.jpg
     * time : 1487478427
     * reply_to : {"content":"说白了，就是没有原则的的\u201c助手\u201d软件抢了黑心厂商苹果爸爸的钱。\n可能坏处是让正版游戏的收入减少，没有资金进行研发。好处也是有的，竞争性抑制。\u201c玩游戏要钱可以，别太过分啊！要不我换地方了\u201d。不让苹果和游戏厂商心太黑。另外，担心游戏行业无法发展维持的人想太多了，游戏行业的利润总比你想象的多。\n还有一点，作者说:\u201c苹果在三四线城市的占有量还是非常大的\u201d，正好说明了苹果在一二线城市占有率不高。真正懂手机现在不怎么喜欢苹果。\n个人认为，乔帮主之后的苹果，就是个垃鸡。硬件创新每年就那个几年，\u201c独创性\u201d和\u201c改革意义\u201d更是几乎没有。系统研发慢慢的开始成为了\u201c抄安卓\u201d。就靠着乔老爷子开创的\u201c软硬件完美结合\u201d混日子。\n随着安卓硬件的快速发展，几乎快追上苹果，系统更是早就超越苹果，这点是我个人意见。软件的生态优势，强于安卓。\n苹果就是个碌碌无为的混日子公司。早就不是那个智能机的开创者了。当然了，暂时还是死不了。百足之虫，死而不僵。","status":0,"id":28150411,"author":"张文辉"}
     * id : 28160966
     * likes : 6
     */

    private String author;
    private String content;
    private String avatar;
    private int time;
    private ReplyToBean reply_to;
    private int id;
    private int likes;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ReplyToBean getReply_to() {
        return reply_to;
    }

    public void setReply_to(ReplyToBean reply_to) {
        this.reply_to = reply_to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public static class ReplyToBean {
        /**
         * content : 说白了，就是没有原则的的“助手”软件抢了黑心厂商苹果爸爸的钱。
         可能坏处是让正版游戏的收入减少，没有资金进行研发。好处也是有的，竞争性抑制。“玩游戏要钱可以，别太过分啊！要不我换地方了”。不让苹果和游戏厂商心太黑。另外，担心游戏行业无法发展维持的人想太多了，游戏行业的利润总比你想象的多。
         还有一点，作者说:“苹果在三四线城市的占有量还是非常大的”，正好说明了苹果在一二线城市占有率不高。真正懂手机现在不怎么喜欢苹果。
         个人认为，乔帮主之后的苹果，就是个垃鸡。硬件创新每年就那个几年，“独创性”和“改革意义”更是几乎没有。系统研发慢慢的开始成为了“抄安卓”。就靠着乔老爷子开创的“软硬件完美结合”混日子。
         随着安卓硬件的快速发展，几乎快追上苹果，系统更是早就超越苹果，这点是我个人意见。软件的生态优势，强于安卓。
         苹果就是个碌碌无为的混日子公司。早就不是那个智能机的开创者了。当然了，暂时还是死不了。百足之虫，死而不僵。
         * status : 0
         * id : 28150411
         * author : 张文辉
         */

        private String content;
        private int status;
        private int id;
        private String author;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
