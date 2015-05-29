package org.batonhunter.server.restful.model;

import com.fasterxml.uuid.Generators;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class User {
    private String email;
    private String uuid;
    private String picUri;
    private String jobId;
    private String name;

    public User(String email, String picUri, String name){
        this.email = email;
        this.picUri = picUri;
        this.name = name;
        this.uuid = Generators.timeBasedGenerator().generate().toString();
    }

    public User(String email, String picUri, String jobId, String name, String uuid){
        this.email = email;
        this.picUri = picUri;
        this.jobId = jobId;
        this.name = name;
        this.uuid = uuid;
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
