package com.thomazmarcos.runrunittest.util;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by thomaz on 22/03/2018.
 */

//@Singleton
public class HttpInterceptor implements Interceptor {

//    @Inject
    public HttpInterceptor() {}

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Accept-Language", Locale.getDefault().getLanguage())
//                .addHeader("Accept", RestApi.VERSION_HEADER + RestApi.API_VERSION)
                .build();
        return chain.proceed(request);
    }

}