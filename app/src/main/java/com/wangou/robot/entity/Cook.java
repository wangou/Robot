package com.wangou.robot.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/6.
 */
public class Cook {

    /**
     * code : 308000
     * text : 亲，已帮您找到菜谱信息
     * list : [{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/e09f48787d4411e59d1013a10792eddb.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、葱、姜、蒜、盐、生抽、老抽、料酒、白糖、鸡精","detailurl":"http://m.xiachufang.com/recipe/268353/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/cac61c9c7c8e11e5a8be871ace9ea97a.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、清水、冰糖、油、香葱、姜片、桂皮、八角、细盐、生抽、花雕酒","detailurl":"http://m.xiachufang.com/recipe/9730/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/5d2499307d2811e5ae209f2a0a6bbc91.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、冰糖、老抽、生抽、料酒、生姜、桂皮、八角、京葱、色拉油","detailurl":"http://m.xiachufang.com/recipe/124513/"},{"name":"红烧排骨（简约版）","icon":"http://s2.cdn.xiachufang.com/031072e37e7111e5aaa6297e62e46ba1.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、生抽、老抽、冰糖或白糖、开水","detailurl":"http://m.xiachufang.com/recipe/100392328/"},{"name":"家常红烧排骨","icon":"http://s1.cdn.xiachufang.com/fe994fc27d1e11e59f9ab82a72e00100.jpg@2o_50sh_1pr_1l_280w_216h_1c_1e_90q_1wh.jpg","info":"排骨、干香菇、土豆、红椒、八角、干辣椒、花椒、香叶、桂皮、小茴香、香葱、老姜、料酒、老抽、白糖、盐","detailurl":"http://m.xiachufang.com/recipe/90754/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/2e367517877411e58131a7a57ab5bee0.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨 400克 清水 400ml、冰糖 15克 油 1大匙、香葱 2根 姜片 5片、桂皮 2小块8克 八角 2颗、花雕酒 1大匙","detailurl":"http://m.xiachufang.com/recipe/100590646/"},{"name":"红烧土豆排骨&肉","icon":"http://s2.cdn.xiachufang.com/f33e52827dad11e58728b82a72e00100.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、五花肉、土豆、豆瓣、姜、大蒜、干辣椒、花椒、老抽、料酒、八角、五香粉、白糖、葱、油","detailurl":"http://m.xiachufang.com/recipe/100016719/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/6ae385597eeb11e5bc89f529165270c8.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、花椒、八角、香叶、桂皮、干红辣椒、干山楂、草果、老姜、冰糖、生抽、老抽、盐、陈醋","detailurl":"http://m.xiachufang.com/recipe/100538114/"},{"name":"红烧排骨土豆","icon":"http://s1.cdn.xiachufang.com/9b35d2387d3311e59f440fc49ea9bf36.jpg@2o_50sh_1pr_1l_280w_216h_1c_1e_90q_1wh.jpg","info":"排骨、土豆、葱段、姜片、蒜、八角、香叶、冰糖、酱油、老抽、料酒","detailurl":"http://m.xiachufang.com/recipe/181660/"},{"name":"红烧排骨","icon":"http://s1.cdn.xiachufang.com/9ae346d27c9611e5865db82a72e00100.jpg@2o_50sh_1pr_1l_280w_216h_1c_1e_90q_1wh.jpg","info":"肋排、香菇、油、糖、葱姜、老抽、生抽、盐、八角","detailurl":"http://m.xiachufang.com/recipe/37693/"},{"name":"红烧排骨","icon":"http://s1.cdn.xiachufang.com/07a087327d4e11e59649b82a72e00100.jpg@2o_50sh_1pr_1l_280w_216h_1c_1e_90q_1wh.jpg","info":"排骨、白砂糖、醋、老抽、鸡精、生粉、葱","detailurl":"http://m.xiachufang.com/recipe/1006163/"},{"name":"家常红烧排骨","icon":"http://s2.cdn.xiachufang.com/b05606f57f1d11e5b5586b60d7e8ffb3.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"猪小排、葱、姜、蒜、八角、干红辣椒、花椒、香叶、生抽、冰糖、料酒","detailurl":"http://m.xiachufang.com/recipe/100568849/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/e5a2063c7e8411e59da4b82a72e00100.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、白砂糖、盐鸡精、料酒、老抽、葱姜、八角、桂皮、香叶","detailurl":"http://m.xiachufang.com/recipe/100422974/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/9d7c70647d3911e59571b82a72e00100.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"排骨、姜片、蒜、五香粉、老抽、大料、八角、香叶、盐、糖、热水","detailurl":"http://m.xiachufang.com/recipe/215200/"},{"name":"红烧排骨","icon":"http://s2.cdn.xiachufang.com/21e2e7a67c9611e5823d35a81ec6fb03.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg","info":"肋排、香菇、油、糖、葱姜、老抽、生抽、盐、八角","detailurl":"http://m.xiachufang.com/recipe/35610/"}]
     */

    private int code;
    private String text;
    /**
     * name : 红烧排骨
     * icon : http://s2.cdn.xiachufang.com/e09f48787d4411e59d1013a10792eddb.jpg?imageView2/1/w/280/h/216/interlace/1/q/90/format/jpg/.jpg
     * info : 排骨、葱、姜、蒜、盐、生抽、老抽、料酒、白糖、鸡精
     * detailurl : http://m.xiachufang.com/recipe/268353/
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
        private String name;
        private String icon;
        private String info;
        private String detailurl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getDetailurl() {
            return detailurl;
        }

        public void setDetailurl(String detailurl) {
            this.detailurl = detailurl;
        }
    }
}
