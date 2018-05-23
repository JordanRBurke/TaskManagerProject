package com.jordanburke.taskmanagerproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskListFragment extends Fragment implements TaskAdapter.TaskCallBack{

    private boolean dialogRead = false;
//    @BindView(R.id.task_item_constraint_layout)
//    protected ConstraintLayout taskItemBackground;
    private TaskDatabase taskDatabase;
    private TaskAdapter adapter;
    @BindView(R.id.task_item_recycler_view)
    protected RecyclerView recyclerView;
    private List<Tasks> tasksList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.task_list_layout_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static TaskListFragment newInstance() {

        Bundle args = new Bundle();

        TaskListFragment fragment = new TaskListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();

        taskDatabase = ((TaskApplication) getActivity().getApplicationContext()).getTaskDatabase();
        settingUpAdapter();
        dialogProgress();
        taskCompleted();
    }

    private AlertDialog dialogProgress() {

        if (!dialogRead) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Hold your finger on a button to mark as complete")
                    .setTitle("Guide")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });
            return builder.create();

        } else {

        }

        return dialogProgress();
    }



    private void taskCompleted() {

        final View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                taskItemBackground.setBackgroundColor(getResources().getColor(R.color.customGreen));
                return false;
            }
        };


    }

    private void settingUpAdapter() {



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        adapter = new TaskAdapter(tasks, getContext());

        adapter = new TaskAdapter(taskDatabase.taskDao().getTasks(), getContext(), this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


    @Override
    public void rowClicked(Tasks tasks) {
        Toast.makeText(getContext(), "Test", Toast.LENGTH_SHORT).show();

    }
}