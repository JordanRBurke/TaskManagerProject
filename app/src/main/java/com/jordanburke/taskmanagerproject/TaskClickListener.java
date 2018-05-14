package com.jordanburke.taskmanagerproject;

public interface TaskClickListener {

    void onTaskClicked(int position);

    void onTaskLongClick(int position);
}
