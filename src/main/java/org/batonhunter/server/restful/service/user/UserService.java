package org.batonhunter.server.restful.service.user;

import org.batonhunter.server.restful.model.user.Status;
import org.batonhunter.server.restful.model.user.User;
import org.batonhunter.server.restful.util.JsonUtil;

import java.sql.SQLException;
import java.util.List;

import static org.batonhunter.server.restful.util.JdbcUtil.getDao;
import static org.batonhunter.server.restful.util.UserHelper.removeInfinityReferenceForUser;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class UserService {

    public User getUser(String email){
        List<User> users = null;
        try {
            users = getDao(User.class).queryForEq("email", email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = users.size()!=0?users.get(0):null;
        return removeInfinityReferenceForUser(user);
    }

    public User createUser(String body){
        User user = JsonUtil.fromJson(body, User.class);
        if(user.getEmail().isEmpty()||user.getName().isEmpty()||user.getPicUri().isEmpty()){
            return null;
        }
        try {
            if(null == getUser(user.getEmail())){
                User newUser = new User(user.getEmail(), user.getPicUri(), user.getName());
                getDao(User.class).create(newUser);
                getDao(Status.class).create(newUser.getStatus());
            }
            return getUser(user.getEmail());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
