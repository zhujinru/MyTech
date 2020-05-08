package com.wd.tech.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.R;
import com.wd.tech.base.BaseActivity;
import com.wd.tech.bean.LoginBean;
import com.wd.tech.hr.LivenessActivity;
import com.wd.tech.presenter.TechPresenter;
import com.wd.tech.util.RsaCoder;
import com.wd.tech.widget.MyApp;
import com.wd.tech.widget.MyUrls;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

public class LoginActivity extends BaseActivity<TechPresenter> {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.eye)
    ImageView eye;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login)
    Button login;
    private SharedPreferences sp;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        sp = getSharedPreferences("login.dp", MODE_PRIVATE);
    }

    @Override
    protected TechPresenter providePresenter() {
        return new TechPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void DestroyActivity() {

    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof LoginBean&& TextUtils.equals("0000",((LoginBean) o).getStatus())){
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("b",true);
            edit.putInt("uid",((LoginBean) o).getResult().getUserId());
            edit.putString("sid",((LoginBean) o).getResult().getSessionId());
            edit.putString("head",((LoginBean) o).getResult().getHeadPic());
            Toast.makeText(this, ((LoginBean) o).getMessage(), Toast.LENGTH_SHORT).show();
            edit.commit();

            JMessageClient.login(((LoginBean) o).getResult().getPhone(), MyApp.s2, new BasicCallback() {
                @Override
                public void gotResult(int i, String s) {
                    switch (i) {
                        case 801003:
                            Toast.makeText(LoginActivity.this, "极光用户名不存在", Toast.LENGTH_SHORT).show();
                            break;
                        case 871301:
                            Toast.makeText(LoginActivity.this, "极光密码格式错误", Toast.LENGTH_SHORT).show();
                            break;
                        case 801004:
                            Toast.makeText(LoginActivity.this, "极光密码错误", Toast.LENGTH_SHORT).show();
                            break;
                        case 0:
                            Toast.makeText(LoginActivity.this, "极光登陆成功", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });


            startActivity(LoginActivity.this, MainActivity.class);
            finish();
        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
    @OnClick({R.id.eye, R.id.register, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.eye:
                break;
            case R.id.register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.login:
                String phon = phone.getText().toString().trim();
                String pw = pwd.getText().toString().trim();
                boolean b = Pattern.matches("^1[3|5|7|8][0-9]{9}$", phon);
                if (b){
                    /*if (TextUtils.isEmpty(phon)||TextUtils.isEmpty(pw)){
                        Toast.makeText(this, "账号或密码为空,请重新输入", Toast.LENGTH_SHORT).show();
                        return;
                    }else {*/
                        try {
                            String pwd = RsaCoder.encryptByPublicKey(pw);
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("phone",phon);
                            map.put("pwd",pwd);
                            Log.d("myPhone",pwd);
                            mPresenter.postDoParams(MyUrls.BASE_LOGIN, LoginBean.class,map);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                  //  }
                }else {
                    Toast.makeText(this, "手机号不合法", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }
    }

    // TODO: 2020/4/20 微信登录
    public void wxlogin(View view) {

    }
    // TODO: 2020/4/20 虹软人脸识别登录
    public void hrlogin(View view) {
        LivenessActivity.flag = 2;
        startActivity(new Intent(LoginActivity.this, LivenessActivity.class));
    }

}
