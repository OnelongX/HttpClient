package com.ways2u.test.validate;

import com.google.gson.JsonElement;
import com.ways2u.test.Meizi;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by huanglong on 2016/12/15.
 */
public class ValidatorUtil {
    public static <Request, Response> boolean validate(Request request, Response response, IValidator<Request, Response> validator) {
        return validator.validate(request, response);
    }

    public static String getFunctionName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    @SuppressWarnings("unchecked")
    public static <T> T createTimeTestProxy(Class<T> cls, final Object target)
    {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println(method.getGenericReturnType());
                long start = System.currentTimeMillis();

                Object result =method.invoke(target,args);

                System.out.println(method.getName()+" cos time:"+(System.currentTimeMillis()-start));
                return result;
            }
        });
    }

}
