package org.batonhunter.server.restful.model.gamedata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import org.batonhunter.server.restful.model.PrimaryObject;

import java.util.Collection;

/**
 * Created by ianchiu on 2015/8/21.
 */
@DatabaseTable(tableName = "subcategories")
public class SubCategory implements PrimaryObject{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String imgPath;
    @ForeignCollectionField
    private Collection<Job> jobs;

    public SubCategory(){}

    public SubCategory(String title, String imgPath, Collection<Job> jobs){
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

    @Override
    public void removeForeignObject() {
        this.jobs = null;
    }
}
