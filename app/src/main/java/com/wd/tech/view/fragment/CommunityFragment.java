package com.wd.tech.view.fragment;

import android.text.TextUtils;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.CommunityBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.view.adapter.communityadapter.CommunityAdapter;
import com.wd.tech.view.adapter.messageadapter.MessageAdapter;
import com.wd.tech.widget.MyUrls;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 社区
 */
public class CommunityFragment extends BaseFragment<TechPresenter> {

    @BindView(R.id.community_recy)
    RecyclerView communityRecy;
    int page = 1;
    int count = 5;
    @Override
    protected void initView(View view) {

    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_community;
    }

    @Override
    protected void initData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("count", count);
        mPresenter.getDoParams(MyUrls.COMMUNITYLIST, CommunityBean.class, map);
    }

    @Override
    protected void DestroyFragment() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof CommunityBean && TextUtils.equals("0000", ((CommunityBean) o).getStatus())) {
            List<CommunityBean.ResultBean> result = ((CommunityBean) o).getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            communityRecy.setLayoutManager(linearLayoutManager);
            CommunityAdapter communityAdapter = new CommunityAdapter(result);
            communityRecy.setAdapter(communityAdapter);
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
