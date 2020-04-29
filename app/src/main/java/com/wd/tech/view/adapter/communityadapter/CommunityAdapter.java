package com.wd.tech.view.adapter.communityadapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.tech.R;
import com.wd.tech.bean.CommunityBean;
import com.wd.tech.util.NetUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2020/4/21
 * author:朱金茹(Lenovo)
 * function:社区列表适配器
 */
public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.MyViewHolder> {

    private List<CommunityBean.ResultBean> result;

    public CommunityAdapter(List<CommunityBean.ResultBean> result) {

        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_item_child, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CommunityBean.ResultBean resultBean = result.get(position);
        String file = resultBean.getFile();
        if (file != null && !file.equals("")) {
            holder.imLl.setVisibility(View.VISIBLE);
            NetUtil.getInstance().getPhoto(file, holder.file);
        } else {
            holder.imLl.setVisibility(View.GONE);
        }
        holder.comItemName.setText(resultBean.getNickName());
        holder.comItemNickname.setText(resultBean.getSignature());
        NetUtil.getInstance().getCiclePhoto(resultBean.getHeadPic(), holder.comItemImage);
        //查询用户帖子列表
        holder.comItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(3,resultBean.getUserId());
                }
            }
        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM:dd HH:mm");
        String format = simpleDateFormat.format(resultBean.getPublishTime());
        holder.comItemTime.setText(format);
        holder.comItemMessage.setText(resultBean.getContent());
        holder.comItemPlNum.setText(resultBean.getComment() + "");
        int whetherGreat = resultBean.getWhetherGreat();
        if (whetherGreat==1){
            holder.comItemZan.setImageResource(R.drawable.common_icon_praise_s_hdpi);
        }else {
            holder.comItemZan.setImageResource(R.drawable.common_icon_prise_n_hdpi);
        }
        holder.comItemZanNum.setText(resultBean.getPraise() + "");
        //评论
        List<CommunityBean.ResultBean.CommunityCommentVoListBean> voList = resultBean.getCommunityCommentVoList();
        if (voList.size()>0){
            holder.plRc.setVisibility(View.VISIBLE);
            holder.plRc.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.plRc.setAdapter(new ComPlItemAdapter(voList));
        }else {
            holder.plRc.setVisibility(View.GONE);
        }
        if (voList.size()>=3){
            holder.plNull.setText("点击查看更多评论");
            holder.plNull.setTextColor(Color.BLUE);
        }else {
            holder.plNull.setText("没有更多评论了~");
        }
        //点赞/取消赞
        holder.comItemZan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(1,position);
                }
            }
        });
        //查看写评论
        holder.comItemPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(0,resultBean.getId());
                }
            }
        });
        //点击查看更多评论
        holder.plNull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.plNull.getText().toString().trim().equals("点击查看更多评论")){
                    if (onClickListener != null) {
                        onClickListener.onClick(2,position);
                    }
                }else {
                    return;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.com_item_image)
        ImageView comItemImage;
        @BindView(R.id.com_item_name)
        TextView comItemName;
        @BindView(R.id.com_item_nickname)
        TextView comItemNickname;
        @BindView(R.id.com_item_time)
        TextView comItemTime;
        @BindView(R.id.com_item_message)
        TextView comItemMessage;
        @BindView(R.id.file)
        ImageView file;
        @BindView(R.id.im_ll)
        LinearLayout imLl;
        @BindView(R.id.com_item_pl)
        ImageView comItemPl;
        @BindView(R.id.com_item_pl_num)
        TextView comItemPlNum;
        @BindView(R.id.com_item_zan)
        ImageView comItemZan;
        @BindView(R.id.com_item_zan_num)
        TextView comItemZanNum;
        @BindView(R.id.pl_rc)
        RecyclerView plRc;
        @BindView(R.id.pl_null)
        TextView plNull;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int tag, int position);
    }
}
