package com.wd.tech.view.fragment.infofragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.FriendNoticeBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.view.adapter.MessageAdapter;
import com.wd.tech.widget.MyUrls;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 消息页面的消息
 */
public class MessageFragment extends BaseFragment<TechPresenter> {

    int page = 1;
    int count = 5;
    @BindView(R.id.message_recy)
    RecyclerView messageRecy;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("count", count);
        mPresenter.getDoParams(MyUrls.Friend_Notice, FriendNoticeBean.class, map);
    }

    @Override
    protected void DestroyFragment() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof FriendNoticeBean && TextUtils.equals("0000", ((FriendNoticeBean) o).getStatus())) {
            List<FriendNoticeBean.ResultBean> result = ((FriendNoticeBean) o).getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            messageRecy.setLayoutManager(linearLayoutManager);
            MessageAdapter messageAdapter = new MessageAdapter(result);
            messageRecy.setAdapter(messageAdapter);
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
