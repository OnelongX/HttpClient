package com.ways2u.test;

import com.google.gson.reflect.TypeToken;
import com.ways2u.net.PostJsonService;
import com.ways2u.test.validate.ValidatorUtil;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by huanglong on 2016/12/14.
 */
public class Test {
    public static void main(String[] agvs) {


        //PostJsonService postJsonService = create(PostJsonService.class);
        //postJsonService.getPersons();

        Method method[] = null;
        try {
            method = PostJsonService.class.getMethods();//.getMethod("applyMethod",Map.Entry.class);

            for (Method m:method){
                //System.out.println(m.getName()+" "+m.getGenericReturnType());
            }



            //postJsonService.postJson(null);

            //ValidatorUtil.getFunctionName();

            //method = new Test().getClass().getMethod("applyMethod",MyRespone.class);

            //Type[] types = method.getGenericParameterTypes();
            //ParameterizedType pType = (ParameterizedType)types[0];
            //for (Type type:types)
            //    System.out.println(type);
            //System.out.println(method.getGenericReturnType());



            //返回所有者类型，打印结果是interface java.util.Map
            //System.out.println(pType.getOwnerType());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static MyRespone<Person> applyMethod(MyRespone<Person> respone1){
        MyRespone<Person> respone = new MyRespone<Person>();
        respone.body = new Person();
        return respone;
    }




}
