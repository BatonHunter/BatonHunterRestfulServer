package org.batonhunter.server.restful.model.gamedata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by ianchiu on 2015/8/21.
 */
@DatabaseTable(tableName = "categories")
public class Category {
    @DatabaseField(id = true, unique = true)
    private String title;
    @DatabaseField
    private String imgPath;
    @ForeignCollectionField
    private Collection<Job> jobs;

    public Category(){}

    public Category(String title, String imgPath, Collection<Job> jobs){
        this.title = title;
        this.imgPath = imgPath;
        this.jobs = jobs;
    }

    public String getTitle() {
        return title;
    }

    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs){
        this.jobs = jobs;
    }
}
