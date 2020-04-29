package com.wd.tech.view.adapter.communityadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.bean.CommunityBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ComPlItemAdapter extends RecyclerView.Adapter<ComPlItemAdapter.MyViewHolder> {

    private List<CommunityBean.ResultBean.CommunityCommentVoListBean> list=new ArrayList<>();

    public ComPlItemAdapter(List<CommunityBean.ResultBean.CommunityCommentVoListBean> voList) {
        if (voList.size()>0&&voList.size()<4){
            list=voList;
        }else {
            for (int i = 0; i < 3; i++) {
                list.add(voList.get(i));
            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.compl_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CommunityBean.ResultBean.CommunityCommentVoListBean communityCommentVoListBean = list.get(position);
        holder.name.setText(communityCommentVoListBean.getNickName());
        holder.content.setText(communityCommentVoListBean.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.content)
        TextView content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
