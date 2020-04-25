package com.wd.tech.view.adapter.communityadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        holder.comItemName.setText(resultBean.getNickName());
        holder.comItemNickname.setText(resultBean.getSignature());
        NetUtil.getInstance().getCiclePhoto(resultBean.getHeadPic(), holder.comItemImage);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM:dd HH:mm");
        String format = simpleDateFormat.format(resultBean.getPublishTime());
        holder.comItemTime.setText(format);
        holder.comItemMessage.setText(resultBean.getContent());
        holder.comItemPlNum.setText(resultBean.getComment()+"");
        holder.comItemZanNum.setText(resultBean.getPraise()+"");
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
        @BindView(R.id.com_item_pl)
        ImageView comItemPl;
        @BindView(R.id.com_item_pl_num)
        TextView comItemPlNum;
        @BindView(R.id.com_item_zan)
        ImageView comItemZan;
        @BindView(R.id.com_item_zan_num)
        TextView comItemZanNum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
