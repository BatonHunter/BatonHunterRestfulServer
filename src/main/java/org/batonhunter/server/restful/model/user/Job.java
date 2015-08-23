package org.batonhunter.server.restful.model.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ianchiu on 2015/7/11.
 */
@DatabaseTable(tableName = "userjobs")
public class Job implements ForeignObject {
    @DatabaseField(generatedId = true, unique = true)
    private int id;
    @DatabaseField
    private int jobId;
    @DatabaseField
    private String title;
    @DatabaseField(foreign = true)
    private User user;
    @ForeignCollectionField
    private Collection<Task> tasks = new ArrayList<>();

    public Job() {
    }

    public Job(int jobId, String title){
        this.jobId = jobId;
        this.title = title;
        for(int i = 1; i <= getTaskAmount(id); i++){
            tasks.add(new Task(i));
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Task> getTasks(){
        return tasks;
    }

    public void setTasks(Collection<Task> tasks){
        this.tasks = tasks;
    }

    private int getTaskAmount(int jobId){
        return 10;
    }

    public boolean equals(String jobId) {
        return jobId.equals(String.valueOf(this.jobId));
    }

    @Override
    public void setForeign(Object object) {
        this.user = (User)object;
    }
}
