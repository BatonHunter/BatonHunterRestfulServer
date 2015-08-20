package org.batonhunter.server.restful.util;

import org.batonhunter.server.restful.model.user.Job;
import org.batonhunter.server.restful.model.user.Task;
import org.batonhunter.server.restful.model.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ianchiu on 2015/8/20.
 */
public class UserHelper {
    public static User removeInfinityReferenceForUser(User user){
        if(null == user || user.getJobs().isEmpty())
            return user;

        user.setJobs(removeInfinityUserFromJob(user.getJobs().iterator()));
        return user;
    }

    private static Collection<Job> removeInfinityUserFromJob(Iterator<Job> jobsIterator){
        Collection<Job> jobs = new ArrayList<>();
        while(jobsIterator.hasNext()){
            Job job = jobsIterator.next();
            job.setUser(null);
            jobs.add(removeInfinityJobFromTask(job));
        }

        return jobs;
    }

    private static Job removeInfinityJobFromTask(Job job){
        Iterator<Task> taskIterator = job.getTasks().iterator();
        Collection<Task> tasks = new ArrayList<>();

        while(taskIterator.hasNext()){
            Task task = taskIterator.next();
            task.setJob(null);
            tasks.add(task);
        }

        job.setTasks(tasks);
        return job;
    }
}
