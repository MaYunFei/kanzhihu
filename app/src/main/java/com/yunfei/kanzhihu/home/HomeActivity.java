package com.yunfei.kanzhihu.home;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yunfei.base.BaseApp;
import com.yunfei.base.BaseRecyclerAdapter;
import com.yunfei.kanzhihu.R;
import com.yunfei.kanzhihu.bean.Posts;
import com.yunfei.kanzhihu.web.WebActivity;
import com.yunfei.mvp.BaseLoadingActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yunfei on 16/7/4.
 */
public class HomeActivity extends BaseLoadingActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private HomewAdapter mAdapter;


    @Override
    protected int getLayout() {
        return R.layout.home_act;
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void initEventAndData() {
        setSupportActionBar(mToolbar);
        mPresenter.subscribe();
        mAdapter = new HomewAdapter();
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);

        //首页初始化 BaseApp参数
        if (BaseApp.getInstance().getScreenHeight() == 0) {
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            BaseApp.getInstance().setScreenWidth(dm.widthPixels);
            BaseApp.getInstance().setScreenHeight(dm.heightPixels);
        }

        mAdapter.setOnItemClickListener((postsEntity, position) -> {
//            PostAnswersActivity.startActivity(mContext, TimeUtil.getDateParm(postsEntity.getDate()), postsEntity.getName());
                    Intent intent = new Intent(this, WebActivity.class);
            startActivity(intent);
        }
        );

    }


    @Override
    public void loadData(List<Posts.PostsEntity> data) {
        mAdapter.addAll(data);

    }


    public static class HomewAdapter extends BaseRecyclerAdapter<Posts.PostsEntity, HomewAdapter.HomeViewHolder> {


        private OnItemClickListener<Posts.PostsEntity> onItemClickListener;

        private String parseName(String name) {
            if (name.equals("yesterday")) {
                return "昨日最新";
            } else if (name.equals("recent")) {
                return "近日热门";
            } else if (name.equals("archive")) {
                return "历史精华";
            } else {
                return "";
            }
        }


        @Override
        protected void onBindItemViewHolder(HomeViewHolder holder, Posts.PostsEntity postsEntity, int position) {
            Picasso.with(holder.mPic.getContext()).load(postsEntity.getPic()).into(holder.mPic);
//            holder.mExcerpt.setText(postsEntity.getExcerpt());
            holder.mName.setText(parseName(postsEntity.getName()));
            holder.mContent.setOnClickListener(v -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(postsEntity, position);
                }
            });
        }

        @Override
        protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);
            return new HomeViewHolder(view);
        }

        public OnItemClickListener<Posts.PostsEntity> getOnItemClickListener() {
            return onItemClickListener;
        }

        public void setOnItemClickListener(OnItemClickListener<Posts.PostsEntity> onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public class HomeViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_name)
            TextView mName;
            @BindView(R.id.iv_pic)
            ImageView mPic;
            @BindView(R.id.tv_excerpt)
            TextView mExcerpt;

            View mContent;

            public HomeViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContent = itemView;
            }
        }


    }


}
