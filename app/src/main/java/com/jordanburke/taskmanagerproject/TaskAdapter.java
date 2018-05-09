package com.jordanburke.taskmanagerproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Tasks> tasksList;

    private TextView taskName;
    private TextView dueDateView;
    private TextView detailTaskView;

    public TaskAdapter(List<Tasks> tasksList, MainActivity mainActivity) {
        this.tasksList = tasksList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);

        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bindTaskList(tasksList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskViewHolder(View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.item_task_name_view);
            dueDateView = itemView.findViewById(R.id.date_text_view);
            detailTaskView = itemView.findViewById(R.id.details_item_view);
        }


        public void bindTaskList(Tasks tasks) {
            tasks.setTaskName("");
            tasks.setTaskDetails("");
            tasks.setTaskDueDate("");
        }
    }







    }





