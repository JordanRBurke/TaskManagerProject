package com.jordanburke.taskmanagerproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditTaskFragment extends Fragment {

    @BindView(R.id.task_name_new_edit)
    protected TextInputEditText nameNewEdit;
    @BindView(R.id.due_date_new_edit)
    protected TextInputEditText dueDateNewEdit;
    @BindView(R.id.details_new_edit)
    protected TextInputEditText detailsNewEdit;
    @BindView(R.id.finish_edit_button)
    protected Button finishEditButton;
    @BindView(R.id.edit_complete_button)
    protected Button editCompleteButton;
    @BindView(R.id.edit_incomplete_button)
    protected Button editIncompleteButton;
    private List<Tasks> tasksList;
    private boolean editCompleteClicked;
    private boolean editIncompleteClicked;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_edit_task, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static EditTaskFragment newInstance() {
        
        Bundle args = new Bundle();
        
        EditTaskFragment fragment = new EditTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        editCompleteClicked = false;
        editIncompleteClicked = false;
    }

    @OnClick(R.id.finish_edit_button)
    protected void finishEditButtonClicked() {
        tasksList.get(1).setTaskName(nameNewEdit.getText().toString());
        tasksList.get(1).setTaskDueDate(dueDateNewEdit.getText().toString());
        tasksList.get(1).setTaskDetails(detailsNewEdit.getText().toString());



    }

    @OnClick(R.id.edit_complete_button)
    protected void editCompleteButtonClicked() {
        editCompleteClicked = true;
        if (editIncompleteClicked) {
            editIncompleteButton.setBackgroundColor(getResources().getColor(R.color.customWhite));
            editCompleteButton.setBackgroundColor(getResources().getColor(R.color.customGreen));
        } else {
            editCompleteButton.setBackgroundColor(getResources().getColor(R.color.customGreen));
        }

    }

    @OnClick(R.id.edit_incomplete_button)
    protected void editIncompleteButtonClicked() {
        editIncompleteClicked = true;
        if (editCompleteClicked) {
            editCompleteButton.setBackgroundColor(getResources().getColor(R.color.customWhite));
            editIncompleteButton.setBackgroundColor(getResources().getColor(R.color.myRed));
        } else {
            editIncompleteButton.setBackgroundColor(getResources().getColor(R.color.myRed));
        }

    }
}
