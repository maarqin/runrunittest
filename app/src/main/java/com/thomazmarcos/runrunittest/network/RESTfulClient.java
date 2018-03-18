package com.thomazmarcos.runrunittest.network;


import com.thomazmarcos.runrunittest.dto.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


/**
 * Created by thomaz on 16/03/18.
 */
public interface RESTfulClient {

    String API_URL = "http://runrun.it/api/v1.0/";

    String APP_KEY = "fd234be70940df8fc9b4e686d9aa40ea";
    String USER_TOKEN = "0l8m2arRft73rLTlsag1";

    // sudataheca@hu4ht.com

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @GET("users")
    Call<ArrayList<Object>> allUsers();

    @Headers({"App-key: " + APP_KEY, "User-Token: " + USER_TOKEN})
    @GET("tasks")
    Call<ArrayList<Task>> allTasks();


}