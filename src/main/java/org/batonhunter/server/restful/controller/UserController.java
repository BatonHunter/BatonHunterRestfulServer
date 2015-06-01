package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.UserService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class UserController {

    public UserController(final UserService userService){
        post("/user", (req, res) -> userService.createUser(req.body()), json());
        get("/user/:email", (req, res) -> userService.getUser(req.params(":email")), json());
    }
}
