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

    public ArrayList<Category> getCategories(){
        ArrayList<Category> categories = new TestData().getCategories();
        for(int i = 0; i < categories.size(); i++){
            Category category = categories.get(i);
            category.setJobs(null);
            categories.set(i, category);
        }
        return categories;
    }

    public ArrayList<Job> getJobs(String title){
        ArrayList<Job> jobs = getAllJob(title);
        for(int i =0; i < jobs.size(); i++){
            Job job = jobs.get(i);
            job.setTasks(null);
            jobs.set(i, job);
        }
        return jobs;
    }

    public Job getJob(String jobId){
        Job job = getJobById(jobId);
        job.setTasks(null);
        return job;
    }

    public ArrayList<Task> getTasks(String jobId){
        ArrayList<Task> tasks = getAllTasks(jobId);
        for(int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            task.setQuestions(null);
            tasks.set(i, task);
        }
        return tasks;
    }

    public Task getTask(String jobId, String taskId){
        Task task = getTaskById(jobId, taskId);
        task.setQuestions(null);
        return task;
    }

    public Question getRandomQuestion(String jobId, String taskId){
        return getTaskById(jobId, taskId).randomeQuestion();
    }

    public Question getRandomQuestion(String jobId){
        return getJobById(jobId).randomQuestion();
    }

    private ArrayList<Category> getAllCategory(){
        return new TestData().getCategories();
    }

    private ArrayList<Job> getAllJob(String title){
        for(Category category: getAllCategory()){
            if(category.getTitle().equals(title)){
                return new ArrayList<>(category.getJobs());
            }
        }
        return null;
    }

    private ArrayList<Task> getAllTasks(String jobId){
        return new ArrayList<>(getJobById(jobId).getTasks());
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

    private Task getTaskById(String jobId, String taskId){
        for(Task task: getAllTasks(jobId)){
            if(task.equals(taskId)){
                return task;
            }
        }
        return null;
    }
}
