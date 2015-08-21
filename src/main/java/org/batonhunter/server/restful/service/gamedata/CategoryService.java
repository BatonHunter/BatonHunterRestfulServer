package org.batonhunter.server.restful.service.gamedata;

import org.batonhunter.server.restful.model.gamedata.Category;
import org.batonhunter.server.restful.model.gamedata.Job;
import org.batonhunter.server.restful.model.gamedata.Question.Question;
import org.batonhunter.server.restful.model.gamedata.Task;
import org.batonhunter.server.restful.util.TestData;

import java.util.ArrayList;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class CategoryService {

    public ArrayList<Category> getAllCategory(){
        return new TestData().getCategories();
    }

    public ArrayList<Job> getAllJob(String title){
        for(Category category: getAllCategory()){
            if(category.getTitle().equals(title)){
                return new ArrayList<>(category.getJobs());
            }
        }
        return null;
    }

    private Job getJobById(String jobId){
        for(Category category: getAllCategory()){
            for(Job job: category.getJobs()){
                if(job.equals(jobId)){
                    return job;
                }
            }
        }
        return null;
    }

    public ArrayList<Task> getTasks(String jobId){
        return new ArrayList<>(getJobById(jobId).getTasks());
    }

    public Task getTaskById(String jobId, String taskId){
        for(Task task: getTasks(jobId)){
            if(task.equals(taskId)){
                return task;
            }
        }
        return null;
    }

    public Question getRandomQuestion(String jobId, String taskId){
        return getTaskById(jobId, taskId).randomeQuestion();
    }
}
