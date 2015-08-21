package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.gamedata.CategoryService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.get;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class CategoryController {
    public CategoryController(final CategoryService categoryService){
        get("/categories", (req, res) -> categoryService.getAllCategory(), json());
        get("/categories/*/job", (req, res) -> categoryService.getAllJob(req.splat()[0]), json());

        get("/jobs/*/task", (req, res) -> categoryService.getTasks(req.splat()[0]), json());
        get("/jobs/*/task/*", (req, res) -> categoryService.getTaskById(req.splat()[0], req.splat()[1]), json());

        get("/question/*/*", (req, res) -> categoryService.getRandomQuestion(req.splat()[0], req.splat()[1]), json());
    }
}
