package com.yunfei.kanzhihu.post_answers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunfei.base.BaseRecyclerAdapter;
import com.yunfei.kanzhihu.R;
import com.yunfei.kanzhihu.bean.PostAnswers;
import com.yunfei.kanzhihu.web.WebActivity;
import com.yunfei.mvp.BaseLoadingActivity;
import com.yunfei.utils.ZhiHuIntent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

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
    private PostAnswersAdapter mAdapter;

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

        mAdapter = new PostAnswersAdapter();
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void loadData(List<PostAnswers.AnswersEntity> data) {
        mAdapter.addAll(data);
    }


    public class PostAnswersAdapter extends BaseRecyclerAdapter<PostAnswers.AnswersEntity, PostAnswersAdapter.PostAnswersHolder> {

        @Override
        protected void onBindItemViewHolder(PostAnswersHolder holder, PostAnswers.AnswersEntity answersEntity, int position) {
            holder.mTvQuestion.setText(answersEntity.getTitle());
//            holder.mTvQuestion.setOnClickListener(v2 -> WebActivity.startActivity(holder.mTvQuestion.getContext(), "https://www.zhihu.com/question/" + answersEntity.getQuestionid()));
            holder.mTvQuestion.setOnClickListener(v ->
                    ZhiHuIntent.starZhiHuQuestionActivity(holder.mTvQuestion.getContext(), answersEntity.getQuestionid())
            );
            Picasso.with(holder.mIvAvatar.getContext()).load(answersEntity.getAvatar()).transform(new CropCircleTransformation()).into(holder.mIvAvatar);
            holder.mTvAnswer.setText(answersEntity.getSummary());
//            holder.mTvAnswer.setOnClickListener(v1 -> WebActivity.startActivity(holder.mTvAnswer.getContext(), "https://www.zhihu.com/question/" + answersEntity.getQuestionid() + "/answer/" + answersEntity.getAnswerid()));
            holder.mTvAnswer.setOnClickListener(v1 -> WebActivity.startActivity(holder.mTvAnswer.getContext(), "http://www.kanzhihu.com/"));
//            holder.mTvAnswer.setOnClickListener(v ->
//                    ZhiHuIntent.starZhiHuAnswernActivity(holder.mTvAnswer.getContext(), answersEntity.getQuestionid(), answersEntity.getAnswerid())
//            );

            holder.mTvAuthorname.setText(answersEntity.getAuthorname());
//            holder.mGroupUser.setOnClickListener(v -> WebActivity.startActivity(holder.mGroupUser.getContext(), "https://www.zhihu.com/people/" + answersEntity.getAuthorhash()));
        }

        @Override
        protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_answers_list_item, parent, false);
            return new PostAnswersHolder(view);
        }


        public class PostAnswersHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_question)
            TextView mTvQuestion;
            @BindView(R.id.iv_avatar)
            ImageView mIvAvatar;
            @BindView(R.id.tv_answer)
            TextView mTvAnswer;
            @BindView(R.id.tv_authorname)
            TextView mTvAuthorname;
            @BindView(R.id.group_user)
            View mGroupUser;


            public PostAnswersHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }

}
