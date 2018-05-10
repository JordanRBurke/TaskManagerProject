package com.jordanburke.taskmanagerproject;

import android.app.Application;
import android.arch.persistence.room.Room;

public class TaskApplication extends Application {

    private TaskDatabase taskDatabase;
    public static final String DATABASE_NAME = "task_database";

    @Override
    public void onCreate() {
        super.onCreate();

        taskDatabase = Room.databaseBuilder(getApplicationContext(), TaskDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public TaskDatabase getTaskDatabase() {
        return taskDatabase;
    }
}
