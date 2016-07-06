package com.yunfei.kanzhihu.bean;

import com.yunfei.net.Response;

import java.util.List;

/**
 * Created by yunfei on 16/7/5.
 */
public class Getposts extends Response {

    /**
     * error :
     * count : 10
     * posts : [{"id":"275","date":"2014-09-21","name":"yesterday","pic":"http://www.kzhihu.com/wp-content/uploads/2014/09/wpid-yesterday-2014-09-21.jpg","publishtime":"1411246800","count":"33","excerpt":"摘录了『1949 年建国时，中共领导下的中国面临的形势到底有多艰难？』、『你曾经有哪些事用了简单粗暴的方法却极其成功？』、『该如何客观理性地面对「日本软银是阿里巴巴最大的股东」这一事实？』、『哪些事情让你一瞬间对中国教育很失望？』、『中国从苏格兰独立公投的过程和结果中能得到什么启示？』、『「性工作者」应该被歧视么？』、『富二代努力的意义是什么？』、『女孩如何培养穿着打扮的品味？成年后，如何继续提升？』等问题下的33个答案"}]
     */

    private int count;
    /**
     * id : 275
     * date : 2014-09-21
     * name : yesterday
     * pic : http://www.kzhihu.com/wp-content/uploads/2014/09/wpid-yesterday-2014-09-21.jpg
     * publishtime : 1411246800
     * count : 33
     * excerpt : 摘录了『1949 年建国时，中共领导下的中国面临的形势到底有多艰难？』、『你曾经有哪些事用了简单粗暴的方法却极其成功？』、『该如何客观理性地面对「日本软银是阿里巴巴最大的股东」这一事实？』、『哪些事情让你一瞬间对中国教育很失望？』、『中国从苏格兰独立公投的过程和结果中能得到什么启示？』、『「性工作者」应该被歧视么？』、『富二代努力的意义是什么？』、『女孩如何培养穿着打扮的品味？成年后，如何继续提升？』等问题下的33个答案
     */

    private List<PostsEntity> posts;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PostsEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsEntity> posts) {
        this.posts = posts;
    }

    public static class PostsEntity {
        private String id;
        private String date;
        private String name;
        private String pic;
        private String publishtime;
        private String count;
        private String excerpt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }
    }
}
