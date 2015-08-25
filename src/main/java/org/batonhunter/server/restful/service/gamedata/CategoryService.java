package org.batonhunter.server.restful.service.gamedata;

import org.batonhunter.server.restful.model.PrimaryObject;
import org.batonhunter.server.restful.model.gamedata.Category;
import org.batonhunter.server.restful.model.gamedata.Job;
import org.batonhunter.server.restful.model.gamedata.Question.Question;
import org.batonhunter.server.restful.model.gamedata.SubCategory;
import org.batonhunter.server.restful.model.gamedata.Task;
import org.batonhunter.server.restful.util.TestData;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class CategoryService {

    public ArrayList<Category> getCategories() {
        return removeForeignObject(getAllCategory().iterator());
    }

    public ArrayList<SubCategory> getSubCategories(String title) {
        return removeForeignObject(getAllSubCategories(title).iterator());
    }

    public ArrayList<Job> getJobs(String title, String subTitle) {
        return removeForeignObject(getAllJob(title, subTitle).iterator());
    }

    public Job getJob(String jobId) {
        Job job = getJobById(jobId);
        job.setTasks(null);
        return job;
    }

    public ArrayList<Task> getTasks(String jobId) {
        return removeForeignObject(getAllTasks(jobId).iterator());
    }

    public Task getTask(String jobId, String taskId) {
        Task task = getTaskById(jobId, taskId);
        task.setQuestions(null);
        return task;
    }

    public Question getRandomQuestion(String jobId, String taskId) {
        return getTaskById(jobId, taskId).randomeQuestion();
    }

    public Question getRandomQuestion(String jobId) {
        return getJobById(jobId).randomQuestion();
    }

    private ArrayList<Category> getAllCategory() {
        return new TestData().getCategories();
    }

    private ArrayList<SubCategory> getAllSubCategories(String title) {
        for (Category category : getAllCategory()) {
            if (category.getTitle().equals(title)) {
                return new ArrayList<>(category.getSubCategories());
            }
        }
        return null;
    }

    private ArrayList<Job> getAllJob(String title, String subTitle) {
        for (SubCategory subCategory : getAllSubCategories(title)) {
            if (subCategory.getTitle().equals(subTitle)) {
                return new ArrayList<>(subCategory.getJobs());
            }
        }
        return null;
    }

    private ArrayList<Task> getAllTasks(String jobId) {
        return new ArrayList<>(getJobById(jobId).getTasks());
    }

    private Job getJobById(String jobId) {
        for (Category category : getAllCategory()) {
            for (SubCategory subCategory : category.getSubCategories())
                for (Job job : subCategory.getJobs()) {
                    if (job.equals(jobId)) {
                        return job;
                    }
                }
        }
        return null;
    }

    private Task getTaskById(String jobId, String taskId) {
        for (Task task : getAllTasks(jobId)) {
            if (task.equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    private <E extends PrimaryObject> ArrayList<E> removeForeignObject(Iterator<E> iterator) {
        ArrayList<E> arrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            E e = iterator.next();
            e.removeForeignObject();
            arrayList.add(e);
        }
        return arrayList;
    }
}