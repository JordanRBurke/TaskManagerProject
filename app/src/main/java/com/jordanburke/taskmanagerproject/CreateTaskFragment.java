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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.create_task_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    public static CreateTaskFragment newInstance() {

        Bundle args = new Bundle();

        CreateTaskFragment fragment = new CreateTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.create_task_final_button)
    protected void taskFinalButtonClicked() {

        toastMessage("Task Created!");
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);

    }

    private void toastMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
