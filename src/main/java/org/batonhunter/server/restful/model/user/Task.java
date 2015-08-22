package org.batonhunter.server.restful.model.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ianchiu on 2015/7/11.
 */
@DatabaseTable(tableName = "usertasks")
public class Task {

    @DatabaseField(generatedId = true, unique = true)
    private int id;
    @DatabaseField
    private int taskId;
    @DatabaseField
    private boolean isComplete;
    @DatabaseField(foreign = true)
    private Job job;

    public Task() {
    }

    public Task(int taskId){
        this.taskId = taskId;
        isComplete = false;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public void taskCompleted(){
        this.isComplete = true;
    }

    public boolean equals(String taskId) {
        return taskId.equals(String.valueOf(this.taskId));
    }
}
