package org.batonhunter.server.restful.service;

import com.j256.ormlite.dao.Dao;
import org.batonhunter.server.restful.model.Job;
import org.batonhunter.server.restful.model.User;
import org.batonhunter.server.restful.util.JdbcUtil;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ianchiu on 2015/7/11.
 */
public class TestService {

    public String test(){
        User user = new User();
        try {
            getUserDao().create(user);
            Collection<Job> jobs = user.getJobs();
            for(Job job: jobs){
                job.setUser(user);
                getJobDao().create(job);
            }

            Job job = getJobDao().queryForEq("current", false).get(0);


            User userx = getUserDao().queryForEq("email", user.getEmail()).get(0);
            userx.getEmail();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Dao<User, String> getUserDao(){
        return JdbcUtil.connect(User.class);
    }
    private Dao<Job, String> getJobDao(){
        return JdbcUtil.connect(Job.class);
    }
}
