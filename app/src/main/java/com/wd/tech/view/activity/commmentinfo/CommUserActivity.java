package com.wd.tech.view.activity.commmentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.CommUserBean;
import com.wd.tech.bean.CommunityZanBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.NetUtil;
import com.wd.tech.view.adapter.communityadapter.CommUserAdapter;
import com.wd.tech.widget.MyUrls;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommUserActivity extends BaseActivity<TechPresenter> {

    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.desion)
    TextView desion;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.rc)
    RecyclerView rc;
    private int uid;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        rc.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        if (intent != null) {
            uid = intent.getIntExtra("uid", -1);
            HashMap<String, Object> map = new HashMap<>();
            map.put("fromUid", uid);
            map.put("page", 1);
            map.put("count", 10);
            mPresenter.getDoParams(MyUrls.BASE_USER_COM, CommUserBean.class, map);
        }
    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_comm_user;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof CommUserBean && TextUtils.equals("0000", ((CommUserBean) o).getStatus())) {
            List<CommUserBean.ResultBean> result = ((CommUserBean) o).getResult();
            CommUserBean.ResultBean.CommunityUserVoBean communityUserVo = result.get(0).getCommunityUserVo();
            String headPic = communityUserVo.getHeadPic();
            Glide.with(ivTitle).load(headPic).into(ivTitle);
            NetUtil.getInstance().getCiclePhoto(headPic, ivHead);
            name.setText(communityUserVo.getNickName());
            desion.setText(communityUserVo.getSignature());
            CommUserAdapter adapter = new CommUserAdapter(result.get(0).getCommunityUserPostVoList());
            adapter.setOnClickListener(new CommUserAdapter.OnClickListener() {
                @Override
                public void onClick(int tag, int tion) {
                    switch (tag) {
                        case 0:
                            CommUserBean.ResultBean.CommunityUserPostVoListBean listBena = result.get(0).getCommunityUserPostVoList().get(tion);
                            String file = listBena.getFile();

                            break;
                        case 1:
                            //点赞
                            CommUserBean.ResultBean.CommunityUserPostVoListBean resultBean1 = result.get(0).getCommunityUserPostVoList().get(tion);
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("communityId", resultBean1.getId());
                            if (resultBean1.getWhetherGreat() == 1) {
                                mPresenter.dltDoParams(MyUrls.BASE_DELETE_ZAN, CommunityZanBean.class, map);
                            } else {
                                mPresenter.postDoParams(MyUrls.BASE_COMMUNITY_ZAN, CommunityZanBean.class, map);
                            }
                            break;
                        case 2:
                            CommUserBean.ResultBean.CommunityUserPostVoListBean resultBean = result.get(0).getCommunityUserPostVoList().get(tion);
                            CommUserBean.ResultBean.CommunityUserVoBean userVo = result.get(0).getCommunityUserVo();
                            String headPic = userVo.getHeadPic();
                            String nickName = userVo.getNickName();
                            int id = resultBean.getId();
                            Intent intent = new Intent(CommUserActivity.this, WriteFilmActivity.class);
                            intent.putExtra("head", headPic);
                            intent.putExtra("name", nickName);
                            intent.putExtra("id", id);
                            startActivity(intent);
                            break;
                    }
                }
            });
            rc.setAdapter(adapter);
        }
        //点赞取消赞
        if (o instanceof CommunityZanBean && TextUtils.equals("0000", ((CommunityZanBean) o).getStatus())) {
            Toast.makeText(CommUserActivity.this, ((CommunityZanBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            HashMap<String, Object> map = new HashMap<>();
            map.put("fromUid", uid);
            map.put("page", 1);
            map.put("count", 10);
            mPresenter.getDoParams(MyUrls.BASE_USER_COM, CommUserBean.class, map);
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
    @OnClick({R.id.iv_head, R.id.more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                break;
            case R.id.more:
                break;
        }
    }
}
