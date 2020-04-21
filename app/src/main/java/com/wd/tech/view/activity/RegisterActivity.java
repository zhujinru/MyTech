package com.wd.tech.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.RegisterBean;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.RsaCoder;
import com.wd.tech.widget.MyUrls;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<TechPresenter> {

    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.sms_register)
    TextView smsRegister;
    @BindView(R.id.register_bt)
    Button registerBt;
    String PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof RegisterBean && TextUtils.equals("0000", ((RegisterBean) o).getStatus())) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }

    @OnClick(R.id.register_bt)
    public void onViewClicked() {
        String name = registerName.getText().toString().trim();
        String phone = registerPhone.getText().toString().trim();
        String pwd = registerPwd.getText().toString().trim();
        if (TextUtils.equals("", phone) && TextUtils.equals("", pwd)) {
            Toast.makeText(this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String s = null;
        try {
            s = RsaCoder.encryptByPublicKey(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean matches = Pattern.matches(PHONE, phone);
        if (matches){
            Log.i("xxx", s);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("phone", phone);
            hashMap.put("nickName", name);
            hashMap.put("pwd",s);
            mPresenter.postDoParams(MyUrls.REGISTER_URL, RegisterBean.class, hashMap);
        }else {
            Toast.makeText(this, "手机号不符合规范", Toast.LENGTH_SHORT).show();
        }
    }
}
