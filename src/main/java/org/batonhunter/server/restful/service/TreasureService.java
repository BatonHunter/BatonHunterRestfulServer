package org.batonhunter.server.restful.service;

import com.google.gson.JsonObject;
import com.j256.ormlite.dao.Dao;
import org.batonhunter.server.restful.model.Treasure;
import org.batonhunter.server.restful.model.user.Status;
import org.batonhunter.server.restful.util.JdbcUtil;
import org.batonhunter.server.restful.util.JsonUtil;

import java.sql.SQLException;

/**
 * Created by ianchiu on 2015/7/11.
 */
public class TreasureService {

    public JsonObject gainTreasure(String body) {
        Treasure treasure = JsonUtil.fromJson(body, Treasure.class);
        try {
            Status status = new UserService().getUser(treasure.getEmail()).getStatus();
            status.update(treasure.getTreasure().getMoney(), treasure.getTreasure().getExp(), 0, 0);
            getStatusDao().update(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("money", treasure.getTreasure().getMoney());
        jsonObject.addProperty("exp", treasure.getTreasure().getExp());
        return jsonObject;
    }

    private Dao<Status, String> getStatusDao() {
        return JdbcUtil.connect(Status.class);
    }
}
