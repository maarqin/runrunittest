package com.thomazmarcos.runrunittest.mvp.tasks;


import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

import java.util.List;

/**
 * Created by thomaz on 18/03/2018.
 */
public class TaskPresenterImpl implements TaskPresenter {

    private TaskView taskView;
    private TaskModel taskModel;

    public TaskPresenterImpl(TaskView taskView) {
        this.taskView = taskView;
        taskModel = new TaskModelImpl(this);
    }

    @Override
    public void all() {
        taskModel.all();
    }

    @Override
    public void showAll(List<Task> tasks) {
        taskView.successOnAll(tasks);
    }

    @Override
    public void update(Task task) {

        taskModel.update(task.getId(),
                task.IsWorkingOn() ? new BaseTaskApi.Update.Pause() : new BaseTaskApi.Update.Play());
    }
}
