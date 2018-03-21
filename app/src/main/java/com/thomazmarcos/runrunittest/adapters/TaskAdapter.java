package com.thomazmarcos.runrunittest.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.thomazmarcos.runrunittest.R;
import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by thomaz on 19/03/2018.
 */
public class TaskAdapter extends BaseAdapter<Task, TaskAdapter.ViewHolder> {

    private TaskPresenter taskPresenter;

    public TaskAdapter(@NonNull List<Task> tasks, TaskPresenter taskPresenter) {
        super(tasks, R.layout.line_task);
        this.taskPresenter = taskPresenter;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Task task = tList.get(position);

        holder.tvTaskId.setText(String.valueOf(task.getId()));
        holder.tvTaskTitle.setText(String.valueOf(task.getTitle()));

        holder.ibTaskStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskPresenter.update(task);
            }
        });
    }

    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_task_id)
        TextView tvTaskId;

        @BindView(R.id.tv_task_title)
        TextView tvTaskTitle;

        @BindView(R.id.ib_task_status)
        ImageButton ibTaskStatus;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
