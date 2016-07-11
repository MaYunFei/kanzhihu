package com.yunfei.kanzhihu.post_answers;

import com.yunfei.kanzhihu.bean.PostAnswers;
import com.yunfei.net.RetrofitUtil;

import rx.Observable;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswersModel extends RetrofitUtil {

    public Observable<PostAnswers> getPostAnswers(String time, String name) {
        return getApi().getPostAnswers(time, name)
                .compose(applySchedulers());
    }
}
