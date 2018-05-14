package com.jordanburke.taskmanagerproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private TaskClickListener taskClickListener;




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

    public class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TaskViewHolder(View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.item_task_name_view);
            dueDateView = itemView.findViewById(R.id.date_text_view);
            detailTaskView = itemView.findViewById(R.id.details_item_view);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }


        public void bindTaskList(Tasks position) {

            taskName.setText(tasksList.get(getAdapterPosition()).getTaskName());
            dueDateView.setText(tasksList.get(getAdapterPosition()).getTaskDueDate());
            detailTaskView.setText(tasksList.get(getAdapterPosition()).getTaskDetails());


        }





        @Override
        public void onClick(View v) {
           Context context = v.getContext();
            Toast.makeText(context, "Click Successful", Toast.LENGTH_SHORT).show();


        }


        @Override
        public boolean onLongClick(View v) {
            Context context = v.getContext();
            Toast.makeText(context, "LongClick Successful", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void alertDialogMessage() {

    }









    }





