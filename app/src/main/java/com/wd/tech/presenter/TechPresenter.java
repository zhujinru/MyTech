package com.wd.tech.presenter;

import com.wd.tech.base.BasePresenter;
import com.wd.tech.contract.TechContract;
import com.wd.tech.model.TechModel;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * date:2020/4/18
 * author:朱金茹(Lenovo)
 * function:
 */
public class TechPresenter extends BasePresenter<TechContract.IView> implements TechContract.IPresenter {

    private TechModel techModel;

    @Override
    protected void initModel() {
        techModel = new TechModel();
    }

    @Override
    public void getNoParams(String url, Class cls) {
        techModel.getNoParams(url, cls, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getDoParams(String url, Class cls, HashMap<String, Object> map) {
        techModel.getDoParams(url, cls, map, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postDoHeadPic(String url, Class cls, MultipartBody.Part image) {
        techModel.postDoHeadPic(url, cls, image, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postNoParams(String url, Class cls) {
        techModel.postNoParams(url, cls, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void postDoParams(String url, Class cls, HashMap<String, Object> map) {
        techModel.postDoParams(url, cls, map, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
    @Override
    public void putNoParams(String url, Class cls) {
        techModel.putNoParams(url, cls, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void putDoParams(String url, Class cls, HashMap<String, Object> map) {
        techModel.putDoParams(url, cls, map, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
    @Override
    public void dltNoParams(String url, Class cls) {
        techModel.dltNoParams(url, cls, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void dltDoParams(String url, Class cls, HashMap<String, Object> map) {
        techModel.dltDoParams(url, cls, map, new TechContract.IModelCallback() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }
}
