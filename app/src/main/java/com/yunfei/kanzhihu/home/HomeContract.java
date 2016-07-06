package com.yunfei.kanzhihu.home;

import com.yunfei.mvp.IBasePresenter;
import com.yunfei.mvp.IBaseView;
import com.yunfei.mvp.ILoading;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeContract {
    public interface View extends ILoading, IBaseView<Presenter> {

    }

    public interface Presenter extends IBasePresenter {

    }
}
