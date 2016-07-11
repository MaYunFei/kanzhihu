package com.yunfei.kanzhihu.post_answers;

import com.yunfei.kanzhihu.bean.Posts;
import com.yunfei.mvp.ILoadingView;
import com.yunfei.mvp.IPresenter;

import java.util.List;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswersContract {
    public interface View extends ILoadingView {

        void loadData(List<Posts.PostsEntity> data);

    }

    public interface Presenter extends IPresenter {

    }
}
