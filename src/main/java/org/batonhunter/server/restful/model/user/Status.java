package org.batonhunter.server.restful.model.user;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ianchiu on 2015/7/18.
 */
@DatabaseTable(tableName = "userstatus")
public class Status {
    @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField
    private int money;
    @DatabaseField
    private int exp;
    @DatabaseField
    private int level;
    @DatabaseField
    private int ap;
    @DatabaseField
    private int point;

    public Status(){}

    public Status(User user){
        this.money = 0;
        this.exp = 0;
        this.level = 1;
        this.ap = 5;
        this.point = 0;
    }

    public void update(int money, int exp, int ap, int point){
        this.money += money;
        this.exp += exp;
        this.ap += ap;
        this.point += point;
    }
}
