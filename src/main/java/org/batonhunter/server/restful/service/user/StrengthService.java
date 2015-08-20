package org.batonhunter.server.restful.service.user;

import org.batonhunter.server.restful.model.user.User;
import org.batonhunter.server.restful.util.JsonUtil;

import java.sql.SQLException;

import static org.batonhunter.server.restful.util.JdbcUtil.getDao;

/**
 * Created by ianchiu on 2015/8/18.
 */
public class StrengthService {
    public Boolean createStrength(String email, String body){
        User user = new UserService().getUser(email);
        User strength = JsonUtil.fromJson(body, User.class);

        user.setStrength(strength.getStrength());
        user.setCategory(strength.getCategory());
        user.setRole(strength.getRole());

        try {
            getDao(User.class).update(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
