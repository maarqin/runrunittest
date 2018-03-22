package com.thomazmarcos.runrunittest.mvp.tasks;

import android.app.Activity;

import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
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
                super.onFailure(call, t);

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
    public void update(Activity activity, Long id, BaseTaskApi.Update.UpdateAction<Task> action) {

        new BaseTaskApi.Update(activity, action, id) {
            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                super.onFailure(call, t);
            }

            @Override
            public void onSuccess(Response<Task> response) {
                all();
            }
        };
    }

    private void showAll() {
        List<Task> tasks = realm.where(Task.class).findAllSorted("queue_position");

        taskPresenter.showAll(tasks);
    }
}
