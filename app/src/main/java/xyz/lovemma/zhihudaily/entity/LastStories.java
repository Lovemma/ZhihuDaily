package xyz.lovemma.zhihudaily.entity;

import java.util.List;

/**
 * Created by OO on 2017/2/10.
 */

public class LastStories {

    /**
     * date : 20170210
     * stories : [{"images":["http://pic1.zhimg.com/c794daedda9087b658ec312340904ffc.jpg"],"type":0,"id":9205443,"ga_prefix":"021020","title":"现在的城市也许都是高楼，但刚开始的时候谁和谁都不一样"},{"images":["http://pic2.zhimg.com/41bfa5bad97db4f1ab2fec48a250691d.jpg"],"type":0,"id":9211397,"ga_prefix":"021019","title":"在中国买一盒烟，有多少是税钱？"},{"images":["http://pic1.zhimg.com/08154789895a090f48315b753244c140.jpg"],"type":0,"id":9211461,"ga_prefix":"021018","title":"那些屡次遭受家暴的受害者，为什么不选择分手离开？"},{"images":["http://pic2.zhimg.com/5a238e04e713e6a2b386d176c8d4d275.jpg"],"type":0,"id":9211186,"ga_prefix":"021017","title":"法规之外，这项技术会是防止无人机干扰民航的关键"},{"images":["http://pic4.zhimg.com/d8bbedc51991b1a9da372bb1adc791db.jpg"],"type":0,"id":9200053,"ga_prefix":"021016","title":"身体里涌过一阵「暖流」，感觉好奇妙"},{"images":["http://pic2.zhimg.com/6ecda2cd82710ca9a65be31f1b490f61.jpg"],"type":0,"id":9034429,"ga_prefix":"021015","title":"用这个完美爱情的公式，来看看你的爱情是哪一种模式"},{"images":["http://pic2.zhimg.com/178c8a0f1759c3b45ff70b92baeb1321.jpg"],"type":0,"id":9208718,"ga_prefix":"021014","title":"未来十年，金融行业会被人工智能取代吗？"},{"images":["http://pic4.zhimg.com/25b92c5a96986c51664962a2f7550c3f.jpg"],"type":0,"id":9204413,"ga_prefix":"021013","title":"「做啥都不快乐」和「觉得自己做啥都不快乐」是不一样的"},{"images":["http://pic3.zhimg.com/0b3ec8b84519a6e6b1c448a59e4aa06e.jpg"],"type":0,"id":9209484,"ga_prefix":"021012","title":"大误 · 我当初学这些都是为了啥？"},{"images":["http://pic2.zhimg.com/8b4dad732f253f03632d752504f7d0bd.jpg"],"type":0,"id":9205630,"ga_prefix":"021011","title":"「书里夹片叶子后来都变臭了」，标本不是这么做的啊喂"},{"images":["http://pic4.zhimg.com/daba11c65ecbb6f1215e0184ac39b643.jpg"],"type":0,"id":9207959,"ga_prefix":"021010","title":"算算电价和油价，电动车并不一定就比汽油车省钱"},{"images":["http://pic3.zhimg.com/738e5fe13266c669429e04f06ed8bcd6.jpg"],"type":0,"id":9201111,"ga_prefix":"021009","title":"是个中国人就可以在美国教中文吗？当然不是"},{"images":["http://pic3.zhimg.com/0cad57735522122e144febe32556e15a.jpg"],"type":0,"id":9208952,"ga_prefix":"021008","title":"《英雄联盟》 2017 全球总决赛在中国举行会有哪些影响？"},{"images":["http://pic2.zhimg.com/375ee2a128d42d970d86c11a9c79ccd5.jpg"],"type":0,"id":9206449,"ga_prefix":"021007","title":"当我们聊玩具制造的时候，Made in China 就是世界一流"},{"title":"在国外开车和在国内开车有什么不一样的感受？","ga_prefix":"021007","images":["http://pic3.zhimg.com/e73402fcf5d39cae6260e6ef05c0218e.jpg"],"multipic":true,"type":0,"id":9204393},{"images":["http://pic4.zhimg.com/726b5d8c9f51e77e1e076c6558fc6853.jpg"],"type":0,"id":9200465,"ga_prefix":"021007","title":"「确定」和「取消」按钮哪个在左哪个在右，你注意过吗？"},{"images":["http://pic3.zhimg.com/88605dcc5eae27a9273d016961d0387a.jpg"],"type":0,"id":9203141,"ga_prefix":"021006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/dfe0ebab9729822458ea6aba75c2cb63.jpg","type":0,"id":9211461,"ga_prefix":"021018","title":"那些屡次遭受家暴的受害者，为什么不选择分手离开？"},{"image":"http://pic2.zhimg.com/fe3cc01975fcb64842349a629deb039d.jpg","type":0,"id":9208952,"ga_prefix":"021008","title":"《英雄联盟》 2017 全球总决赛在中国举行会有哪些影响？"},{"image":"http://pic4.zhimg.com/b687c92faad94a0adfc708aea52700c7.jpg","type":0,"id":9208784,"ga_prefix":"020919","title":"每一个人都怀揣梦想前来，艺考早就不只是一次考试了"},{"image":"http://pic3.zhimg.com/c0ace161922ad0f01c027e2e4db27616.jpg","type":0,"id":9208345,"ga_prefix":"020914","title":"传情达意还是要靠好吃的，来做一份心形的林茨饼干吧"},{"image":"http://pic3.zhimg.com/63b553d85bee65c9f75b827de34a914a.jpg","type":0,"id":9208240,"ga_prefix":"020912","title":"《职人介绍所》第二季第四期：用爱好养活自己的这帮人"}]
     */

    private String date;
    private List<Stories> stories;
    private List<TopStries> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Stories> getStories() {
        return stories;
    }

    public void setStories(List<Stories> stories) {
        this.stories = stories;
    }

    public List<TopStries> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStries> top_stories) {
        this.top_stories = top_stories;
    }
}
