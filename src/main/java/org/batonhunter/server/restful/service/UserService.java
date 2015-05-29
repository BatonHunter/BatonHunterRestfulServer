package org.batonhunter.server.restful.service;

import org.batonhunter.server.restful.model.User;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class UserService {
    public User getUser(String email){
        return new User(email, null, null);
    }

    public Boolean createUser(String email, String picUri, String name){

        return true;
    }
}
