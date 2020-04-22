package com.wd.tech.util;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;


public class XBanner extends SimpleBannerInfo {
    private  int  souce;

    public int getSouce() {
        return souce;
    }

    public void setSouce(int souce) {
        this.souce = souce;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
