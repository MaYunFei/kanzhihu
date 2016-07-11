package com.yunfei.kanzhihu.bean;

import java.util.List;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswers {

    /**
     * error :
     * count : 32
     * answers : [{"title":"如何让腿变直？","time":"2016-07-07 21:27:11","summary":"7月10日补充答完就去忙了，也没怎么回来看，结果今天打开看到超一千赞吓哭了\u2026\u2026小透明万分感动！私信我的朋友，很抱歉我真的不是什么专业人士，也提供不了更多的意见了，但是只能告诉大家，变化是真的可能的～只要掌握科学的方法，对症下药，建议有条件的\u2026","questionid":"20827005","answerid":"109904175","authorname":"luo simona","authorhash":"e3a73b22667db7621acfde27a08f0385","avatar":"https://pic1.zhimg.com/fa6665848_l.jpg","vote":"1404"}]
     */

    private String error;
    private int count;
    /**
     * title : 如何让腿变直？
     * time : 2016-07-07 21:27:11
     * summary : 7月10日补充答完就去忙了，也没怎么回来看，结果今天打开看到超一千赞吓哭了……小透明万分感动！私信我的朋友，很抱歉我真的不是什么专业人士，也提供不了更多的意见了，但是只能告诉大家，变化是真的可能的～只要掌握科学的方法，对症下药，建议有条件的…
     * questionid : 20827005
     * answerid : 109904175
     * authorname : luo simona
     * authorhash : e3a73b22667db7621acfde27a08f0385
     * avatar : https://pic1.zhimg.com/fa6665848_l.jpg
     * vote : 1404
     */

    private List<AnswersEntity> answers;

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

    public List<AnswersEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersEntity> answers) {
        this.answers = answers;
    }

    public static class AnswersEntity {
        private String title;
        private String time;
        private String summary;
        private String questionid;
        private String answerid;
        private String authorname;
        private String authorhash;
        private String avatar;
        private String vote;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getQuestionid() {
            return questionid;
        }

        public void setQuestionid(String questionid) {
            this.questionid = questionid;
        }

        public String getAnswerid() {
            return answerid;
        }

        public void setAnswerid(String answerid) {
            this.answerid = answerid;
        }

        public String getAuthorname() {
            return authorname;
        }

        public void setAuthorname(String authorname) {
            this.authorname = authorname;
        }

        public String getAuthorhash() {
            return authorhash;
        }

        public void setAuthorhash(String authorhash) {
            this.authorhash = authorhash;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getVote() {
            return vote;
        }

        public void setVote(String vote) {
            this.vote = vote;
        }
    }
}
