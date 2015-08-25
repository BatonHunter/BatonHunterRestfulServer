package org.batonhunter.server.restful.model.gamedata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import org.batonhunter.server.restful.model.PrimaryObject;
import org.batonhunter.server.restful.model.gamedata.Question.Question;

import java.util.Collection;
import java.util.Random;

/**
 * Created by ianchiu on 2015/8/21.
 */
@DatabaseTable(tableName = "jobs")
public class Job implements PrimaryObject{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int jobId;
    @DatabaseField
    private String title;
    @DatabaseField
    private String imgPath;
    @DatabaseField
    private String description;
    @DatabaseField(foreign = true)
    private SubCategory subCategory;
    @ForeignCollectionField
    private Collection<Task> tasks;

    public Job(){}

    public Job(int jobId, String title, String imgPath, String description, Collection<Task> tasks){
        this.jobId = jobId;
        this.title = title;
        this.imgPath = imgPath;
        this.description = description;
        this.tasks = tasks;
    }

    public void setTasks(Collection<Task> tasks){
        this.tasks = tasks;
    }

    public boolean equals(String jobId) {
        return jobId.equals(String.valueOf(this.jobId));
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public Question randomQuestion(){
        return randomTask().randomeQuestion();
    }

    private Task randomTask(){
        Random rnd = new Random();
        int i = rnd.nextInt(tasks.size());
        return (Task)tasks.toArray()[i];
    }

    @Override
    public void removeForeignObject() {
        this.tasks = null;
    }
}
