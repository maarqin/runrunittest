package com.thomazmarcos.runrunittest.network;

import com.thomazmarcos.runrunittest.dto.Task;

import java.util.ArrayList;

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
}
