package com.ways2u.test.validate;

/**
 * Created by huanglong on 2016/12/15.
 */
public interface IValidator<Request,Response> {
    boolean validate(Request request,Response response);
}
