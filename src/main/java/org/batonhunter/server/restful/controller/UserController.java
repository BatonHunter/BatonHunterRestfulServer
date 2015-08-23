package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.user.JobService;
import org.batonhunter.server.restful.service.user.StrengthService;
import org.batonhunter.server.restful.service.user.UserService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.*;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class UserController {

    public UserController(final UserService userService,
                          final StrengthService strengthService,
                          final JobService jobService) {
        //Direct related to User object
        post("/users", (req, res) -> userService.createUser(req.body()), json());
        get("/users/:email", (req, res) -> userService.getUser(req.params(":email")), json());

        //Related to Strength of the user
        post("/users/*/strength", (req, res) -> strengthService.createStrength(req.splat()[0], req.body()), json());

        //Related to Job of the user
        post("/users/*/job", (req, res) -> jobService.addJob(req.splat()[0], req.body()), json());
        put("/users/*/job/*/task/*", (req, res) -> jobService.completedTask(req.splat()[0], req.splat()[1], req.splat()[2]), json());
        delete("/users/*/job/*", (req, res) -> jobService.deleteJob(req.splat()[0], req.splat()[1]), json());

        post("/users/*/card", (req, res) -> userService.addCard(req.splat()[0], req.body()), json());
    }
}
