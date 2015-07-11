package org.batonhunter.server.restful.model.user;

import com.fasterxml.uuid.Generators;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ianchiu on 2015/5/30.
 */
@DatabaseTable(tableName = "users")
public class User implements Serializable{
    //Basic Information
    @DatabaseField(unique = true)
    private String email;
    @DatabaseField(unique = true, id = true)
    private String uuid;
    @DatabaseField
    private String picUri;
    @DatabaseField
    private String name;

    //Personality
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private String[] strength;
    @DatabaseField
    private String category;
    @DatabaseField
    private String role;

    //Chosen Job list
    @ForeignCollectionField
    private Collection<Job> jobs = null;

    //Money, AP, Points, Experience, Level
    @DatabaseField(foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    private Status status;

    //ormlite required a empty constructor
    public User(){}

    //For firsttime Login process
    public User(String email, String picUri, String name){
        this.email = email;
        this.picUri = picUri;
        this.name = name;
        this.uuid = Generators.timeBasedGenerator().generate().toString();

        this.strength = new String[]{};
        this.status = new Status(this);
    }

    public Collection getJobs(){
        return jobs;
    }

    public String getPicUri() {
        return picUri;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String[] getStrength() {
        return strength;
    }

    public void setStrength(String[] strength) {
        this.strength = strength;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }
}
