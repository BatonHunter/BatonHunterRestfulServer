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
    }
}