package com.yunfei.kanzhihu.post_answers;

import com.yunfei.kanzhihu.bean.PostAnswers;
import com.yunfei.mvp.ILoadingView;
import com.yunfei.mvp.IPresenter;

import java.util.List;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswersContract {
    public interface View extends ILoadingView {

        void loadData(List<PostAnswers.AnswersEntity> data);

    }

    public interface Presenter extends IPresenter {

    }
}
