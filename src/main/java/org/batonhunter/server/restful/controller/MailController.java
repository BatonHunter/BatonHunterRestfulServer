package org.batonhunter.server.restful.controller;

import org.batonhunter.server.restful.service.MailService;

import static org.batonhunter.server.restful.util.JsonUtil.json;
import static spark.Spark.post;

/**
 * Created by ianchiu on 2015/8/22.
 */
public class MailController {

    public MailController(final MailService mailService){
        post("/emails", (req, res) -> mailService.sendEmail(req.body()), json());
    }
}
