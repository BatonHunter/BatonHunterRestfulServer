package org.batonhunter.server.restful.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.lang.reflect.Type;

/**
 * Created by ianchiu on 2015/5/30.
 */
public class JsonUtil {
    public static String toJson(Object object){
        return new Gson().toJson(object);
    }

    public static <E> E fromJson(String json, Class<E> convertTo){
        return new Gson().fromJson(json, convertTo);
    }

    public static <E> E fromJson(String json, Type type){
        return new Gson().fromJson(json, type);
    }

    public static ResponseTransformer json(){
        return JsonUtil::toJson;
    }
}
