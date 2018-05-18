package com.jordanburke.taskmanagerproject;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Tasks implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String taskName;
    private String taskDueDate;
    private String taskDetails;
    private int listPosition;

    public Tasks(String taskName, String taskDueDate, String taskDetails) {
        this.taskName = taskName;
        this.taskDueDate = taskDueDate;
        this.taskDetails = taskDetails;
    }

    protected Tasks(Parcel in) {
        id = in.readInt();
        taskName = in.readString();
        taskDueDate = in.readString();
        taskDetails = in.readString();
        listPosition = in.readInt();
    }

    public static final Creator<Tasks> CREATOR = new Creator<Tasks>() {
        @Override
        public Tasks createFromParcel(Parcel in) {
            return new Tasks(in);
        }

        @Override
        public Tasks[] newArray(int size) {
            return new Tasks[size];
        }
    };

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(taskName);
        dest.writeString(taskDueDate);
        dest.writeString(taskDetails);
        dest.writeInt(listPosition);
    }
}
