package com.wangou.robot.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/6.
 */
public class News {

    /**
     * code : 302000
     * text : 亲，已帮您找到相关新闻
     * list : [{"article":"王儒林不再任山西省委书记:愉快服从组织安排","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0701/04/BQS62VJV00014AED.html"},{"article":"外媒:8名在中国丹东工作朝鲜女员工集体出逃","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0701/06/BQSBPEET0001121M.html"},{"article":"\"连云港电大女生被辱\"续:施暴者曾遭校园暴力","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0701/01/BQRRJOGU00014AED.html"},{"article":"北京检察院依法告知和公布雷洋尸检鉴定意见","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0630/16/BQQPHH1J0001124J.html"},{"article":"媒体:这5次大会上领导人曾讲了不少狠话","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0630/23/BQRKG9780001124J.html"},{"article":"埃航客机黑匣子获修复 客机可能曾起火燃烧","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0701/01/BQRRLO7C00014AED.html"},{"article":"土耳其警方逮捕22名机场袭击事件嫌疑人","source":"网易新闻","icon":"","detailurl":"http://news.163.com/16/0630/23/BQRIU7QG0001121M.html"}]
     */

    private int code;
    private String text;
    /**
     * article : 王儒林不再任山西省委书记:愉快服从组织安排
     * source : 网易新闻
     * icon :
     * detailurl : http://news.163.com/16/0701/04/BQS62VJV00014AED.html
     */

    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String article;
        private String source;
        private String icon;
        private String detailurl;

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDetailurl() {
            return detailurl;
        }

        public void setDetailurl(String detailurl) {
            this.detailurl = detailurl;
        }

        @Override
        public String toString() {
            return this.article;
        }
    }
}
