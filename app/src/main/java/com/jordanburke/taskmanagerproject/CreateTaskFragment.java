package com.jordanburke.taskmanagerproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateTaskFragment extends Fragment {

    @BindView(R.id.create_task_final_button)
    protected Button createFinalTaskButton;
    @BindView(R.id.task_name_edit)
    protected TextInputEditText taskNameEdit;
    @BindView(R.id.due_date_edit)
    protected TextInputEditText taskDueDateEdit;
    @BindView(R.id.details_edit_text)
    protected TextInputEditText detailsEditText;
    public static final String TASK_NAME = "task_name";
    public static final String TASK_DUE_DATE = "task_due_date";
    public static final String TASK_DESCRIPTION = "task_description";
    private TaskListFragment taskListFragment;
    private TaskDatabase taskDatabase;
    private Tasks tasks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.create_task_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();

        taskDatabase = ((TaskApplication) getActivity().getApplicationContext()).getTaskDatabase();

    }

    public static CreateTaskFragment newInstance() {

        Bundle args = new Bundle();

        CreateTaskFragment fragment = new CreateTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.create_task_final_button)
    protected void taskFinalButtonClicked() {



//        Bundle bundle = new Bundle();

//        String taskName = taskNameEdit.getText().toString();
//        String taskDueDate = taskDueDateEdit.getText().toString();
//        String taskDetails = detailsEditText.getText().toString();
//        bundle.putString(TASK_NAME, taskName);
//        bundle.putString(TASK_DUE_DATE, taskDueDate);
//        bundle.putString(TASK_DESCRIPTION, taskDetails);

        taskListFragment = TaskListFragment.newInstance();

//        taskListFragment.setArguments(bundle);
        toastMessage("Task Created!");
        getFragmentManager().beginTransaction().replace(R.id.create_task_frame_layout, taskListFragment).commit();
        addTaskToList();




    }

    private void addTaskToList() {

        String gotTask = taskNameEdit.getText().toString();
        String gotDueDate = taskDueDateEdit.getText().toString();
        String gotDetails = detailsEditText.getText().toString();
        Tasks tasks = new Tasks(gotTask, gotDueDate, gotDetails);
        taskDatabase.taskDao().addTask(tasks);


    }

    private void toastMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
