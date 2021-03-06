package com.wd.tech.view.adapter.messageadapter.linkman;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.bean.FriendGroupBean;
import com.wd.tech.bean.FriendListBean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/23
 * author:朱金茹(Lenovo)
 * function:消息适配器
 */
public class FriendGroupAdapter extends RecyclerView.Adapter<FriendGroupAdapter.GroupViewHolder> {

    private List<FriendGroupBean.ResultBean> list=new ArrayList<>();
    List<FriendListBean.ResultBean> child=new ArrayList<>();
    public FriendGroupAdapter(List<FriendGroupBean.ResultBean> group) {
        list = group;
    }
    private int pos=-1;
    public void addAllChild(int position, List<FriendListBean.ResultBean> mchild) {
        child=mchild;
        pos=position;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(parent.getContext(), R.layout.friend_group, null);
        return new GroupViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        FriendGroupBean.ResultBean resultBean = list.get(position);
        int currentNumber = resultBean.getCurrentNumber();
        String groupName = resultBean.getGroupName();
        if (resultBean.isClosed()){
            holder.iv.setImageResource(R.drawable.xiajiantou);
            holder.rc.setVisibility(View.GONE);
        }else {
            if (currentNumber==0){
                holder.rc.setVisibility(View.GONE);
            }else {
                holder.rc.setVisibility(View.VISIBLE);
            }
            holder.iv.setImageResource(R.drawable.shangjiantou);

        }
        holder.name.setText(groupName);
        holder.num.setText("0/" + currentNumber);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child=null;
                boolean closed = resultBean.isClosed();
                closed = !closed;
                resultBean.setClosed(closed);
                    if (onClickListener != null) {
                        onClickListener.onClick(position, resultBean.getGroupId());
                }
            }
        });
        holder.rc.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        if (child!=null){
            FriendChildAdapter friendChildAdapter = new FriendChildAdapter(child);
            holder.rc.setAdapter(friendChildAdapter);
            friendChildAdapter.setOnClicksListener(new FriendChildAdapter.OnClicksListener() {
                @Override
                public void onClick(int id, String head, String name) {
                    if (onFrindClickListener != null) {
                        onFrindClickListener.onFrindClick(id,head,name);
                    }
                }
            });
        }

}

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GroupViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.rc)
        RecyclerView rc;
    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position, int groupId);
    }

    onFrindClickListener onFrindClickListener;

    public void setOnFrindClickListener(FriendGroupAdapter.onFrindClickListener onFrindClickListener) {
        this.onFrindClickListener = onFrindClickListener;
    }

    public interface onFrindClickListener{
        void onFrindClick(int id,String head,String name);
    }

}
