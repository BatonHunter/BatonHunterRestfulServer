package org.batonhunter.server.restful;

import static spark.Spark.get;

/**
 * Created by ianchiu on 2015/5/28.
 */
public class Main {
    public static void main(String args[]){
        get("/hello", (req, res) -> "Hello World");
    }
}