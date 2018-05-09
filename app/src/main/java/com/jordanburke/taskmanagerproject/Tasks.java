package com.jordanburke.taskmanagerproject;

public class Tasks {

    private String taskName;
    private String taskDueDate;
    private String taskDetails;

    public Tasks(String taskName, String taskDueDate, String taskDetails) {
        this.taskName = taskName;
        this.taskDueDate = taskDueDate;
        this.taskDetails = taskDetails;
    }

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
}
