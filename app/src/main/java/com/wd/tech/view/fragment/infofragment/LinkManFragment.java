package com.wd.tech.view.fragment.infofragment;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.FriendGroupBean;
import com.wd.tech.bean.FriendListBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.view.activity.Message.ChatMsgActivity;
import com.wd.tech.view.adapter.messageadapter.linkman.FriendGroupAdapter;
import com.wd.tech.widget.MyUrls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkManFragment extends BaseFragment<TechPresenter> {

    @BindView(R.id.query)
    EditText query;
    @BindView(R.id.linkManRc)
    RecyclerView linkManRc;
    private FriendGroupAdapter friendGroupAdapter;
    private int position=-1;
    List<FriendGroupBean.ResultBean> group=new ArrayList<>();
    @Override
    protected void initView(View view) {
        //查询所有分组
        mPresenter.getNoParams(MyUrls.BASE_FIND_ALLGROUP, FriendGroupBean.class);
        linkManRc.setLayoutManager(new LinearLayoutManager(getContext()));
        //
        query.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String serach = query.getText().toString().trim();

            }
        });
    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_link_man;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void DestroyFragment() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof FriendGroupBean&& TextUtils.equals("0000",((FriendGroupBean) o).getStatus())){
            if (((FriendGroupBean) o).getResult().size()>0){
                group.clear();
                List<FriendGroupBean.ResultBean> result = ((FriendGroupBean) o).getResult();
                group.addAll(result);
                friendGroupAdapter = new FriendGroupAdapter(group);
                friendGroupAdapter.setOnClickListener(new FriendGroupAdapter.OnClickListener() {
                    @Override
                    public void onClick(int positon, int groupId) {
                        position=positon;
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("groupId",groupId);
                        //查询分组下所有好友
                        mPresenter.getDoParams(MyUrls.BASE_FINDMAN_BYGROUP, FriendListBean.class,map);
                    }
                });

                friendGroupAdapter.setOnFrindClickListener(new FriendGroupAdapter.onFrindClickListener() {
                    @Override
                    public void onFrindClick(int id, String head, String name) {
                        Intent intent = new Intent(getContext(), ChatMsgActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("head",head);
                        intent.putExtra("name",name);
                        startActivity(intent);
                    }
                });
                linkManRc.setAdapter(friendGroupAdapter);
            }
        }
        if (o instanceof FriendListBean&& TextUtils.equals("0000",((FriendListBean) o).getStatus())){
            if (((FriendListBean) o).getResult().size()>0){
                List<FriendListBean.ResultBean> result = ((FriendListBean) o).getResult();
                if (friendGroupAdapter != null) {
                    friendGroupAdapter.addAllChild(position,result);
                }
            }else {
                if (friendGroupAdapter != null) {
                    friendGroupAdapter.addAllChild(position,null);
                }
            }
            friendGroupAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
