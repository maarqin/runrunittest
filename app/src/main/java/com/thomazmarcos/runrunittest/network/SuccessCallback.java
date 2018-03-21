package com.thomazmarcos.runrunittest.network;

import android.app.Activity;
import android.app.ProgressDialog;

import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by thomaz on 16/03/18.
 */
abstract class SuccessCallback<T> extends BaseCallBack<T> implements Callback<T> {

    private ProgressDialog dialog;
    private Activity activity;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(RESTfulClient.API_URL)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create()))
            .client(new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build())
            .build();

    RESTfulClient rest = retrofit.create(RESTfulClient.class);

    public SuccessCallback() {
    }

    public SuccessCallback(Activity activity) {
        this.activity = activity;
    }

    public SuccessCallback(Activity activity, boolean loading) {
        this(activity);

        if( activity != null ) {
            if (loading) {
                dialog = ProgressDialog.show(activity, "", "Carregando, aguarde...", true);
            }
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        switch ( response.code() ) {
            case HttpURLConnection.HTTP_OK :
            case HttpURLConnection.HTTP_ACCEPTED :
            case HttpURLConnection.HTTP_NOT_AUTHORITATIVE :
            case HttpURLConnection.HTTP_NO_CONTENT :
            case HttpURLConnection.HTTP_RESET :
            case HttpURLConnection.HTTP_PARTIAL :
                onSuccess(response);

                break;
            case HttpURLConnection.HTTP_NOT_FOUND :
            case HttpURLConnection.HTTP_BAD_METHOD :
            case HttpURLConnection.HTTP_INTERNAL_ERROR :
            case HttpURLConnection.HTTP_NOT_IMPLEMENTED :
            case HttpURLConnection.HTTP_BAD_GATEWAY :
            case HttpURLConnection.HTTP_UNAVAILABLE :
            case HttpURLConnection.HTTP_GATEWAY_TIMEOUT :
            case HttpURLConnection.HTTP_VERSION :
                onFailure(response);
                break;
            case HttpURLConnection.HTTP_UNAUTHORIZED :
                // TODO

                break;
        }

        if( dialog != null ) dialog.dismiss();
    }

    @Override
    public void onFailure(Response<T> response) {
        /*try {
            Toast.makeText(activity, response.errorBody().string(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}