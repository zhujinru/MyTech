package com.wd.tech.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.stx.xhb.androidx.XBanner;
import com.wd.tech.R;
import com.wd.tech.base.BaseFragment;
import com.wd.tech.bean.BannerBean;
import com.wd.tech.bean.ConsultShowBean;
import com.wd.tech.contract.TechContract;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.NetUtil;
import com.wd.tech.view.activity.ConsultDetailsinfo.ConsultDetailsActivity;
import com.wd.tech.view.activity.ConsultDetailsinfo.FindPlateActivity;
import com.wd.tech.view.activity.Consult_Sousuo;

import com.wd.tech.view.activity.ConsultDetailsinfo.ConsultDetailsActivity;
import com.wd.tech.view.activity.ConsultDetailsinfo.FindPlateActivity;
import com.wd.tech.view.adapter.consultadpter.ConsultAdpter;
import com.wd.tech.widget.MyUrls;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 咨询
 */
public class ConsultFragment extends BaseFragment<TechPresenter> implements TechContract.IView {

    List<ConsultShowBean.ResultBean> list = new ArrayList<>();
    List<String>bannerlist=new ArrayList<>();
    List<String> bannerlist=new ArrayList<>();
    @BindView(R.id.consult_fenlei)
    ImageView consultFenlei;
    @BindView(R.id.consult_sousuo)
    ImageView consultSousuo;
    @BindView(R.id.consult_banner)
    Banner xb;
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
        maps.put("plateId", 1);
        maps.put("page", 1);
        maps.put("count", 10);
        mPresenter.getDoParams(MyUrls.BASE_CONSULTSHOW, ConsultShowBean.class, maps);
    }

    @Override
    protected void DestroyFragment() {

    }

    @Override
    public void onSuccess(Object o) {
        //Xbanner
        if (o instanceof BannerBean) {
            final List<BannerBean.ResultBean> result = ((BannerBean) o).getResult();
            for (int i = 0; i < result.size(); i++) {
                bannerlist.add(result.get(i).getImageUrl());
            }
            xb.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(getActivity()).load(path).into(imageView);
                }
            }).setDelayTime(2000).setImages(bannerlist).start();

        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyles.setLayoutManager(linearLayoutManager);
        ConsultAdpter adpter=new ConsultAdpter(list,getActivity());
        adpter.setOnClickListeners(new ConsultAdpter.OnClickListeners() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), ConsultDetailsActivity.class);
                intent.putExtra("id",movieId);
                startActivity(intent);
            }
        });
        recyles.setAdapter(adpter);
        adpter.setOnClickListeners(new ConsultAdpter.OnClickListeners() {
            @Override
            public void onClick(int movieId) {
                Intent intent = new Intent(getActivity(), ConsultDetailsActivity.class);
                intent.putExtra("id",movieId);
                startActivity(intent);
            }
        });
        recyles.setAdapter(adpter);
        if (o instanceof ConsultShowBean) {
            list.clear();
            list.addAll(((ConsultShowBean) o).getResult());
        }
    }


    @Override
    public void onFailure(Throwable e) {


    }

    @OnClick({R.id.consult_fenlei, R.id.consult_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.consult_fenlei:
                Intent intent1 = new Intent(getActivity(), FindPlateActivity.class);
                startActivity(intent1);
                Toast.makeText(getContext(), "ceshi", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), FindPlateActivity.class);
                startActivity(intent);
                break;
            case R.id.consult_sousuo:
                Intent intent = new Intent(getActivity(), Consult_Sousuo.class);
                startActivity(intent);
                break;
        }
    }


}
