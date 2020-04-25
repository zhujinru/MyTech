package com.wd.tech.view.activity;

import android.os.Bundle;

import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.Consult_fenleiBean;
import com.wd.tech.contract.TechContract;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.widget.MyUrls;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class classification_Activity extends BaseActivity<TechPresenter> implements TechContract.IView {

    @BindView(R.id.consult_ry)
    RecyclerView recycleview;

    @Override
    protected void initData() {
    mPresenter.getNoParams(MyUrls.CLASSIFICATION, Consult_fenleiBean.class);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_classification;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {
        GridLayoutManager manager=new GridLayoutManager(this,2);
        recycleview.setLayoutManager(manager);

    }

    @Override
    public void onFailure(Throwable e) {

    }


}
