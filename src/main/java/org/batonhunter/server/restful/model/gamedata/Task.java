package org.batonhunter.server.restful.model.gamedata;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import org.batonhunter.server.restful.model.gamedata.Question.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Created by ianchiu on 2015/8/21.
 */
@DatabaseTable(tableName = "tasks")
public class Task {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int taskId;
    @DatabaseField
    private String title;
    @DatabaseField
    private String content;
    @DatabaseField
    private String imgPath;
    @DatabaseField(foreign = true)
    private Job job;
    @ForeignCollectionField
    private Collection<Question> questions;

    public Task(){}

    public Task(int taskId, String title, String content, String imgPath, Collection<Question> questions){
        this.taskId = taskId;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.questions = questions;
    }

    public Question randomeQuestion(){
        Random rnd = new Random();
        int i = rnd.nextInt(questions.size());
        return (Question)questions.toArray()[i];
    }

    public void setQuestions(Collection<Question> questions){
        this.questions = questions;
    }

    public boolean equals(String taskId) {
        return taskId.equals(String.valueOf(this.taskId));
    }
}
