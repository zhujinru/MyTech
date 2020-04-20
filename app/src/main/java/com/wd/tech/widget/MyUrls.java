package com.wd.tech.widget;

/**
 * date:2020/4/18
 * author:朱金茹(Lenovo)
 * function:
 */
public interface MyUrls {

    boolean isDebug=true;
    String BASE_WRAP_URL = "https://172.17.8.100/";
    String BASE_OUTER_URL = "https://mobile.bwstudent.com/";
    static String baseUrl(){
        return isDebug==true?BASE_OUTER_URL:BASE_WRAP_URL;
    }
    String url=baseUrl();
    //登录 post phone pwd
    String BASE_LOGIN="techApi/user/v1/login";
}
