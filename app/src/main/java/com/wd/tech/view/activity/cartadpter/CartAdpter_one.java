package com.wd.tech.view.activity.cartadpter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
/**
*
* @ProjectName: MyTech
* @Package: com.wd.tech.view.activity.cartadpter
* @ClassName: CartAdpter_one
* @Author: 刘文
* @CreateDate: 2020/4/28 下午4:20
* @UpdateUser: 更新者
* @UpdateDate: 2020/4/28 下午4:20
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
public class CartAdpter_one extends RecyclerView.Adapter<CartAdpter_one.ViewHolder> {
    @NonNull
    @Override
    public CartAdpter_one.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdpter_one.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
