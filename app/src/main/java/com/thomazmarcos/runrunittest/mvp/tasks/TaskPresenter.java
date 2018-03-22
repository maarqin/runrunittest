package com.thomazmarcos.runrunittest.mvp.tasks;

import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

import java.util.List;

/**
 * Created by thomaz on 18/03/2018.
 */
public interface TaskPresenter {

    void all();

    void showAll(List<Task> tasks);

    void update(Task task, BaseTaskApi.Update.UpdateAction action);
}
