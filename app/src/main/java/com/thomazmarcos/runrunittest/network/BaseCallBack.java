package com.thomazmarcos.runrunittest.network;

import retrofit2.Response;

/**
 * Created by thomaz on 16/03/18.
 */
abstract class BaseCallBack<T> {

    public abstract void onSuccess(Response<T> response);
    public abstract void onFailure(Response<T> response);
    public abstract void onFailureValidation(Response<T> response);

}
