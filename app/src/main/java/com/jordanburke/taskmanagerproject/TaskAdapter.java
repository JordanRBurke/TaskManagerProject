package com.jordanburke.taskmanagerproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
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
    @BindView(R.id.task_name_edit)
    protected TextInputEditText taskNameEdit;
    @BindView(R.id.due_date_edit)
    protected TextInputEditText dueDateEdit;
    @BindView(R.id.details_edit_text)
    protected TextInputEditText detailsEdit;
    private Tasks tasks;




    public TaskAdapter(List<Tasks> tasksList, Context mainActivity) {
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
        return tasksList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TaskViewHolder(View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.item_task_name_view);
            dueDateView = itemView.findViewById(R.id.date_text_view);
            detailTaskView = itemView.findViewById(R.id.details_item_view);
        }


        public void bindTaskList(Tasks position) {

            taskName.setText(tasksList.get(getAdapterPosition()).getTaskName());
            dueDateView.setText(tasksList.get(getAdapterPosition()).getTaskDueDate());
            detailTaskView.setText(tasksList.get(getAdapterPosition()).getTaskDetails());


        }
    }







    }





