package com.yunfei.kanzhihu.home;

import com.yunfei.kanzhihu.bean.Posts;
import com.yunfei.mvp.ILoadingView;
import com.yunfei.mvp.IPresenter;

import java.util.List;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeContract {
    public interface View extends ILoadingView {

        void loadData(List<Posts.PostsEntity> data);

    }

    public interface Presenter extends IPresenter {

    }
}
