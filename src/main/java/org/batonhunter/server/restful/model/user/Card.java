package org.batonhunter.server.restful.model.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ianchiu on 2015/8/23.
 */
@DatabaseTable(tableName = "usercards")
public class Card implements ForeignObject {
    @DatabaseField
    private String title;
    @DatabaseField(foreign = true)
    private User user;

    public Card(){}

    public Card(String title){
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setforeign(Object object) {
        this.user = (User)object;
    }
}
