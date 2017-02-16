package xyz.lovemma.zhihudaily.mvp.bean;

import java.util.List;

/**
 * Created by OO on 2017/2/10.
 */

public class BeforeStories implements BaseItem{

    /**
     * date : 20170209
     * stories : [{"images":["http://pic2.zhimg.com/6107e50d841116ad467a4fe1d806b5ad.jpg"],"type":0,"id":9206946,"ga_prefix":"020922","title":"小事 · 对，我是四川人；对，我不吃辣"},{"images":["http://pic4.zhimg.com/856e01e61c85caf111f9a91ca1f30dfb.jpg"],"type":0,"id":9208917,"ga_prefix":"020921","title":"除了最后 10 分钟，这部片似乎只是个普通的校园故事"},{"images":["http://pic3.zhimg.com/11d5bd087a96964ea65edde1358c95b2.jpg"],"type":0,"id":9209098,"ga_prefix":"020920","title":"当员工觉得自己被老板忽视，一场循环就开始了"},{"images":["http://pic4.zhimg.com/1c40698c718f180931e9dded8fdd6e93.jpg"],"type":0,"id":9208784,"ga_prefix":"020919","title":"每一个人都怀揣梦想前来，艺考早就不只是一次考试了"},{"images":["http://pic1.zhimg.com/85b07dd65e509a12ffc6f30fc9947e04.jpg"],"type":0,"id":9204386,"ga_prefix":"020918","title":"「能活多久」这件事是由什么决定的？"},{"title":"闪光灯人像入门，专治从零开始到放弃","ga_prefix":"020917","images":["http://pic3.zhimg.com/672a277453e0fb0eb11f99a6bbf52f46.jpg"],"multipic":true,"type":0,"id":9205800},{"images":["http://pic4.zhimg.com/0e3dbc687a5f6681b2e61c142b303693.jpg"],"type":0,"id":9205777,"ga_prefix":"020916","title":"在日本，稻米们都有一个温柔的名字"},{"images":["http://pic1.zhimg.com/f863ec4841d5d7bfc95a490baa6f9184.jpg"],"type":0,"id":9205750,"ga_prefix":"020915","title":"想想哄抢苹果，懂了为什么网址里的「HTTPS」很重要"},{"images":["http://pic4.zhimg.com/adb30e3f51750a210deaeb5532dd2f6f.jpg"],"type":0,"id":9208345,"ga_prefix":"020914","title":"传情达意还是要靠好吃的，来做一份心形的林茨饼干吧"},{"images":["http://pic3.zhimg.com/2bb675c7253a8e3afefe5b53608d1cda.jpg"],"type":0,"id":9207944,"ga_prefix":"020913","title":"知识到底应不应该免费提供给需要的人？"},{"images":["http://pic2.zhimg.com/a1c27838802b08f402bbf295a885e6e9.jpg"],"type":0,"id":9208240,"ga_prefix":"020912","title":"《职人介绍所》第二季第四期：用爱好养活自己的这帮人"},{"title":"大误 · 只吃葡萄糖能活么？","ga_prefix":"020912","images":["http://pic3.zhimg.com/be9f3a1e24fb4fca8e2f01da6bac28fe.jpg"],"multipic":true,"type":0,"id":9205323},{"images":["http://pic3.zhimg.com/36454768d0ab9b1b58e127ce5a83084e.jpg"],"type":0,"id":9205639,"ga_prefix":"020911","title":"酸辣猛烈、爽脆直接，一道让人「闻」之色变的东北老虎菜"},{"images":["http://pic4.zhimg.com/79e41b1717d4b6b7692374e850b8bedf.jpg"],"type":0,"id":9206971,"ga_prefix":"020910","title":"人类是如何判断四维空间存在的？"},{"images":["http://pic3.zhimg.com/6d737f5d030fb3b6ac85cc91cd0ecf52.jpg"],"type":0,"id":9206068,"ga_prefix":"020909","title":"HR 怎么面试 HR？更少的套路、更长时间、更多耐心"},{"images":["http://pic2.zhimg.com/bf750e24470a5129691936c6221ec1c1.jpg"],"type":0,"id":9206325,"ga_prefix":"020908","title":"因为教下属「放飞机」，一位高级审计员丢了工作"},{"images":["http://pic4.zhimg.com/6a9cb6cec8ede84cb5eea6ca23ce8c1f.jpg"],"type":0,"id":9207296,"ga_prefix":"020907","title":"化工厂爆炸时，怎样处理才能尽量减少影响？"},{"images":["http://pic2.zhimg.com/86a4635355501cdb066488fc5db9e44d.jpg"],"type":0,"id":9205740,"ga_prefix":"020907","title":"数据分析会骗人吗？会，而且是花样翻新地骗"},{"images":["http://pic3.zhimg.com/4f5d874fa53adb78a17a4e914cfdbf2e.jpg"],"type":0,"id":9206072,"ga_prefix":"020907","title":"中国市场低迷，苹果转向了印度，然而印度也不好混啊"},{"images":["http://pic3.zhimg.com/5df196d5790d1d42d1db2fbed86694ae.jpg"],"type":0,"id":9205264,"ga_prefix":"020906","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<Stories> stories;

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
}
