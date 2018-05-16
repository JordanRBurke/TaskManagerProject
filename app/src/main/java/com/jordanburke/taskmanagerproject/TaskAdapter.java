package com.jordanburke.taskmanagerproject;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
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
    private boolean singleClickSelected;
    private CreateTaskFragment createTaskFragment;
    private EditTaskFragment editTaskFragment;
    private FragmentManager fragmentManager;
    private TaskDao taskDao;


    public TaskAdapter(List<Tasks> tasksList, Context mainContext) {
        this.tasksList = tasksList;
        this.fragmentManager = fragmentManager;
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

        // When normal clicking on an object this happens:
        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            singleClickSelected = true;
            builder("Would you like to edit this task?");




        }

        //When long clicking on an object this happens:
        @Override
        public boolean onLongClick(View v) {
            Context context = v.getContext();
            Toast.makeText(context, "LongClick Successful", Toast.LENGTH_SHORT).show();
            builder("Would you like to remove this task?");
            return false;

        }

        // Alerts user based on message passed in
        private AlertDialog builder(String message) {
            final Context context = itemView.getContext();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(message)
                    .setTitle("Task")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Context context1 = itemView.getContext();
                            if (singleClickSelected) {
                                Toast.makeText(context1, "If activated", Toast.LENGTH_SHORT).show();
//                                MainActivity mainActivity = (MainActivity)context1;
//                                mainActivity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, editTaskFragment).commit();
                                singleClickSelected = false;


                            } else {
                                Toast.makeText(context1, "dialogComplete", Toast.LENGTH_SHORT).show();
//                            tasksList.remove(getLayoutPosition());
                                if (tasksList == tasksList.get(0)) {
                                    Toast.makeText(context1, "Error", Toast.LENGTH_SHORT).show();
                                } else {
//                                    taskDao.deleteTask(tasks);
                                    tasksList.remove(getAdapterPosition());
                                    notifyItemRemoved(getAdapterPosition());
                                }

                            }
                        }

                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });


//            return builder.create();
            return builder.show();
        }
    }

}













