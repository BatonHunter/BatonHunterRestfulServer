package org.batonhunter.server.restful.service.user;

import org.batonhunter.server.restful.model.user.Job;
import org.batonhunter.server.restful.model.user.Task;
import org.batonhunter.server.restful.model.user.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static org.batonhunter.server.restful.util.JdbcUtil.getDao;
import static org.batonhunter.server.restful.util.JsonUtil.convertBodytoMap;

/**
 * Created by ianchiu on 2015/8/20.
 */
public class JobService {
    public Boolean addJob(String email, String body) {
        Map<String, String> mapedBody = convertBodytoMap(body);
        User user = new UserService().getUser(email);

        if (!user.isJobFull() && !user.isJobDuplicated(mapedBody.get("id"))) {
            this.insertJobIntoDb(
                    new Job(parseInt(mapedBody.get("id")), mapedBody.get("title")),
                    user
            );
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteJob(String email, String jobId) {
        ArrayList<Job> jobs = new ArrayList<>(new UserService().getUser(email).getJobs());

        try {
            for (Job job : jobs) {
                if (job.equals(jobId)) {
                    getDao(Job.class).delete(job);
                    this.delteTasksByJob(job);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean completedTask(String email, String jobId, String taskId){
        ArrayList<Job> jobs = new ArrayList<>(new UserService().getUser(email).getJobs());
        for (Job job: jobs){
            if(job.equals(jobId)){
                ArrayList<Task> tasks = new ArrayList<>(job.getTasks());
                for(Task task: tasks){
                    if(task.equals(taskId)){
                        task.taskCompleted();
                        try {
                            task.setJob(job);
                            getDao(Task.class).update(task);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void insertJobIntoDb(Job job, User user) {
        try {
            job.setUser(user);
            getDao(Job.class).create(job);
            insertTasksIntoDb(job);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertTasksIntoDb(Job job) throws SQLException {
        Collection<Task> tasks = job.getTasks();
        for (Task task : tasks) {
            task.setJob(job);
            getDao(Task.class).create(task);
        }
    }

    private void delteTasksByJob(Job job) throws SQLException {
        getDao(Task.class).delete(job.getTasks());
    }
}