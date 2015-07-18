package org.batonhunter.server.restful.model.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ianchiu on 2015/7/11.
 */
@DatabaseTable(tableName = "userjobs")
public class Job {
    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField
    private boolean current;
    @DatabaseField
    private String title;
    @DatabaseField(foreign = true)
    private User user;

    public Job(){}

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public boolean isCurrent(){
        return current;
    }

    public void setUser(User user){
        this.user = user;
    }
}
