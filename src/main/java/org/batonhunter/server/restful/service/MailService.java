package org.batonhunter.server.restful.service;

import org.batonhunter.server.restful.model.Email;
import org.batonhunter.server.restful.util.JsonUtil;

/**
 * Created by ianchiu on 2015/8/22.
 */
public class MailService {

    public String sendEmail(String body){
        Email email = JsonUtil.fromJson(body, Email.class);
        return email.send();
    }
}
