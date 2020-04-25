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
    //注册 post phone nickName pwd
    String REGISTER_URL = "techApi/user/v1/register";
    //根据ID查询信息
    String BASE_BYID="techApi/user/verify/v1/getUserInfoByUserId";
    //查询用户的好友通知记录 get  page  count  uid sid
    String Friend_Notice="techApi/chat/verify/v1/findFriendNoticePageList";
    //资讯banner
    String BASE_BANNER="techApi/information/v1/bannerShow";
    String BASE_CONSULTSHOW="techApi/information/v1/infoRecommendList";
    //社区列表
    String COMMUNITYLIST="techApi/community/v1/findCommunityList";
    //资讯所有列表
    String CLASSIFICATION="techApi/information/v1/findAllInfoPlate?id&name&pic";
}
