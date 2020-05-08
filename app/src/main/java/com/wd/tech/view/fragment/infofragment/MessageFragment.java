package com.wd.tech.view.fragment.infofragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.FriendNoticeBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.view.activity.Message.ChatMsgActivity;
import com.wd.tech.view.adapter.messageadapter.message.MessageAdapter;
import com.wd.tech.widget.MyUrls;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

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
    SwipeMenuRecyclerView messageRecy;
    private MessageAdapter messageAdapter;

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
            messageAdapter = new MessageAdapter(result);
            messageRecy.setSwipeMenuCreator(new SwipeMenuCreator() {
                @Override
                public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {

                    @SuppressLint("ResourceType") SwipeMenuItem deleteItem = new SwipeMenuItem(getContext())
                            .setBackground(R.drawable.redcolor)
                            .setText("删除")
                            .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)//设置高，这里使用match_parent，就是与item的高相同
                            .setWidth(70);//设置宽
                    swipeRightMenu.addMenuItem(deleteItem);//设置右边的侧滑
                }
            });
            messageRecy.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
                @Override
                public void onItemClick(SwipeMenuBridge menuBridge) {
                    menuBridge.closeMenu();
                    int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                    result.remove(adapterPosition);
                    messageAdapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "删除成功", Toast.LENGTH_SHORT).show();
                }
            });
            messageRecy.setAdapter(messageAdapter);
            //消息点击跳转到聊天页面
            messageAdapter.setOnMessageItemClickListener(new MessageAdapter.OnMessageItemClickListener() {
                @Override
                public void onMessageItemClick(int id, String head, String name) {
                    Intent intent = new Intent(getContext(), ChatMsgActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("head",head);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onFailure(Throwable e) {

    }
}
