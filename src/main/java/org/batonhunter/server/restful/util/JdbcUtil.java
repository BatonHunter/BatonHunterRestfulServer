package org.batonhunter.server.restful.util;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by ianchiu on 2015/5/31.
 */
public class JdbcUtil {
    private static ConnectionSource connectionSource;
    //for testing in in-mem db
    private static final String DATABASE_URL = "jdbc:h2:mem:test";

    //for heroku
    //private static final String DATABASE_URL = "";

    public static Dao connect(Class classForDao){
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
            //in case the table have not been created
            TableUtils.createTableIfNotExists(connectionSource, classForDao);
            return DaoManager.createDao(connectionSource, classForDao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disConnect(){
        try {
            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
