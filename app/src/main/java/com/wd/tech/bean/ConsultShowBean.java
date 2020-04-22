package com.wd.tech.bean;

import java.util.List;

/*
/**
*
* @ProjectName: MyTech
* @Package: com.wd.tech.bean
* @ClassName: ConsultShowBean
* @Author: 刘文
* @CreateDate: 2020/4/22 下午12:25
* @UpdateUser: 更新者
* @UpdateDate: 2020/4/22 下午12:25
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
public class ConsultShowBean {
    /**
     * result : [{"collection":4,"id":65,"releaseTime":1572763883000,"share":19,"source":"ITBEAR科技资讯","summary":"双11在即，国内三大智能音箱品牌均面向用户大幅让利。天猫精灵X1和小米AI音箱到手价格均降至199元，带屏音箱天猫精灵CCL和小度在家1S到手价格低至299元，竞争进入肉搏战。","thumbnail":"http://www.itbear.com.cn/upload/2019-11/191106140480852.png","title":"2019年Q3智能音箱数据发布，天猫精灵再次国内第一","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":53,"id":54,"releaseTime":1539586683000,"share":14,"source":"中国企业家杂志©","summary":"谁说滴滴之后再无网约车？新的搅局者又来了。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/13/190901169923.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"有摩拜的前车之鉴，为何哈啰仍要入局网约车？","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":36,"id":53,"releaseTime":1539585103000,"share":7,"source":"高街高参","summary":"两天前，马云现身杭州云栖小镇，这次他的露面不是因为阿里巴巴集团的活动，也不是业界峰会，而是为政府站台，参加杭州市为打造全国数字经济第一城举办的动员大会。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/14/123637310014.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"马云力挺杭州\u201c数字经济\u201d第一城之后，我先咽下这口泡沫","whetherAdvertising":2,"whetherCollection":2,"whetherPay":1},{"collection":40,"id":52,"releaseTime":1539584990000,"share":6,"source":"Eastland","summary":"海底捞以17.8港元在港发售4.2亿新股，募集资金净额72.7亿港元，高瓴、景林、雪湖等基石投资者认购数占IPO发行量的38.95%。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/15/073628459039.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"风雨飘摇中，海底捞能否成为投资避风港？","whetherAdvertising":2,"whetherCollection":2,"whetherPay":1},{"collection":26,"id":51,"releaseTime":1539584821000,"share":1,"source":"零售威观察©","summary":"作为一家英国零售商，Primark主要销售服装、配饰、美妆、箱包和家居用品。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/15/081855659893.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"不玩电商的Primark是如何横扫美国零售市场的？","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":11,"id":16,"releaseTime":1539064295000,"share":0,"source":"刺猬公社","summary":"韩寒决定在腾讯微博发一条动态。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/09/121345634942.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"内容创业\u201c七年之痒\u201d","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":9,"id":12,"releaseTime":1539054007000,"share":0,"source":"凡夫俗子Eric","summary":"1929年10月24日，黑色星期四。","thumbnail":"https://img.huxiucdn.com/article/cover/201810/07/065018518143.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"带薪休假，这么近却又那么远","whetherAdvertising":2,"whetherCollection":2,"whetherPay":1},{"collection":9,"id":13,"releaseTime":1539054007000,"share":0,"source":"人人都是产品经理","summary":"是的 ，今天中午又点外卖了，依旧是我最爱的33元烤肉双拼饭，半肥瘦叉烧搭配煎炸过的火腿，犹如鳗鱼汁的拌饭酱浸入软糯的米饭中，酥脆的花生米作为点睛之笔，妙哉妙哉！","thumbnail":"https://img.huxiucdn.com/article/cover/201810/09/090918249675.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"外卖天天满25减21，商家们都是怎么挣钱的？","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":7,"id":9,"releaseTime":1539049646000,"share":0,"source":"航通社","summary":"在北京坐公交车，有时候在车前挡风玻璃上方的位置会有一个横条，贴着公交公司的标语。每天通勤的乘客疲于在拥挤的人群中保护好自己的包，对这条标语毫不在意。","thumbnail":"https://img.huxiucdn.com/article/cover/201806/19/011221199456.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"屏幕上的\u201c黑边\u201d为什么是黑色的","whetherAdvertising":2,"whetherCollection":2,"whetherPay":2},{"collection":11,"id":4,"releaseTime":1535449854000,"share":0,"source":"本文转自公众号\u201c企鹅智库\u201d","summary":"在消费、内容、娱乐领域统统叫嚷着\u201c降级\u201d的今天，三四线及以下城市人群在网络上的活跃度和他们的消费能力，已经不容被忽略了。这里有一份网民时间和金钱消费报告，调查结果显示，相比一线城市人群，三四五线城市的","thumbnail":"https://img.huxiucdn.com/article/cover/201808/28/095046582186.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg","title":"最后的红利：三四五线网民时间和金钱消费报告","whetherAdvertising":2,"whetherCollection":2,"whetherPay":1}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * collection : 4
         * id : 65
         * releaseTime : 1572763883000
         * share : 19
         * source : ITBEAR科技资讯
         * summary : 双11在即，国内三大智能音箱品牌均面向用户大幅让利。天猫精灵X1和小米AI音箱到手价格均降至199元，带屏音箱天猫精灵CCL和小度在家1S到手价格低至299元，竞争进入肉搏战。
         * thumbnail : http://www.itbear.com.cn/upload/2019-11/191106140480852.png
         * title : 2019年Q3智能音箱数据发布，天猫精灵再次国内第一
         * whetherAdvertising : 2
         * whetherCollection : 2
         * whetherPay : 2
         */

        private int collection;
        private int id;
        private long releaseTime;
        private int share;
        private String source;
        private String summary;
        private String thumbnail;
        private String title;
        private int whetherAdvertising;
        private int whetherCollection;
        private int whetherPay;

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWhetherAdvertising() {
            return whetherAdvertising;
        }

        public void setWhetherAdvertising(int whetherAdvertising) {
            this.whetherAdvertising = whetherAdvertising;
        }

        public int getWhetherCollection() {
            return whetherCollection;
        }

        public void setWhetherCollection(int whetherCollection) {
            this.whetherCollection = whetherCollection;
        }

        public int getWhetherPay() {
            return whetherPay;
        }

        public void setWhetherPay(int whetherPay) {
            this.whetherPay = whetherPay;
        }
    }
}
