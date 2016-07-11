package com.yunfei.kanzhihu.post_answers;

import com.yunfei.kanzhihu.bean.PostAnswers;
import com.yunfei.mvp.BaseLoadingPresenter;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswersPresenter extends BaseLoadingPresenter<PostAnswersContract.View> implements PostAnswersContract.Presenter{
    private PostAnswersModel mModel;
    public PostAnswersPresenter(PostAnswersContract.View view) {
        super(view);
        mModel = new PostAnswersModel();
    }

    @Override
    public void subscribe() {

    }

    public void getPostAnswers(String time, String name) {
        mModel.getPostAnswers(time,name)
                .subscribe(new LoadingSubscriber<PostAnswers>() {
                    @Override
                    public void onNext(PostAnswers postAnswers) {

                    }
                });
    }
}
