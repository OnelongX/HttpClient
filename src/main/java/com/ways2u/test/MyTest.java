package com.ways2u.test;

import com.ways2u.config.ConfigModule;
import com.ways2u.net.*;
import com.ways2u.test.AppModule;
import com.ways2u.test.DaggerAppComponent;
import com.ways2u.test.validate.ValidatorUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import junit.framework.TestCase;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Created by huanglong on 2016/12/15.
 */
public class MyTest extends TestCase{
    @Inject
    PostJsonService postJsonService;
    //PostJsonService poxyPostJsonService;

    @Inject
    GankApi gankApi;

    //GankApi poxyGankApi;

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        NetComponent netComponent = DaggerNetComponent.builder()
                .configModule(new ConfigModule())
                .netModule(new NetModule())
                .build();
        DaggerAppComponent.builder()
                .netComponent(netComponent)
                .appModule(new AppModule())
                .build()
                .inject(this);
        //poxyPostJsonService = ValidatorUtil.createTimeTestProxy(PostJsonService.class,postJsonService);

        //poxyGankApi = ValidatorUtil.createTimeTestProxy(GankApi.class,gankApi);
    }

    public void testGetPersons() throws IOException {

        Call<List<Person>> call =  postJsonService.getPersons();
        Response<List<Person>> response = call.execute();
        assertNotNull(response);
        assertNotNull(response.body());

        //测试的业务逻辑

        //assertEquals(8,response.body().size());

    }

    public void testLatest(){

        Observable<Meizi> observable = gankApi.latest(10,1);
        observable.subscribe(new Observer<Meizi>() {
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(Meizi meizi) {
                assertNotNull(meizi);
                assertFalse(meizi.isError());
                assertNotNull(meizi.getResults());
                assertEquals(10,meizi.getResults().size());

            }

            public void onError(Throwable throwable) {
                fail(throwable.getMessage());
            }

            public void onComplete() {

            }
        });
    }
}
