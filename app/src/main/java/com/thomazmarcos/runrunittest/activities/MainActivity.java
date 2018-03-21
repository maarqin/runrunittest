package com.thomazmarcos.runrunittest.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.thomazmarcos.runrunittest.R;
import com.thomazmarcos.runrunittest.adapters.TaskAdapter;
import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskModelImpl;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskPresenter;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskPresenterImpl;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskView;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TaskView {

    @BindView(R.id.rv_tasks)
    protected RecyclerView rvTasks;

    private TaskPresenter taskPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rvTasks = findViewById(R.id.rv_tasks);

        ButterKnife.bind(this);

        rvTasks.setHasFixedSize(true);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        setDecorationLine(rvTasks);

        taskPresenter = new TaskPresenterImpl(this);
        taskPresenter.all();
    }

    @Override
    public void successOnAll(List<Task> tasks) {

        rvTasks.setAdapter(new TaskAdapter(tasks, taskPresenter));
    }


    protected void setDecorationLine(RecyclerView rv) {
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_line);

        rv.addItemDecoration(new DividerItemDecoration(dividerDrawable));
    }
}
