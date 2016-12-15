package com.ways2u.config;


import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

import javax.inject.Named;

/**
 * Created by huanglong on 2016/12/11.
 */
@Module
@Reusable
public class ConfigModule {

    public ConfigModule(){
    }
//http://testpanda.huodao.hk/api/account/huishou_order/express_list?token=2df0416ca60ac960443b9b815e71febf&re_order_no=R161202341509744
    @Reusable
    @Provides
    public String provideBaseUrl(){
        //return "http://gank.io/api/";
        return "http://localhost:8080/";
    }

    @Reusable
    @Provides
    @Named("debug")
    public boolean provideDebug(){
        return false;
    }

    @Reusable
    @Provides
    @Named("networkInterceptor")
    public boolean provideOpenNetworkInterceptor(){
        return false;
    }


    @Reusable
    @Provides
    //秒
    public long timeOut(){
        return 30;
    }

}
