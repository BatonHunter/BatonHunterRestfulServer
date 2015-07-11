package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.TreasureService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.post;

/**
 * Created by ianchiu on 2015/7/11.
 */
public class TreasureController {
    public TreasureController(final TreasureService treasureService){
        post("/treasures", (req, res) -> treasureService.gainTreasure(req.body()), json());
    }
}
