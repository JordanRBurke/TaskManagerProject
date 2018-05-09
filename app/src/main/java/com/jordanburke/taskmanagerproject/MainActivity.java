package com.jordanburke.taskmanagerproject;

import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.create_task_button)
    protected Button createTaskButton;
    @BindView(R.id.remove_tasks_button)
    protected Button removeTaskButton;
    //    @BindView(R.id.list_tasks_button)
//    protected Button listTasksButton;
    private CreateTaskFragment createTaskFragment;
    private TaskListFragment taskListFragment;
    private TaskAdapter adapter;
    private TaskDatabase taskDatabase;
    private BottomNavigationView bottomNavigationView;
//    @BindView(R.id.task_item_recycler_view)
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    private void bottomNavigationMenu() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                taskListFragment = TaskListFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, taskListFragment).commit();


                return false;
            }
        });
    }

    @OnClick(R.id.create_task_button)
    protected void createTaskClicked() {

        createTaskFragment = CreateTaskFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, createTaskFragment).commit();


    }

    @OnClick(R.id.remove_tasks_button)
    protected void removeTaskClicked() {


    }

//    @OnClick(R.id.list_tasks_button)
//    protected void listTasksClicked() {
//
//        taskListFragment = TaskListFragment.newInstance();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, taskListFragment).commit();
//
//    }

    private void settingUpAdapter() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new TaskAdapter(taskDatabase.taskDao().getTasks(), this);

//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();




    }

    @Override
    protected void onStart() {
        super.onStart();
//        settingUpAdapter();
    }
}
