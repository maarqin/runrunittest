package com.thomazmarcos.runrunittest.mvp.tasks;

import com.thomazmarcos.runrunittest.dto.Task;

import java.util.List;

/**
 * Created by thomaz on 18/03/2018.
 */

public interface TaskView {
    void successOnAll(List<Task> tasks);
}
