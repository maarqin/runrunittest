package com.thomazmarcos.runrunittest.mvp.tasks;

import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

/**
 * Created by thomaz on 18/03/2018.
 */

public interface TaskModel {

    void all();

    void update(Long id, BaseTaskApi.Update.UpdateAction<Task> action);
}
