package org.batonhunter.server.restful;

import org.batonhunter.server.restful.controller.UserController;
import org.batonhunter.server.restful.service.UserService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * Created by ianchiu on 2015/5/28.
 */
public class Main {
    public static void main(String args[]){
        port(Integer.parseInt(args[0]));
        after((req, res) -> res.type("application/json"));
        new UserController(new UserService());

        //for testing purpose
        get("/hello", (req, res) -> "Hello World", json());
    }
}