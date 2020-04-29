package com.wd.tech.view.activity.classes;

import android.app.Activity;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/*
/**
*
* @ProjectName: MyTech
* @Package: com.wd.tech.view.activity.classes
* @ClassName: DestroyActivityUtil
* @Author: 刘文
* @CreateDate: 2020/4/28 下午9:48
* @UpdateUser: 更新者
* @UpdateDate: 2020/4/28 下午9:48
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
public class DestroyActivityUtil {
    public static List<Activity> activityList = new LinkedList();       //将要销毁的Activity事先存在这个集合中
    public void exit()              //  启动退出程序的按钮时，调用该方法，遍历一遍集合，销毁所有的Activity
    {
        for(Activity act:activityList)
        {
            Log.d("TAGS",act.toString());
            act.finish();
        }
        System.exit(0);
    }

}
