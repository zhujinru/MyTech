package com.wd.tech.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.contract.TechContract;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.view.activity.classes.DestroyActivityUtil;

import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class My_Setup extends BaseActivity<TechPresenter> implements TechContract.IView {
    public static ArrayList<Activity> mActivityList = new ArrayList<Activity>();

    @BindView(R.id.image_pic)
    ImageView imagePic;
    @BindView(R.id.image_qianming)
    ImageView imageQianming;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_name_one)
    TextView textNameOne;
    @BindView(R.id.textsex)
    TextView textsex;
    @BindView(R.id.text_sex)
    TextView textSex;
    @BindView(R.id.text_qianming)
    TextView textQianming;
    @BindView(R.id.text_pic)
    TextView textPic;
    @BindView(R.id.cartview_one)
    CardView cartviewOne;
    @BindView(R.id.text_shengri)
    TextView textShengri;
    @BindView(R.id.text_shengri_one)
    TextView textShengriOne;
    @BindView(R.id.text_tell)
    TextView textTell;
    @BindView(R.id.text_tell_one)
    TextView textTellOne;
    @BindView(R.id.text_emall)
    TextView textEmall;
    @BindView(R.id.text_emall_one)
    TextView textEmallOne;
    @BindView(R.id.cartview_two)
    CardView cartviewTwo;
    @BindView(R.id.text_jifen)
    TextView textJifen;
    @BindView(R.id.text_jifen_one)
    TextView textJifenOne;
    @BindView(R.id.text_vip)
    TextView textVip;
    @BindView(R.id.text_vip_one)
    TextView textVipOne;
    @BindView(R.id.text_face)
    TextView textFace;
    @BindView(R.id.text_face_one)
    TextView textFaceOne;
    @BindView(R.id.outlogin)
    TextView outlogin;
    @BindView(R.id.cartview_three)
    CardView cartviewThree;

    @Override
    protected void initData() {
        String pic = getIntent().getStringExtra("pic");
        String name = getIntent().getStringExtra("name");
        textNameOne.setText(name);
        Glide.with(this)
                .load(pic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(imagePic);
        addActivity();
    }

    private void addActivity() {

    }

    public static int getSize(){
        return mActivityList.size();
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
        return R.layout.activity_my__setup;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailure(Throwable e) {

    }



    @OnClick({R.id.image_pic, R.id.image_qianming, R.id.text_name_one, R.id.text_sex, R.id.text_shengri_one, R.id.text_tell_one, R.id.text_emall_one, R.id.text_jifen_one, R.id.text_vip_one, R.id.text_face_one, R.id.outlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_pic:
                break;
            case R.id.image_qianming:
                break;
            case R.id.text_name_one:
                break;
            case R.id.text_sex:
                break;
            case R.id.text_shengri_one:
                break;
            case R.id.text_tell_one:
                break;
            case R.id.text_emall_one:
                break;
            case R.id.text_jifen_one:
                break;
            case R.id.text_vip_one:
                break;
            case R.id.text_face_one:
                break;
            case R.id.outlogin:
                Intent intent = new Intent(My_Setup.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);		//将DengLuActivity至于栈顶
                startActivity(intent);
                DestroyActivityUtil destroyActivityUtil = new DestroyActivityUtil();
                destroyActivityUtil.exit();
                break;
        }
    }


}
