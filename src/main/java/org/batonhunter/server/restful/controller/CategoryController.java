package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.gamedata.CategoryService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.get;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class CategoryController {
    public CategoryController(final CategoryService categoryService){
        //return all job in categories by title
        get("/categories/*/job", (req, res) -> categoryService.getJobs(req.splat()[0]), json());
        //return all categories
        get("/categories", (req, res) -> categoryService.getCategories(), json());

        //return a random question base on jobId and taskId
        get("/jobs/*/task/*/question", (req, res) -> categoryService.getRandomQuestion(req.splat()[0], req.splat()[1]), json());
        //return task by jobId and taskId
        get("/jobs/*/task/*", (req, res) -> categoryService.getTask(req.splat()[0], req.splat()[1]), json());
        //return all task in job by jobId
        get("/jobs/*/task", (req, res) -> categoryService.getTasks(req.splat()[0]), json());
        //return a random question base on jobId only
        get("/jobs/*/question", (req, res) -> categoryService.getRandomQuestion(req.splat()[0]), json());
        //return job by jobId
        get("/jobs/*", (req, res) -> categoryService.getJob(req.splat()[0]), json());
    }
}
