package com.jordanburke.taskmanagerproject;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.os.AsyncTask;

@Database(version = 1, entities = Tasks.class, exportSchema = false)
@TypeConverters(TaskConverter.class)


abstract class TaskDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();

}
