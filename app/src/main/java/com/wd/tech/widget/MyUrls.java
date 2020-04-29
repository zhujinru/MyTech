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
    //查询分组
    String BASE_FIND_ALLGROUP="techApi/chat/verify/v1/findFriendGroupList";
    //查询分组下所有好友信息
    String BASE_FINDMAN_BYGROUP="techApi/chat/verify/v1/findFriendListByGroupId";
    //资讯所有列表
    String CLASSIFICATION="techApi/information/v1/findAllInfoPlate?id&name&pic";
    //列表详情 get
    String CONSULT_INFO_DATAILS = "techApi/information/v1/findInformationDetails";
    //查看所有评论
    String CONSULT_FIND_COMMENT = "techApi/information/v1/findAllInfoCommentList";

    String CONSULT_RECOMMEND_LIST = "techApi/information/v1/infoRecommendList";//列表展示 GET 头参
    String CONSULT_FIND_PLATE = "techApi/information/v1/findAllInfoPlate";//频道选择 get
    String CONSULT_ADD_COMMENT = "techApi/information/verify/v1/addInfoComment";//用户发表评论
    String CONSULT_ADD_GREAT = "techApi/information/verify/v1/addGreatRecord";//用户点赞
    String CONSULT_CANCLE_GREAT = "techApi/information/verify/v1/cancelGreat";//用户取消点赞
    String CONSULT_ADD_COLLECTION = "techApi/user/verify/v1/addCollection";//用户收藏资讯
    String CONSULT_CANCLE_COLLECTION = "techApi/user/verify/v1/cancelCollection";//用户取消收藏资讯

    //社区
    //点赞
    String BASE_COMMUNITY_ZAN="techApi/community/verify/v1/addCommunityGreat";
    //取消点赞
    String BASE_DELETE_ZAN="techApi/community/verify/v1/cancelCommunityGreat";
    //发表帖子
    String BASE_POST="techApi/community/verify/v1/releasePost";
    //社区用户评论列表
    String BASE_COMMUNI_PL="techApi/community/v1/findCommunityUserCommentList";
    //社区评论
    String BASE_FILM="techApi/community/verify/v1/addCommunityComment";
    //查询用户帖子
    String BASE_USER_COM="techApi/community/verify/v1/findUserPostById";
}
