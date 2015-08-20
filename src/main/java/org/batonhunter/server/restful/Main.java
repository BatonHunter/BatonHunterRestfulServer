package org.batonhunter.server.restful;

import org.batonhunter.server.restful.controller.TreasureController;
import org.batonhunter.server.restful.controller.UserController;
import org.batonhunter.server.restful.service.user.JobService;
import org.batonhunter.server.restful.service.user.StrengthService;
import org.batonhunter.server.restful.service.TreasureService;
import org.batonhunter.server.restful.service.user.UserService;

import static spark.Spark.*;
import static spark.SparkBase.port;

/**
 * Created by ianchiu on 2015/5/28.
 */
public class Main {
    public static void main(String args[]){
        port(Integer.parseInt(args[0]));
        options("/*", (req, res) -> {
            String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
            if (null != accessControlRequestHeaders) {
                res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
            if (null != accessControlRequestMethod) {
                res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((req, res)-> res.header("Access-Control-Allow-Origin", "*"));
        after((req, res) -> res.type("application/json"));

        new UserController(new UserService(), new StrengthService(), new JobService());
        new TreasureController(new TreasureService());
    }
}