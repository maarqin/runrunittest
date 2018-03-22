package com.thomazmarcos.runrunittest.mvp.tasks;

import android.app.Activity;

import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

/**
 * Created by thomaz on 18/03/2018.
 */

public interface TaskModel {

    void all();

    void update(Activity activity, Long id, BaseTaskApi.Update.UpdateAction<Task> action);
}
