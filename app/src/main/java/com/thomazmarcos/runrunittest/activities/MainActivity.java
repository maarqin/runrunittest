package com.thomazmarcos.runrunittest.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.thomazmarcos.runrunittest.R;
import com.thomazmarcos.runrunittest.adapters.TaskAdapter;
import com.thomazmarcos.runrunittest.dto.Task;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskModelImpl;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskPresenter;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskPresenterImpl;
import com.thomazmarcos.runrunittest.mvp.tasks.TaskView;
import com.thomazmarcos.runrunittest.network.BaseTaskApi;
import com.thomazmarcos.runrunittest.util.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TaskView, RecyclerItemClickListener.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_tasks)
    protected RecyclerView rvTasks;
    @BindView(R.id.sw_main)
    protected SwipeRefreshLayout swMain;

    private TaskPresenter taskPresenter;

    private List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rvTasks.setHasFixedSize(true);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        rvTasks.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), rvTasks, this));

        swMain.setOnRefreshListener(this);

        setDecorationLine(rvTasks);

        taskPresenter = new TaskPresenterImpl(this);
        taskPresenter.all();
    }

    @Override
    public void successOnAll(List<Task> tasks) {
        this.tasks = tasks;

        rvTasks.setAdapter(new TaskAdapter(tasks, taskPresenter, this));
        swMain.setRefreshing(false);
    }

    @Override
    public Activity getActivity() {
        return this;
    }


    protected void setDecorationLine(RecyclerView rv) {
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_line);

        rv.addItemDecoration(new DividerItemDecoration(dividerDrawable));
    }

    @Override
    public void onItemClick(View view, int position) {
        //
    }

    @Override
    public void onLongClick(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tem certeza que deseja entregar esta tarefa?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                taskPresenter.update(tasks.get(position), new BaseTaskApi.Update.Deliver());
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onRefresh() {
        taskPresenter.all();
    }
}
