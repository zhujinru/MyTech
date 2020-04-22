package com.wd.tech.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.tech.R;
import com.wd.tech.bean.ConsultShowBean;
import com.wd.tech.util.NetUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
/**
*
* @ProjectName: MyTech
* @Package: com.wd.tech.adpter
* @ClassName: ConsultAdpter
* @Author: 刘文
* @CreateDate: 2020/4/21 下午8:00
* @UpdateUser: 更新者
* @UpdateDate: 2020/4/21 下午8:00
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
public class ConsultAdpter extends RecyclerView.Adapter<ConsultAdpter.ViewHolder> {
    List<ConsultShowBean.ResultBean> list;
    Context context;

    public ConsultAdpter(List<ConsultShowBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.consult_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.consultItemName.setText(list.get(position).getSource());
        holder.consultItemNeirong.setText(list.get(position).getSummary());
        holder.consultItemTime.setText(list.get(position).getReleaseTime()+"");

        NetUtil.getInstance().getCiclePhoto(list.get(position).getThumbnail(),holder.consultItemImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.consult_item_image)
        ImageView consultItemImage;
        @BindView(R.id.consult_item_name)
        TextView consultItemName;
        @BindView(R.id.consult_item_neirong)
        TextView consultItemNeirong;
        @BindView(R.id.consult_item_time)
        TextView consultItemTime;
        @BindView(R.id.consult_hongxin_image)
        ImageView consultHongxinImage;
        @BindView(R.id.consult_share_image)
        ImageView consultShareImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
