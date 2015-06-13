package org.batonhunter.server.restful.service;

import com.j256.ormlite.dao.Dao;
import org.batonhunter.server.restful.model.User;
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
            result = getDao().queryForEq("email", email);
            //JdbcUtil.disConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user = result.size()!=0?result.get(0):null;
        return user;
    }

    public Boolean modifyStrength(String email, String body){
        User user = this.getUser(email);
        user.setStrength(JsonUtil.fromJson(body, User.class).getStrength());
        try {
            getDao().update(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean createUser(String body){
        User user = JsonUtil.fromJson(body, User.class);
        if(user.getEmail().isEmpty()||user.getName().isEmpty()||user.getPicUri().isEmpty()){
            return false;
        }
        
        try {
            getDao().create(new User(user.getEmail(), user.getPicUri(), user.getName()));
            //JdbcUtil.disConnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Dao<User, String> getDao(){
        return JdbcUtil.connect(User.class);
    }
}
