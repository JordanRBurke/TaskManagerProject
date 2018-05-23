package com.jordanburke.taskmanagerproject;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskCallBack{

    @BindView(R.id.create_task_button)
    protected Button createTaskButton;
    @BindView(R.id.remove_tasks_button)
    protected Button removeTaskButton;
    //    @BindView(R.id.list_tasks_button)
//    protected Button listTasksButton;
    private CreateTaskFragment createTaskFragment;
    private EditTaskFragment editTaskFragment;
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
        bottomNavigationView = findViewById(R.id.navigation_bottom_view);
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



    @Override
    protected void onStart() {
        super.onStart();
        bottomNavigationMenu();

//        settingUpAdapter();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        getSupportFragmentManager().beginTransaction().remove(taskListFragment);
        ViewGroup viewGroup = findViewById(R.id.main_frame_layout);
        viewGroup.removeAllViews();




    }

    private AlertDialog alertMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Task")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editTaskFragment = EditTaskFragment.newInstance();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, editTaskFragment).commit();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();



    }

    @Override
    public void rowClicked(Tasks tasks) {

        alertMessage("Would you like to edit the task?");
    }
}
