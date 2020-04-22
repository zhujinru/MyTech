package com.wd.tech.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.stx.xhb.androidx.XBanner;
import com.wd.tech.R;
import com.wd.tech.adpter.ConsultAdpter;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.BannerBean;
import com.wd.tech.bean.ConsultShowBean;
import com.wd.tech.contract.TechContract;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.NetUtil;
import com.wd.tech.view.activity.MainActivity;
import com.wd.tech.widget.MyUrls;


import java.io.Reader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 咨询
 */
public class ConsultFragment extends BaseFragment<TechPresenter> implements TechContract.IView {

    List<ConsultShowBean.ResultBean>list=new ArrayList<>();
    @BindView(R.id.consult_fenlei)
    ImageView consultFenlei;
    @BindView(R.id.consult_sousuo)
    ImageView consultSousuo;
    @BindView(R.id.consult_banner)
    XBanner xb;
    @BindView(R.id.cunsult_recyecyclerView)
    RecyclerView recyles;


    @Override
    protected void initView(View view) {

    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_consult;
    }

    @Override
    protected void initData() {
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("plateId",1);
        maps.put("page",1);
        maps.put("count",10);
    mPresenter.getDoParams(MyUrls.BASE_CONSULTSHOW,ConsultShowBean.class,maps);
    }

    @Override
    protected void DestroyFragment() {

    }

    @Override
    public void onSuccess(Object o) {
    //Xbanner
        if (o instanceof BannerBean) {
            final List<BannerBean.ResultBean> result = ((BannerBean) o).getResult();
            xb.setBannerData(result);
            xb.setAutoPlayAble(true);
            xb.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    String imageUrl = result.get(position).getImageUrl();
                    NetUtil.getInstance().getPhoto(imageUrl, (ImageView) view);
                }
            });
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyles.setLayoutManager(linearLayoutManager);
        ConsultAdpter adpter=new ConsultAdpter(list,getActivity());
        recyles.setAdapter(adpter);
    }



    @Override
    public void onFailure(Throwable e) {


    }

    @OnClick({R.id.consult_fenlei, R.id.consult_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.consult_fenlei:
                break;
            case R.id.consult_sousuo:
                break;
        }
    }


}
