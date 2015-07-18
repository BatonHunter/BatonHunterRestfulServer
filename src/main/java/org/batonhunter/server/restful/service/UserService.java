package org.batonhunter.server.restful.service;

import com.j256.ormlite.dao.Dao;
import org.batonhunter.server.restful.model.user.Status;
import org.batonhunter.server.restful.model.user.User;
import org.batonhunter.server.restful.util.JdbcUtil;
import org.batonhunter.server.restful.util.JsonUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class UserService {

    public User getUser(String email){
        User user;
        List<User> result = null;
        try {
            result = getUserDao().queryForEq("email", email);
            //JdbcUtil.disConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user = result.size()!=0?result.get(0):null;
        return user;
    }

    public Boolean modifyStrength(String email, String body){
        User original_User = this.getUser(email);
        User body_user = JsonUtil.fromJson(body, User.class);

        original_User.setStrength(body_user.getStrength());
        original_User.setCategory(body_user.getCategory());
        original_User.setRole(body_user.getRole());

        try {
            getUserDao().update(original_User);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User createUser(String body){
        User user = JsonUtil.fromJson(body, User.class);
        if(user.getEmail().isEmpty()||user.getName().isEmpty()||user.getPicUri().isEmpty()){
            return null;
        }
        try {
            if(getUserDao().queryForEq("email", user.getEmail()).size()!=0){
                return getUserDao().queryForEq("email", user.getEmail()).get(0);
            }
            this.createNewUser(user);
            //JdbcUtil.disConnect();
            return getUserDao().queryForEq("email", user.getEmail()).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createNewUser(User user) throws SQLException {
        User newUser = new User(user.getEmail(), user.getPicUri(), user.getName());
        getUserDao().create(newUser);
        getStatusDao().create(newUser.getStatus());
    }

    private Dao<User, String> getUserDao(){
        return JdbcUtil.connect(User.class);
    }

    private Dao<Status, String> getStatusDao(){
        return JdbcUtil.connect(Status.class);
    }
}
