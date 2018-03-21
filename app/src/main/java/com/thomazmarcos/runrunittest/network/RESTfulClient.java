package com.thomazmarcos.runrunittest.network;


import com.thomazmarcos.runrunittest.dto.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by thomaz on 16/03/18.
 */
public interface RESTfulClient {

    String API_URL = "https://runrun.it/api/v1.0/";

    String APP_KEY = "409695a7018dd5c896a8b34b5c402ef4";
    String USER_TOKEN = "Mq3bvpIKd1ce9EPcxJV";

    // thomazmarcos@einrot.com
    // Mae

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @GET("users")
    Call<ArrayList<Object>> allUsers();

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @GET("tasks")
    Call<ArrayList<Task>> allTasks();

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @POST("tasks/{id}/play")
    Call<Task> playTask(@Path("id") Long id);

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @POST("tasks/{id}/pause")
    Call<Task> pauseTask(@Path("id") Long id);

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @POST("tasks/{id}/deliver")
    Call<Task> deliverTask(@Path("id") Long id);


}