package com.thomazmarcos.runrunittest.mvp.tasks;

import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;
import com.thomazmarcos.runrunittest.network.RESTfulClient;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by thomaz on 18/03/2018.
 */
public class TaskModelImpl implements TaskModel {

    private TaskPresenter taskPresenter;
    private Realm realm;

    public TaskModelImpl(TaskPresenter taskPresenter) {
        this.taskPresenter = taskPresenter;

        realm = Realm.getDefaultInstance();
    }

    @Override
    public void all() {
        new BaseTaskApi.All() {

            @Override
            public void onFailure(Call<ArrayList<Task>> call, Throwable t) {
                if( t instanceof UnknownHostException ) {
                    showAll();
                }
            }

            @Override
            public void onSuccess(Response<ArrayList<Task>> response) {
                realm.beginTransaction();
                realm.insertOrUpdate(response.body());
                realm.commitTransaction();

                showAll();
            }

        };
    }

    @Override
    public void update(Long id, BaseTaskApi.Update.UpdateAction<Task> action) {

        new BaseTaskApi.Update(action, id) {
            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                //
            }

            @Override
            public void onSuccess(Response<Task> response) {
                realm.beginTransaction();
                realm.insertOrUpdate(response.body());
                realm.commitTransaction();

                showAll();
            }
        };
    }

    private void showAll() {
        List<Task> tasks = realm.where(Task.class).findAllSorted("queue_position");

        taskPresenter.showAll(tasks);
    }
}
