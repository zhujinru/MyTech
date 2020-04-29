package com.wd.tech.util;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * date:2020/4/27
 * author:朱金茹(Lenovo)
 * function:转化
 */
public class RxPartMapUtils {
    public static RequestBody toRequestBodyOfText (String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body ;
    }

    public static RequestBody toRequestBodyOfImage(File pFile){

        RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), pFile);
        //MultipartBody.Part file = MultipartBody.Part.createFormData("file", pFile.getName(), fileBody);
        return fileBody;
    }
}
