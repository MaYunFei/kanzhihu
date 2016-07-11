package com.yunfei.kanzhihu.post_answers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.yunfei.base.BaseRecyclerAdapter;
import com.yunfei.kanzhihu.R;
import com.yunfei.kanzhihu.bean.PostAnswers;
import com.yunfei.kanzhihu.bean.Posts;
import com.yunfei.mvp.BaseLoadingActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by yunfei on 16/7/10.
 */
public class PostAnswersActivity extends BaseLoadingActivity<PostAnswersPresenter> implements PostAnswersContract.View {

    private static final String EXTRA_TIME = "extra_time";
    private static final String EXTRA_NAME = "extra_name";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static void startActivity(Context context, String time, String name) {
        Intent intent = new Intent(context, PostAnswersActivity.class);
        intent.putExtra(EXTRA_TIME, time);
        intent.putExtra(EXTRA_NAME, name);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.post_answers_act;
    }

    @Override
    protected PostAnswersPresenter getPresenter() {
        return new PostAnswersPresenter(this);
    }

    @Override
    protected void initEventAndData() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());

        String time = getIntent().getStringExtra(EXTRA_TIME);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        if (TextUtils.isEmpty(time) || TextUtils.isEmpty(name)) {
            finish();
            return;
        }
        mPresenter.getPostAnswers(time, name);

    }

    @Override
    public void loadData(List<Posts.PostsEntity> data) {
    }


    private class PostAnswersAdapter extends BaseRecyclerAdapter<PostAnswers.AnswersEntity, PostAnswersAdapter.PostAnswersHolder> {

        @Override
        protected void onBindItemViewHolder(PostAnswersHolder holder, PostAnswers.AnswersEntity answersEntity, int position) {

        }

        @Override
        protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
            return null;
        }


        public class PostAnswersHolder extends RecyclerView.ViewHolder {

            public PostAnswersHolder(View itemView) {
                super(itemView);
            }
        }
    }

}
