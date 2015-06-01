package org.batonhunter.server.restful.model;

import com.fasterxml.uuid.Generators;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ianchiu on 2015/5/30.
 */
@DatabaseTable(tableName = "users")
public class User {
    @DatabaseField(unique = true)
    private String email;
    @DatabaseField(unique = true)
    private String uuid;
    @DatabaseField
    private String picUri;
    @DatabaseField
    private String jobId;
    @DatabaseField
    private String name;

    //ormlite required a empty constructor
    public User(){}

    //for new user creation process
    public User(String email, String picUri, String name){
        this.email = email;
        this.picUri = picUri;
        this.name = name;
        this.uuid = Generators.timeBasedGenerator().generate().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
