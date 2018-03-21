package com.thomazmarcos.runrunittest.network;

import com.thomazmarcos.runrunittest.dto.Task;

import java.util.ArrayList;

import retrofit2.Call;


/**
 * Created by thomaz on 18/03/2018.
 */
public class BaseTaskApi {


    public abstract static class All extends SuccessCallback<ArrayList<Task>> {

        public All() {
            super();

            rest.allTasks().enqueue(this);
        }
    }

    public abstract static class Update extends SuccessCallback<Task> {

        public Update(UpdateAction<Task> updateAction, Long id) {
            updateAction.endpoint(rest, id).enqueue(this);
        }

        public static class Play implements UpdateAction<Task> {
            @Override
            public Call<Task> endpoint(RESTfulClient rest, Long id) {
                return rest.playTask(id);
            }
        }

        public static class Pause implements UpdateAction<Task> {
            @Override
            public Call<Task> endpoint(RESTfulClient rest, Long id) {
                return rest.pauseTask(id);
            }
        }

        public static class Deliver implements UpdateAction<Task> {
            @Override
            public Call<Task> endpoint(RESTfulClient rest, Long id) {
                return rest.deliverTask(id);
            }
        }

        public interface UpdateAction<T> {
            Call<T> endpoint(RESTfulClient rest, Long id);
        }

    }
}
