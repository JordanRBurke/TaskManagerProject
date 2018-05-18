package com.jordanburke.taskmanagerproject;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface TaskDao   {

    @Query("SELECT * FROM tasks")
    List<Tasks> getTasks();

    @Insert
    void addTask(Tasks tasks);

    @Update
    void updateTasks(Tasks tasks);

    @Delete
    void deleteTask(Tasks tasks);

}
